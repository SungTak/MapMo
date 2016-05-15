package com.taky.mapmo.map.model;

import java.util.Date;

import org.apache.ibatis.type.Alias;

@Alias("address")
public class Address {
	private double x;
	private double y;
	private double z;
	private String address;
	private Date regdate;
	private Date moddate;
	private AddressType type;
	
	/**
	 * 기본 생성자
	 */
	public Address() {
		
	}
	
	/**
	 * type는 주소 객체의 특성을 가지고 있으므로 
	 * 최초 생성시에만 set할 수 있으며 이 후 이 정보는 수정할 수 없도록 하였음
	 * 
	 * 예) 지번 구 주소, 도로명 주소
	 * 
	 * @param type 주소 Enum 객체
	 */
	public Address(AddressType type) {
		this.type = type;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public AddressType getType() {
		return type;
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
