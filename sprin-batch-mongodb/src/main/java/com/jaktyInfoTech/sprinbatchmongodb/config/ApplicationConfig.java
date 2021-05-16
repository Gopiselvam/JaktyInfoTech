package com.jaktyInfoTech.sprinbatchmongodb.config;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.data.MongoItemReader;
import org.springframework.batch.item.xml.StaxEventItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.xstream.XStreamMarshaller;

import com.jaktyInfoTech.sprinbatchmongodb.mail.MailUtil;
import com.jaktyInfoTech.sprinbatchmongodb.model.Person;

@Configuration
public class ApplicationConfig {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Autowired
	private MongoTemplate mongoTemplate;

	@Autowired
	private MailUtil mailUtil;

	@Bean
	public MongoItemReader<Person> reader() {
		MongoItemReader<Person> reader = new MongoItemReader<>();
		reader.setTemplate(mongoTemplate);
		reader.setQuery("{}");
		reader.setTargetType(Person.class);
		reader.setSort(new HashMap<String, Sort.Direction>() {
			{
				put("custId", Direction.DESC);
			}
		});
		return reader;
	}

	@Bean
	public StaxEventItemWriter<Person> writer() {
		StaxEventItemWriter<Person> writer = new StaxEventItemWriter<Person>();
		writer.setRootTagName("Persons");
		writer.setResource(new FileSystemResource("xml/bank.xml"));
		writer.setMarshaller(marshaller());
		return writer;
	}

	private XStreamMarshaller marshaller() {
		// TODO Auto-generated method stub
		XStreamMarshaller marshaller = new XStreamMarshaller();
		Map<String, Class> map = new HashMap<>();
		map.put("Person", Person.class);
		marshaller.setAliases(map);
		return marshaller;
	}

	@Bean
	public Step step1() {
		return stepBuilderFactory.get("step1").<Person, Person>chunk(10).reader(reader()).processor(process())
				.writer(writer()).build();
	}

	@Bean
	public Job runJob() {
		return jobBuilderFactory.get("report generation").flow(step1()).end().build();
	}

	public ItemProcessor<Person, Person> process() {
		ItemProcessor<Person, Person> process = new ItemProcessor<Person, Person>() {

			@Override
			public Person process(Person person) throws Exception {
				// TODO Auto-generated method stub
				if ("Pending".equalsIgnoreCase(person.getStatus())) {
					String msg = mailUtil.sendMail(person.getEmail(), buildMessage(person));
					System.out.println(msg);
					return person;
				}
				return null;
			}

			private String buildMessage(Person person) {
				// TODO Auto-generated method stub
				String mailBody = "Dear" + person.getName() + "," + "\n" + "statement of your credit card ending with "
						+ person.hashCode() + " has been generated " + "\n" + "Due amount : " + person.getOutstanding()
						+ "\n" + "last payment date : "
						+ new SimpleDateFormat("yyyy/MM/dd HH:mm:ss a").format(new Date()) + "\n" + "\n"
						+ "If you already paid please ignore this mail. " + "\n" + "Thanks for using our service.";
				return mailBody;
			}

		};
		return process;
	}

}
