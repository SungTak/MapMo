package com.taky.mapmo.user.mapper;

import org.springframework.stereotype.Repository;

import com.taky.mapmo.user.model.Awaiter;

@Repository
public interface AwaiterMapper {
	public void insertAwaiter(Awaiter awaiter);
}
