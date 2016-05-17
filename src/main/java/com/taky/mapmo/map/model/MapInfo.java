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
	private double minX;
	private double maxX;
	private double minY;
	private double maxY;

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

	public double getMinX() {
		return minX;
	}

	public void setMinX(double minX) {
		this.minX = minX;
	}

	public double getMaxX() {
		return maxX;
	}

	public void setMaxX(double maxX) {
		this.maxX = maxX;
	}

	public double getMinY() {
		return minY;
	}

	public void setMinY(double minY) {
		this.minY = minY;
	}

	public double getMaxY() {
		return maxY;
	}

	public void setMaxY(double maxY) {
		this.maxY = maxY;
	}
}
