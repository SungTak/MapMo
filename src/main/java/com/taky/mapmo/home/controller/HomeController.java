package com.taky.mapmo.home.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * MapMo의 메인 홈 관리
 * 
 * @author Taky
 *
 */
@RestController
public class HomeController {
	
	@RequestMapping(value = "/")
	public String findHome() {
		return "Hello World";
	}

}
