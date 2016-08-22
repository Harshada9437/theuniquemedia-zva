package com.mpal.bo.request.user;

import java.util.Date;

public class UsersBO {

	private int id;
	private String name;
	private String address;
	private  String mobile;
	private String email;
	private  String gender;
	private String DOB;
	private String latitude;
	private String longitude;
	private String password;
	private int usertypeid;
	private int clientDetailsId;

	public int getId() {
		return id;
	}

	public UsersBO setId(int id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public UsersBO setName(String name) {
		this.name = name;
		return this;
	}

	public String getAddress() {
		return address;
	}

	public UsersBO setAddress(String address) {
		this.address = address;
		return this;
	}

	public String getMobile() {
		return mobile;
	}

	public UsersBO setMobile(String mobile) {
		this.mobile = mobile;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public UsersBO setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getGender() {
		return gender;
	}

	public UsersBO setGender(String gender) {
		this.gender = gender;
		return this;
	}

	public String getDOB() {
		return DOB;
	}

	public UsersBO setDOB(String DOB) {
		this.DOB = DOB;
		return this;
	}

	public String getLatitude() {
		return latitude;
	}

	public UsersBO setLatitude(String latitude) {
		this.latitude = latitude;
		return this;
	}

	public String getLongitude() {
		return longitude;
	}

	public UsersBO setLongitude(String longitude) {
		this.longitude = longitude;
		return this;
	}

	public String getPassword() {
		return password;
	}

	public UsersBO setPassword(String password) {
		this.password = password;
		return this;
	}

	public int getUserTypeId() {
		return usertypeid;
	}

	public UsersBO setUserTypeId(int usertypeid) {
		this.usertypeid = usertypeid;
		return this;
	}

	public int getClientDetailsId() {
		return clientDetailsId;
	}

	public UsersBO setClientDetailsId(int clientDetailsId) {
		this.clientDetailsId = clientDetailsId;
		return this;
	}

	@Override
	public String toString() {
		return "UsersBO{" +
				"id=" + id +
				", name='" + name + '\'' +
				", address='" + address + '\'' +
				", mobile='" + mobile + '\'' +
				", email='" + email + '\'' +
				", gender='" + gender + '\'' +
				", DOB=" + DOB +
				", latitude='" + latitude + '\'' +
				", longitude='" + longitude + '\'' +
				", password='" + password + '\'' +
				", userTypeId=" + usertypeid +
				", clientDetailsId=" + clientDetailsId +
				'}';
	}
}
