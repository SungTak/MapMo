package com.taky.mapmo.user.model;

import java.util.Date;

import org.apache.ibatis.type.Alias;

@Alias("awaiter")
public class Awaiter {
	private String id;
	private String name;
	private String password;
	private String email;
	private String accreditationUrl = "테스트데이터에요!"; // TODO 완성되면 삭제필요!
	private Date regDate;
	private Date modDate;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAccreditationUrl() {
		return accreditationUrl;
	}

	public void setAccreditationUrl(String accreditationUrl) {
		this.accreditationUrl = accreditationUrl;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public Date getModDate() {
		return modDate;
	}

	public void setModDate(Date modDate) {
		this.modDate = modDate;
	}
}
