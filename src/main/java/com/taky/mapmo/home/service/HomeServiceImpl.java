package com.taky.mapmo.home.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taky.mapmo.home.mapper.HomeMapper;

/**
 * 
 * @author SeongTak.Yoon
 */
@Service
public class HomeServiceImpl implements HomeService {
	
	@Autowired
	private HomeMapper homeMapper;
	
	public HomeMapper getHomeMapper() {
		return homeMapper;
	}

	public void setHomeMapper(HomeMapper homeMapper) {
		this.homeMapper = homeMapper;
	}

}
