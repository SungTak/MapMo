package com.taky.mapmo.map.model;

public enum AddressType {
	GIBUN("gibun"),
	ROAD("road");
	
	private String type;
	
	private AddressType(String type) {
		this.type = type;
	}
	
	private String getType() {
		return type;
	}
}
