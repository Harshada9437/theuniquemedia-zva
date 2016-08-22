package com.mpal.rest.request.user;

public class UpdateUserRequest {
	private int id;
	private String name;
	private String address;
	private String latitude;
	private String longitude;
	private String DOB;
	private String gender;
	private String mobile;
	private String email;
	private String status;


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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String DOB) {
		this.DOB = DOB;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "UpdateUserRequest{" +
				"id=" + id +
				", name='" + name + '\'' +
				", address='" + address + '\'' +
				", latitude='" + latitude + '\'' +
				", longitude='" + longitude + '\'' +
				", DOB='" + DOB + '\'' +
				", gender='" + gender + '\'' +
				", mobile='" + mobile + '\'' +
				", email='" + email + '\'' +
				", status='" + status + '\'' +
				'}';
	}
}
