package com.taky.mapmo.map.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.taky.mapmo.map.mapper.MapMapper;
import com.taky.mapmo.map.model.Address;
import com.taky.mapmo.map.model.MapInfo;

@Service
public class MapServiceImpl implements MapService {
	@Autowired
	private MapMapper mapMapper;

	@Override
	public MapInfo findMapByRangePoint(Address address) throws Exception {
		return mapMapper.selectMapByRangePoint(address);
	}

	@Override
	public MapInfo findMap(MapInfo mapInfo) throws Exception {
		return mapMapper.selectMap(mapInfo);
	}

	public MapMapper getMapMapper() {
		return mapMapper;
	}

	public void setMapMapper(MapMapper mapMapper) {
		this.mapMapper = mapMapper;
	}

	@Override
	@Transactional
	public boolean modifyMap(MapInfo mapInfo) throws Exception {
		// 파싱한 데이터로 다시 조회 (x,y)
		MapInfo mapMoMapInfo = this.findMap(mapInfo);
		
		if (mapMoMapInfo == null) {
			// 요청 좌표들에 대한 데이터를 우리 DB에 저장하기(없으면)
			
		} else {
			// 있으면 업데이트만, 서비스레이어에서 처리하자.
			
		}
		
		return false;
	}

}