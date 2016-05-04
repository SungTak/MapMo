package com.taky.mapmo.map.service;

import org.springframework.stereotype.Service;

import com.taky.mapmo.map.model.MapInfo;

@Service
public interface MapService {
	public MapInfo findMapInfo(MapInfo mapInfo) throws Exception; 
}
