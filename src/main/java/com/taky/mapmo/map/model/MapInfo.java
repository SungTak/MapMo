package com.taky.mapmo.map.model;

/**
 * Map이라고 하고 싶었지만 JDK의 HashMap과 헷갈릴 것 같아서 suffix로 info를 붙임
 * 
 * @author YoonSungTak
 *
 */
public class MapInfo {
	private Address address;

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
}
