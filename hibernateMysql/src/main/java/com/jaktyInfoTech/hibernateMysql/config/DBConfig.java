package com.jaktyInfoTech.hibernateMysql.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@PropertySource(value = { "classpath:application.properties" })
@Configuration
public class DBConfig {

	@Value("${jdbc.driverClassName}")
	private String driverClass;
	@Value("${jdbc.url}")
	private String url;
	@Value("${jdbc.username}")
	private String username;
	@Value("${jdbc.password}")
	private String password;
	@Value("${hibernate.dialect}")
	private String dialect;
	@Value("${hibernate.hbm2ddl.auto}")
	private String ddlauto;
	@Value("${hibernate.show_sql}")
	private String showsql;
	@Value("${hibernate.format_sql}")
	private String formatsql;
	
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource datasource = new DriverManagerDataSource(url, username, password);
		datasource.setDriverClassName(driverClass);
		return datasource;
	}
	
	
	
	private Properties getHibernateProperties() {
		Properties props = new Properties();
		props.put("hibernate.dialect", dialect);
		props.put("hibernate.hbm2ddl.auto", ddlauto);
		props.put("hibernate.show_sql", showsql);
		props.put("hibernate.format_sql", formatsql);
		return props;
	}
	
	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean factory = new LocalSessionFactoryBean();
		factory.setDataSource(getDataSource());
		factory.setHibernateProperties(getHibernateProperties());
		factory.setPackagesToScan(new String[] {"com.jaktyInfoTech.hibernateMysql.model"});
		return factory;
	}
	
	@Bean
	@Autowired
	public HibernateTransactionManager getTransactionManager(SessionFactory factory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(factory);
		return transactionManager;
	}

}
