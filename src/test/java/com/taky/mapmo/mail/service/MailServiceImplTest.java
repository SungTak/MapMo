package com.taky.mapmo.mail.service;

import org.junit.Test;

import com.taky.mapmo.user.model.Awaiter;

public class MailServiceImplTest {
	@Test
	public void testSendMail() throws Exception {
		// http://docs.spring.io/spring/docs/current/spring-framework-reference/html/mail.html
		MailService sut = new MailServiceImpl();
		
		Awaiter awaiter = new Awaiter();
		awaiter.setEmail("zergyst1988@naver.com");
		
		sut.send(awaiter);
	}
}
