package com.taky.mapmo.user.service;

import com.taky.mapmo.user.model.Awaiter;

public interface AwaiterService {
	public void registerAwatier(Awaiter awaiter) throws Exception;
	public Awaiter findAwatier(String id) throws Exception;
	public Awaiter findAwaiter(Awaiter awaiter) throws Exception;
	public Awaiter findAwatierByUrl(String accreditationUrl) throws Exception;
	public void removeAwaiter(String id) throws Exception;
}
