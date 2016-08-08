package com.mpal.rest.response.user;

public class UserResponseList {
	private int id;
	private String type;
	private String name;
	private String mobile;
	private String email;
	private int clientdetailsId;
	private String isVerified;

	public UserResponseList(int id, String type, String name, String mobile, String email, int clientdetailsId, String isVerified) {
		this.id = id;
		this.type = type;
		this.name=name;
		this.mobile=mobile;
		this.email = email;
		this.clientdetailsId = clientdetailsId;
		this.isVerified = isVerified;
	}

	public String getIsVerified() {
		return isVerified;
	}

	public String getUserType() {
		return type;
	}

	public int getClientDetailsId() {
		return clientdetailsId;
	}

	public String getName() {
		return name;
	}

	public String getMobile() {
		return mobile;
	}

	public String getEmail() {
		return email;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "UserResponseList{" +
				"id=" + id +
				", type=" + type +
				", name='" + name + '\'' +
				", mobile='" + mobile + '\'' +
				", email='" + email + '\'' +
				", clientdetailsId=" + clientdetailsId +
				", isVerified='" + isVerified + '\'' +
				'}';
	}
}
