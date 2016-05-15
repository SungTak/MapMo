package com.taky.mapmo.map.model;

import org.apache.ibatis.type.Alias;

/**
 * Map이라고 하고 싶었지만 JDK의 HashMap과 헷갈릴 것 같아서 suffix로 info를 붙임
 * 
 * @author YoonSungTak
 *
 */
@Alias("mapInfo")
public class MapInfo {
	private Address gibunAddress;
	private Address roadAddress;

	public Address getGibunAddress() {
		return gibunAddress;
	}

	public void setGibunAddress(Address gibunAddress) {
		this.gibunAddress = gibunAddress;
	}

	public Address getRoadAddress() {
		return roadAddress;
	}

	public void setRoadAddress(Address roadAddress) {
		this.roadAddress = roadAddress;
	}
}
