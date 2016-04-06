package com.taky.mapmo.signin.controller;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import com.taky.mapmo.common.constant.Constants;
import com.taky.mapmo.user.model.User;
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
	
	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public ModelAndView submit(@RequestParam("id") String id, @RequestParam("password") String password) throws Exception {
		logger.info("### {}님이 로그인을 시도하였습니다", id);
		// TIP : 모델앤뷰.. import 경로 잘보자 -_-
		ModelAndView mav = new ModelAndView("signin/signin");
		
		User user = UserService.findUser(id);
		if (user == null) {
			mav.addObject("message", "등록된 ID가 없습니다.");
			return mav;
		}
		
		String cipherPassword = DigestUtils.sha256Hex(password + Constants.CIPHER_SALT);
		
		if (StringUtils.equals(user.getPassword(), cipherPassword)) {
			mav.setViewName("main");
			return mav;
		}
		
		mav.addObject("message", "비밀번호가 틀렸습니다.");
		return mav;
	}

	public UserService getUserService() {
		return UserService;
	}

	public void setUserService(UserService userService) {
		UserService = userService;
	}
}
