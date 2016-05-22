package com.taky.mapmo.common.util;

import java.util.ArrayList;
import java.util.List;

import com.taky.mapmo.map.model.MapInfo;
import com.taky.mapmo.map.model.NaverMap;
import com.taky.mapmo.map.model.NaverMap.Address;
import com.taky.mapmo.map.model.NaverMap.Point;
import com.taky.mapmo.map.model.NaverMap.Result;

public class ModelConverter {
	public static NaverMap convertTo(MapInfo mapInfo) {
		NaverMap naverMap = new NaverMap();
		
		// 도로명주소 정보 세팅
		Point roadAddressPoint = naverMap.createPoint();
		roadAddressPoint.setX(mapInfo.getRoadAddress().getX());
		roadAddressPoint.setY(mapInfo.getRoadAddress().getY());
		
		Address roadAddress = naverMap.createAddress();
		roadAddress.setAddress(mapInfo.getRoadAddress().getAddress());
		roadAddress.setRoadAddress(true);
		roadAddress.setPoint(roadAddressPoint);
		
		// 구주소 정보 세팅
		Point gibunAddressPoint = naverMap.createPoint();
		gibunAddressPoint.setX(mapInfo.getGibunAddress().getX());
		gibunAddressPoint.setY(mapInfo.getGibunAddress().getY());
		
		Address gibunAddress = naverMap.createAddress();
		gibunAddress.setAddress(mapInfo.getGibunAddress().getAddress());
		gibunAddress.setRoadAddress(false);
		gibunAddress.setPoint(gibunAddressPoint);
		
		List<Address> items = new ArrayList<>();
		items.add(roadAddress);
		items.add(gibunAddress);

		Result result = naverMap.createResult();
		result.setItems(items);
		
		naverMap.setResult(result);
		return naverMap;
	}
}
