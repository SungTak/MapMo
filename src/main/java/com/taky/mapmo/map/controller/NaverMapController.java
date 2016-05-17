package com.taky.mapmo.map.controller;

import org.apache.http.client.methods.HttpGet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.taky.mapmo.common.util.HttpUtils;
import com.taky.mapmo.common.util.JsonUtils;
import com.taky.mapmo.map.model.Address;
import com.taky.mapmo.map.model.MapInfo;
import com.taky.mapmo.map.service.MapService;

@RestController
@RequestMapping("/naver")
public class NaverMapController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private MapInfo mapInfo;
	
	@Autowired
	private Address address;
	
	@Autowired
	private MapService mapServiece;
	
	@RequestMapping(value = "/search/address/x/{x}/y/{y:.+}", method = RequestMethod.GET)
	public String searchAddress(@PathVariable("x") String x, @PathVariable("y") String y) {
		MapInfo resultMapInfo = null;
		
		try {
			address.setX(Double.valueOf(x));
			address.setY(Double.valueOf(y));
		
			resultMapInfo = mapServiece.findMapByRangePoint(address);

			if (resultMapInfo == null) {
				String url = "https://openapi.naver.com/v1/map/reversegeocode?"
						+ "query=" + x + "," + y + "&encoding=utf-8"; 
				
				// TODO 키 숨기자 -ㅅ-ㅋ
				HttpGet request = new HttpGet(url);
				request.addHeader("X-Naver-Client-Id", "");
				request.addHeader("X-Naver-Client-Secret", "");
				
				String naverMapJson = HttpUtils.request(request);
				
				MapInfo naverMapInfo = JsonUtils.convertToNaver(naverMapJson);
				// 사용자가 선택한 좌표를 저장
				naverMapInfo.setMinX(address.getX());
				naverMapInfo.setMaxX(address.getX());
				naverMapInfo.setMinY(address.getY());
				naverMapInfo.setMaxY(address.getY());

				mapServiece.modifyMap(naverMapInfo);
				
				return naverMapJson;
			} else {
				// 널이 아니면 여기서 처리합세 혹은 try안으로 
				
				return "";
			}		
			
		} catch (NumberFormatException e) {
			// TODO 예외들 어떻게 리턴할지 필요
			logger.warn("## 주소의 좌표는 숫자만 가능합니다. 올바른 요청을 주세요.", e);
		} catch (Exception e) {
			logger.error("## 주소를 찾는 과정에서 에러가 발생하였습니다.", e);
		}
		
		return "맵 찾기 테스트 중 ....";
	}

	public MapInfo getMapInfo() {
		return mapInfo;
	}

	public void setMapInfo(MapInfo mapInfo) {
		this.mapInfo = mapInfo;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public MapService getMapServiece() {
		return mapServiece;
	}

	public void setMapServiece(MapService mapServiece) {
		this.mapServiece = mapServiece;
	}
}
