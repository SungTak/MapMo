package com.taky.mapmo.user.mapper;

import org.springframework.stereotype.Repository;

import com.taky.mapmo.user.model.Awaiter;

@Repository
public interface AwaiterMapper {
	public void insertAwaiter(Awaiter awaiter) throws Exception;
	public Awaiter selectAwaiter(String id) throws Exception;
	public Awaiter selectAwaiterByUrl(String accreditationUrl) throws Exception;
	public void deleteAwaiter(String id) throws Exception;
}
