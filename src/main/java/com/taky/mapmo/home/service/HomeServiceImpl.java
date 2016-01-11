package com.taky.mapmo.home.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taky.mapmo.home.mapper.HomeMapper;

@Service
public class HomeServiceImpl implements HomeService {
	@Autowired
	private HomeMapper homeMapper;
	
	@Override
	public void registUser() {
		// TODO 트랜잭션
		System.out.println("service input here");
		homeMapper.insertUser();
	}

	public HomeMapper getHomeMapper() {
		return homeMapper;
	}

	public void setHomeMapper(HomeMapper homeMapper) {
		this.homeMapper = homeMapper;
	}

}
