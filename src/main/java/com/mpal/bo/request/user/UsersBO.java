package com.mpal.bo.request.user;

public class UsersBO {

	private int id;
	private String name;
	private  String mobile;
	private String email;
	private String password;
	private int usertypeid;
	private int clientdetailsId;

	public int getId() {
		return id;
	}

	public UsersBO setId(final int id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public UsersBO setName(final String name) {
		this.name = name;
		return this;
	}

	public String getMobile() {
		return mobile;
	}

	public UsersBO setMobile(final String mobile) {
		this.mobile = mobile;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public UsersBO setEmail(final String email) {
		this.email = email;
		return this;
	}

	public String getPassword() {
		return password;
	}

	public UsersBO setPassword(final String password) {
		this.password = password;
		return this;
	}

	public int getUserTypeId() {
		return usertypeid;
	}

	public UsersBO setType(final String type) {
		this.usertypeid = usertypeid;
		return this;
	}

	public int getClientDetailsId() {
		return clientdetailsId;
	}

	public UsersBO setClientDetailsId(final int clientdetailsId) {
		this.clientdetailsId = clientdetailsId;
		return this;
	}


	@Override
	public String toString() {
		return "UsersBO{" + "id=" + id + ", userTypeId='" + usertypeid + '\'' +
				", name='" + name + '\'' + ", mobile='" + mobile + '\'' +
				", email='" + email + '\'' + ", password='" + password + '\'' +
				", clientdetailsid=" + clientdetailsId +
				'}';
	}
}
