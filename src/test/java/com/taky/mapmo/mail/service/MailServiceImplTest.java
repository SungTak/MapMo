package com.taky.mapmo.mail.service;

import org.junit.Ignore;
import org.junit.Test;

import com.taky.mapmo.mail.model.Mail;
import com.taky.mapmo.user.model.Awaiter;

public class MailServiceImplTest {
	@Test
	@Ignore
	public void testSend() throws Exception {
		// 실제로 TC를 수행하면 진짜 메일을 보냄 ㅎㅎ
		// http://docs.spring.io/spring/docs/current/spring-framework-reference/html/mail.html
		MailService sut = new MailServiceImpl();
		
		Awaiter awaiter = new Awaiter();
		awaiter.setEmail("zergyst1988@naver.com");
		
		Mail mail = new Mail();
		mail.setTitle("[MapMo] Test Code에서 보낸 메일입니다 ㅎㅎ");
		mail.setText("신규 회원 가입을 환영합니다!!! TEST");
		mail.setTo(awaiter.getEmail());
		
		sut.send(mail);
	}
}
