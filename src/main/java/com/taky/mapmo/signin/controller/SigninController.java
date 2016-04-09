package com.taky.mapmo.signin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.taky.mapmo.user.service.UserService;

/**
 * 
 * @author SeongTak.Yoon
 *
 */
@Controller
public class SigninController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserService UserService;
	
	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public String singin() {
		return "signin/signin";
	}

	public UserService getUserService() {
		return UserService;
	}

	public void setUserService(UserService userService) {
		UserService = userService;
	}
}
