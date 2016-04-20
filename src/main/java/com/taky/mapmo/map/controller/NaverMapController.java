package com.taky.mapmo.map.controller;

import org.apache.http.client.methods.HttpGet;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.taky.mapmo.common.util.HttpUtils;

@RestController
@RequestMapping("/naver")
public class NaverMapController {
	@RequestMapping(value = "/search/address/x/{x}/y/{y:.+}", method = RequestMethod.GET)
	public String searchAddress(@PathVariable("x") String x, @PathVariable("y") String y) {
		String url = "https://openapi.naver.com/v1/map/reversegeocode?"
				+ "query=" + x + "," + y + "&encoding=utf-8"; 
		
		// TODO 키 숨기자 -ㅅ-ㅋ
		HttpGet request = new HttpGet(url);
		request.addHeader("X-Naver-Client-Id", "");
		request.addHeader("X-Naver-Client-Secret", "");
		
		return HttpUtils.request(request);
	}
}
