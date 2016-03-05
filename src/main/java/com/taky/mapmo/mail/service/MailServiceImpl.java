package com.taky.mapmo.mail.service;

import java.util.Properties;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.taky.mapmo.user.model.Awaiter;

public class MailServiceImpl implements MailService {

	@Override
	public void send(Awaiter awaiter) throws Exception {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setFrom("mapmo@taky.com");
		simpleMailMessage.setTo(awaiter.getEmail());
		simpleMailMessage.setText("안녕하세요, 맵모입니다");
		
		Properties mailProperties = new Properties();
		mailProperties.put("mail.smtp.starttls.enable", true);
		mailProperties.put("mail.smtp.auth", true);
		
		MailSender sender = new JavaMailSenderImpl();
		((JavaMailSenderImpl)sender).setHost("smtp.gmail.com");
		((JavaMailSenderImpl)sender).setPort(587);
		((JavaMailSenderImpl)sender).setUsername("takymapmo@gmail.com");
		((JavaMailSenderImpl)sender).setPassword("20072725");
		((JavaMailSenderImpl)sender).setJavaMailProperties(mailProperties);
		sender.send(simpleMailMessage);
	}
}
