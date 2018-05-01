package com.zuche.entity;

/**
 * 用户和用户详细信息
 * @author cbl
 *
 */
public class UserAndInfo {
	
	private User user;
	
	private UserInfo userInfo;

	public UserAndInfo(User user, UserInfo userInfo) {
		super();
		this.user = user;
		this.userInfo = userInfo;
	}

	public UserAndInfo() {
		super();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	
}
