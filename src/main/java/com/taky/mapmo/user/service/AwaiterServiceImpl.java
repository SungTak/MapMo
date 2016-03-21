package com.taky.mapmo.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.taky.mapmo.user.mapper.AwaiterMapper;
import com.taky.mapmo.user.model.Awaiter;

@Service
public class AwaiterServiceImpl implements AwaiterService {
	@Autowired
	private AwaiterMapper awaiterMapper;
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void registerAwatier(Awaiter awaiter) throws Exception {
		awaiterMapper.insertAwaiter(awaiter);
	}

	@Override
	public Awaiter findAwatier(String id) throws Exception {
		return awaiterMapper.selectAwaiter(id);
	}
	
	@Override
	public Awaiter findAwaiter(Awaiter awaiter) throws Exception {
		return awaiterMapper.selectAwaiterBy(awaiter);
	}
	
	@Override
	public Awaiter findAwatierByUrl(String accreditationUrl) throws Exception {
		return awaiterMapper.selectAwaiterByUrl(accreditationUrl);
	}
	
	@Override
	public void removeAwaiter(String id) throws Exception {
		awaiterMapper.deleteAwaiter(id);
	}

	public AwaiterMapper getAwaiterMapper() {
		return awaiterMapper;
	}

	public void setAwaiterMapper(AwaiterMapper awaiterMapper) {
		this.awaiterMapper = awaiterMapper;
	}

}
