package com.taky.mapmo.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String requestJoin() throws Exception {
		logger.info("### 신규 가입을 요청하여 회원가입 페이지로 이동합니다.");
		return "user/join";
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	@ResponseBody
	public String submitJoin() throws Exception {
		logger.info("### 신규 회원 가입 정보 제출.");
		
		//TODO 화면단 방어로직 다시 필요함 서버단체크 필수
		// 암호화 확인 
		return "맵모 회원이 되신 것을 환영합니다!";
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
