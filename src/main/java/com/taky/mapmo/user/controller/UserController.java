package com.taky.mapmo.user.controller;

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
	
	@Autowired
	private UserService userService;
	
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
