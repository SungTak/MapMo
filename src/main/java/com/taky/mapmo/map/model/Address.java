package com.taky.mapmo.map.model;

import java.util.Date;

public class Address {
	private double x;
	private double y;
	private double z;
	/** 도로명 주소 */
	private String roadAddress;
	/** 지번 주소 (구 주소) */
	private String gibunAddress;
	private Date regdate;
	private Date moddate;
	
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

	public String getRoadAddress() {
		return roadAddress;
	}

	public void setRoadAddress(String roadAddress) {
		this.roadAddress = roadAddress;
	}

	public String getGibunAddress() {
		return gibunAddress;
	}

	public void setGibunAddress(String gibunAddress) {
		this.gibunAddress = gibunAddress;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public Date getModdate() {
		return moddate;
	}

	public void setModdate(Date moddate) {
		this.moddate = moddate;
	}
}
