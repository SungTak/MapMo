package com.taky.mapmo.user.model;

public class UserProfile {
	private String profileImagePath;
	private String profileImageUrl;
	private String profileImageName;
	
	public String getProfileImagePath() {
		return profileImagePath;
	}
	
	public void setProfileImagePath(String profileImagePath) {
		this.profileImagePath = profileImagePath;
	}

	public String getProfileImageName() {
		return profileImageName;
	}

	public void setProfileImageName(String profileImageName) {
		this.profileImageName = profileImageName;
	}

	public String getProfileImageUrl() {
		return profileImageUrl;
	}

	public void setProfileImageUrl(String profileImageUrl) {
		this.profileImageUrl = profileImageUrl;
	}
}
