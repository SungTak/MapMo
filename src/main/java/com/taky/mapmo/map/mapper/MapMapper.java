package com.taky.mapmo.map.mapper;

import org.springframework.stereotype.Repository;

import com.taky.mapmo.map.model.Address;
import com.taky.mapmo.map.model.MapInfo;

@Repository
public interface MapMapper {
	public MapInfo selectMapByRangePoint(Address address) throws Exception;
	
	public MapInfo selectMap(MapInfo mapInfo) throws Exception;
	
	public void insertMap(MapInfo mapInfo) throws Exception;
}
