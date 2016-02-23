package com.taky.mapmo.user.mapper;

import org.springframework.stereotype.Repository;

import com.taky.mapmo.user.model.User;

@Repository
public interface UserMapper {
	public void insertUser();
	public User selectUser(String id);
}
