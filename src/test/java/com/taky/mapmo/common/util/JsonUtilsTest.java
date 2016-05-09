package com.taky.mapmo.common.util;

import static org.junit.Assert.*;

import org.junit.Test;

import com.taky.mapmo.map.model.Address;
import com.taky.mapmo.map.model.MapInfo;

public class JsonUtilsTest {
	@Test
	public void testConvertToMapInfo() throws Exception {
		MapInfo result = JsonUtils.convertToNaver(
				"{\"result\": {\"total\": \"2\",\"userquery\": \"127.1052133,37.3595316\",\"items\": [{\"address\":\"경기도 성남시 분당구 정자동 178-1\",\"addrdetail\": {\"country\": \"대한민국\",\"sido\": \"경기도\",\"sigugun\": \"성남시 분당구\",\"dongmyun\": \"정자동\",\"rest\": \"178-1\"},\"isRoadAddress\": false,\"point\": {\"x\": \"127.1052208\",\"y\": \"37.3595122\"}}, {\"address\": \"경기도 성남시 분당구 불정로 6 그린팩토리\",\"addrdetail\": {\"country\": \"대한민국\",\"sido\": \"경기도\",\"sigugun\": \"성남시 분당구\", \"dongmyun\": \"불정로\",\"rest\": \"6 그린팩토리\"},\"isRoadAddress\": true,\"point\": {\"x\": \"127.1052133\",\"y\": \"37.3595316\" }}]}}");
		
		Address address = result.getAddress();
		
		System.out.println(address.getGibunAddress());
		System.out.println(address.getRoadAddress());
		System.out.println(address.getX());
		System.out.println(address.getY());
	}
}
