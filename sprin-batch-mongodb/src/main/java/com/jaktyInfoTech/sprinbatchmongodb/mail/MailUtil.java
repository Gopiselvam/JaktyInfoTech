package com.jaktyInfoTech.sprinbatchmongodb.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class MailUtil {
	
	@Autowired
	private JavaMailSender mailSender;
	
	public String sendMail(String to, String textBody) {
		String msg = "";
		SimpleMailMessage message = new SimpleMailMessage();
		try {
			message.setTo(to);
			message.setText(textBody);
			message.setSubject("Payment Dues Alert");
			message.setFrom("gopiselvam96@gmail.com");
			mailSender.send(message);
			msg = "Mail Triggered Successfully to : "+to;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return msg;
	}

}
