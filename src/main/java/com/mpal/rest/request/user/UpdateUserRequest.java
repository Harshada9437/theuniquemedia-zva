package com.mpal.rest.request.user;

public class UpdateUserRequest {
	private int id;
	private String name;
	private String mobile;
	private String email;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	@Override
	public String toString() {
		return "UpdateUserRequest [id=" + id + ", name=" + name +
				", mobile=" + mobile + ", email=" + email + "]";
	}
}
