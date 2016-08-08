package com.mpal.rest.response.user;

public class GetUserResponse {
	private int id;
	private String type;
	private String name;
	private String mobile;
	private String email;
	private int clientdetailsId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getClientDetailsId() {
		return clientdetailsId;
	}

	public void setClientDetailsId(int clientdetailsId) {
		this.clientdetailsId = clientdetailsId;
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


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getUserType() {
		return type;
	}

	public void setUserType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "GetUserResponse{" +
				"id=" + id +
				", type='" + type + '\'' +
				", name=" + name + '\'' +
				", mobile=" + mobile + '\'' +
				", email='" + email + '\'' +
				", clientdetailsId=" + clientdetailsId +
				'}';
	}
}
