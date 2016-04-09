package com.taky.mapmo.user.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.type.Alias;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Alias("user")
@SuppressWarnings("serial")
public class User implements UserDetails {
	private String id;
	private String name;
	private String password;
	private String email;
	private Date regDate;
	private Date modDate;
	
	/**
	 * 유저의 권한 목록을 리턴
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
		grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER")); 
		
		return grantedAuthorities;
	}

	@Override
	public String getUsername() {
		return name;
	}

	/**
	 * 계정이 만료되지 않았는가?
	 */
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	/**
	 * 계정이 잠겨있지 않는가?
	 */
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	/**
	 * 계정의 패스워드가 만료되지 않았는가?
	 */
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	/**
	 * 계정이 사용가능한가?
	 */
	@Override
	public boolean isEnabled() {
		return true;
	}
	
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
