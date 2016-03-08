package com.taky.mapmo.mail.service;

import java.util.Properties;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import com.taky.mapmo.mail.model.Mail;

@Service
public class MailServiceImpl implements MailService {

	@Override
	public void send(Mail mail) throws Exception {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setSubject(mail.getTitle());
		simpleMailMessage.setFrom(mail.getFrom());
		simpleMailMessage.setTo(mail.getTo());
		simpleMailMessage.setText(mail.getText());
		
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
