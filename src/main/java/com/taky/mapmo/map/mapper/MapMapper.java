package com.taky.mapmo.map.mapper;

import org.springframework.stereotype.Repository;

import com.taky.mapmo.map.model.MapInfo;

@Repository
public interface MapMapper {
	public MapInfo selectMapInfo(MapInfo mapInfo) throws Exception;
}
