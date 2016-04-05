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
import org.springframework.web.portlet.ModelAndView;

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
	
	@RequestMapping(value = "/signin/submit", method = RequestMethod.POST)
	public String submit(@RequestParam("id") String id, @RequestParam("password") String password) throws Exception {
		logger.info("### {}님이 로그인을 시도하였습니다", id);
		//ModelAndView mav = new ModelAndView("redirect:signin/signin");
		
		User user = UserService.findUser(id);
		if (user == null) {
		//	mav.addObject("message", "등록된 ID가 없습니다.");
		//	return mav;
			return "redirect:/signin"; //URL인듯..
		}
		
		String cipherPassword = DigestUtils.sha256Hex(password + Constants.CIPHER_SALT);
		
		if (StringUtils.equals(user.getPassword(), cipherPassword)) {
		//	mav.setViewName("redirect:main");
		//	return mav;
		}
		
//		mav.addObject("message", "비밀번호가 틀렸습니다.");
//		return mav;
		return "redirect:signin/signin";
	}

	public UserService getUserService() {
		return UserService;
	}

	public void setUserService(UserService userService) {
		UserService = userService;
	}
}
