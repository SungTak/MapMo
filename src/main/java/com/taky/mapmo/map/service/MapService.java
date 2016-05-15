package com.taky.mapmo.map.service;

import org.springframework.stereotype.Service;

import com.taky.mapmo.map.model.Address;
import com.taky.mapmo.map.model.MapInfo;

@Service
public interface MapService {
	/**
	 * <pre>
	 * 맵 정보를 좌표 범위로 찾아본다.
	 * 지도에서 무작위로 클릭된 좌표는 정확히 DB와 일치할 수 없기 때문
	 * </pre>
	 * 
	 * @param address 주소 객체
	 * @return 맵정보 객체
	 * @throws Exception
	 */
	public MapInfo findMapByRangePoint(Address address) throws Exception; 
	
	/**
	 * <pre>
	 * 맵 정보를 정확한 좌표로 찾는다.
	 * </pre>
	 * 
	 * @param mapInfo 맵정보 객체
	 * @return
	 * @throws Exception
	 */
	public MapInfo findMap(MapInfo mapInfo) throws Exception;
	
	/**
	 * <pre>
	 * 사용자의 맵 좌표 정보
	 * API로 제공된 맵 정보
	 * 
	 * 2가지 정보를 MapMo 맵에 수정하거나 신규인 경우 추가한다.
	 * 
	 * 네이버 API의 호출을 최대한 줄이기 위함, 호출 한도가 정해져 있음.
	 * </pre>
	 * 
	 * 
	 * @param mapInfo
	 * @return
	 * @throws Exception
	 */
	public boolean modifyMap(MapInfo mapInfo) throws Exception;
}
