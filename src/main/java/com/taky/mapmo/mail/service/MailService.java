package com.taky.mapmo.mail.service;

import com.taky.mapmo.mail.model.Mail;

public interface MailService {
	public void send(Mail mail) throws Exception;
}
