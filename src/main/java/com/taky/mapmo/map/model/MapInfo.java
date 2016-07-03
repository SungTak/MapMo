package com.taky.mapmo.map.model;

import org.apache.ibatis.type.Alias;
import org.springframework.stereotype.Component;

/**
 * Map이라고 하고 싶었지만 JDK의 HashMap과 헷갈릴 것 같아서 suffix로 info를 붙임
 * 
 * @author YoonSungTak
 *
 */
@Alias("mapInfo")
@Component
public class MapInfo {
	/** MapMo 검색 X 좌표 */
	private double x;
	/** MapMo 검색 Y 좌표 */
	private double y;
	/** MapMo 검색 Z 좌표(층수) */
	private double z;

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

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getZ() {
		return z;
	}

	public void setZ(double z) {
		this.z = z;
	}
}
