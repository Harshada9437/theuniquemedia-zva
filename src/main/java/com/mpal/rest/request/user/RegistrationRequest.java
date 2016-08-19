package com.mpal.rest.request.user;

public class RegistrationRequest {
	private int usertypeid;
	private String name;
	private String mobile;
	private String email;
	private String password;
	private int clientdetailsId;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUserTypeId() { return usertypeid; }

	public void setUserTypeId(int usertypeid) {
		this.usertypeid = usertypeid;
	}

	public int getClientDetailsId() { return clientdetailsId; }

	public void setClientDetailsId(int clientdetailsId) {
		this.clientdetailsId = clientdetailsId;
	}

	@Override
	public String toString() {
		return "RegistrationRequest{" +
				"userTypeId='" + usertypeid + '\'' +
				", name='" + name + '\'' +
				", mobile='" + mobile + '\'' +
				", email='" + email + '\'' +
				", password='" + password + '\'' +
				", clientdetailsId=" + clientdetailsId +
				'}';
	}
}
