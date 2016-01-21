package com.taky.mapmo.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.taky.mapmo.user.service.UserService;

/**
 * 
 * @author SeongTak.Yoon
 *
 */
@Controller
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/join")
	public String join() throws Exception {
		logger.info("### 신규 가입 요청");
		return "user/join";
	}
	
	@RequestMapping(value = "/signin")
	public ModelAndView registUser() throws Exception {
		System.out.println("signin controller");
		getUserService().registUser();
		System.out.println("success new user");
		
		ModelAndView model = new ModelAndView("signin/signin");
		model.addObject("result", "SUCCESS NEW USER");
		
		return model;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
