package com.taky.mapmo.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * <pre>
 * MapMo의 메인 홈 관리
 * 
 * RestController를 쓰면 자동으로 타임리프 설정을 src/main/resources/templates의
 * 타임 리프를 보지 않는다.
 * </pre>
 * 
 * @author Taky
 *
 */
@Controller
public class HomeController {
	
	@RequestMapping(value = "/")
	public ModelAndView findHome() {
		ModelAndView model = new ModelAndView("main");
		model.addObject("say", "hello~~!");
		return model;
	}
	
	@RequestMapping(value = "/exception") //tip /error은 기본 세팅
	public String findError(Model model) {
		model.addAttribute("say", "error!!");
		//Test
		return "main";
	}

}
