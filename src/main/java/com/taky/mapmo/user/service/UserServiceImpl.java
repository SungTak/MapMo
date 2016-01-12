package com.taky.mapmo.user.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.taky.mapmo.home.mapper.UserMapper;

/**
 * 
 * @author SeongTak.Yoon
 *
 */
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;

	/**
	 * <pre>
	 * rollbackFor : 발생한 Exception에 대해 트랜잭션 롤백 처리(하위 예외 포함)
	 * 
	 * 참고 : http://www.koreajava.com/2014/06/transactional-spring.html
	 * </pre>
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void registUser() throws Exception {
		System.out.println("service input here");
		getUserMapper().insertUser();
	}

	public UserMapper getUserMapper() {
		return userMapper;
	}

	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
}
