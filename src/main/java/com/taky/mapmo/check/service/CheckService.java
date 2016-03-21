package com.taky.mapmo.check.service;

import com.taky.mapmo.check.model.UserChecker;

public interface CheckService {
	public UserChecker checkUser(String id) throws Exception;
	
	public UserChecker checkUserByEmail(String email) throws Exception;
}
