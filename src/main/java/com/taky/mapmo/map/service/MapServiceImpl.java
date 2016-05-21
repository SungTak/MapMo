package com.taky.mapmo.map.service;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.taky.mapmo.map.mapper.MapMapper;
import com.taky.mapmo.map.model.Address;
import com.taky.mapmo.map.model.MapInfo;

@Service
public class MapServiceImpl implements MapService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
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
			this.insertMap(mapInfo);
		} else {
			MapInfo modifyPoint = new MapInfo();
			
			if (mapMoMapInfo.getMaxX() < mapInfo.getMaxX()) {
				modifyPoint.setMaxX(mapInfo.getMaxX());
			}
			
			if (mapMoMapInfo.getMinX() > mapInfo.getMinX()) {
				modifyPoint.setMinX(mapInfo.getMinX());
			}
			
			if (mapMoMapInfo.getMaxY() < mapInfo.getMaxY()) {
				modifyPoint.setMaxY(mapInfo.getMaxY());
			}
			
			if (mapMoMapInfo.getMinY() > mapInfo.getMinY()) {
				modifyPoint.setMinY(mapInfo.getMinY());
			}
			
			this.modifyMapPoint(modifyPoint);
		}
		
		return false;
	}

	@Override
	public boolean insertMap(MapInfo mapInfo) throws Exception {
		try {
			mapMapper.insertMap(mapInfo);
			return true;
		} catch (SQLException e) {
			logger.error("### map을 신규추가하는 과정에서 sql 에러가 발생하였습니다!", e);
			return false;
		}
	}
	
	/**
	 * 맵의 좌표를 수정한다.
	 * 트랜잭션이 되어 있지 않은 메서드이므로 private처리되어 있다.
	 * 
	 * @param mapInfo
	 * @return
	 * @throws Exception
	 */
	private boolean modifyMapPoint(MapInfo mapInfo) throws Exception {
		try {
			mapMapper.updateMap(mapInfo);
			return true;
		} catch (SQLException e) {
			logger.error("### map의 좌표를 수정하는 과정에서 sql 에러가 발생하였습니다!", e);
			return false;
		}
	}
}
