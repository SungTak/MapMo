package com.taky.mapmo.user.service;

import com.taky.mapmo.user.model.User;

/**
 * 유저의 가입 정보, 데이터 담당
 * 
 * @author SeongTak.Yoon
 *
 */
public interface UserService {
	public void registUser(String id) throws Exception;
	public User findUser(String id) throws Exception;
	public User findUser(User user) throws Exception;
}
