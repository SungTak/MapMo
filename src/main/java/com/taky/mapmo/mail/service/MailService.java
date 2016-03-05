package com.taky.mapmo.mail.service;

import com.taky.mapmo.user.model.Awaiter;

public interface MailService {
	public void send(Awaiter awaiter) throws Exception;
}
