package com.taky.mapmo.common.util;

import java.util.List;
import java.util.Map;

import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;

import com.taky.mapmo.map.model.Address;
import com.taky.mapmo.map.model.AddressType;
import com.taky.mapmo.map.model.MapInfo;

public class JsonUtils {
	/**
	 * 
	 * <pre>
	 * {
	"result": {
	    "total": 2,
	    "userquery": "127.1052133,37.3595316",
	    "items": [
	        {
	            "address": "경기도 성남시 분당구 정자동 178-1",
	            "addrdetail": {
	                "country": "대한민국",
	                "sido": "경기도",
	                "sigugun": "성남시 분당구",
	                "dongmyun": "정자동",
	                "rest": "178-1"
	            },
	            "isRoadAddress": false,
	            "point": {
	                "x": 127.1052208,
	                "y": 37.3595122
	            }
	        },
	        {
	            "address": "경기도 성남시 분당구 불정로 6 그린팩토리",
	            "addrdetail": {
	                "country": "대한민국",
	                "sido": "경기도",
	                "sigugun": "성남시 분당구",
	                "dongmyun": "불정로",
	                "rest": "6 그린팩토리"
	            },
	            "isRoadAddress": true,
	            "point": {
	                "x": 127.1052133,
	                "y": 37.3595316
	            }
	        }
	    ]
	}
	}
	 * </pre>
	 * 
	 * @param json
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static MapInfo convertToNaver(String json) {
		JsonParser jsonParser = JsonParserFactory.getJsonParser();
		Map<String, Object> resultMap = jsonParser.parseMap(json);

		Map<String, Object> result = (Map<String, Object>) resultMap.get("result");
		List<Map<String, Object>> items = (List<Map<String, Object>>) result.get("items");

		Address gibunAddress = new Address(AddressType.GIBUN);
		Address roadAddress = new Address(AddressType.ROAD);
		for (Map<String, Object> naverAddress : items) {
			boolean isRoadAddress = (boolean) naverAddress.get("isRoadAddress");
			Map<String, Object> point = (Map<String, Object>) naverAddress.get("point");
			
			// 도로명 주소를 우선으로 세팅한다.
			if (isRoadAddress) {
				roadAddress.setAddress((String) naverAddress.get("address"));
				roadAddress.setX(Double.valueOf((String) point.get("x")));
				roadAddress.setY(Double.valueOf((String) point.get("y")));
			} else {
				gibunAddress.setAddress((String) naverAddress.get("address"));
				gibunAddress.setX(Double.valueOf((String) point.get("x")));
				gibunAddress.setY(Double.valueOf((String) point.get("y")));
			}
		}
		
		MapInfo mapInfo = new MapInfo();
		mapInfo.setGibunAddress(gibunAddress);
		mapInfo.setRoadAddress(roadAddress);
		return mapInfo;
	}
}