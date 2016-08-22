package com.mpal.rest.request.user;

public class RegistrationRequest {
	private int userTypeId;
	private String name;
	private String address;
	private String latitude;
	private String longitude;
	private String dob;
	private String gender;
	private String mobile;
	private String email;
	private String password;
	private int clientDetailsId;

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

	public int getUserTypeId() { return userTypeId; }

	public void setUserTypeId(int userTypeId) {
		this.userTypeId = userTypeId;
	}

	public int getClientDetailsId() { return clientDetailsId; }

	public void setClientDetailsId(int clientDetailsId) {
		this.clientDetailsId = clientDetailsId;
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

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "RegistrationRequest{" +
				"userTypeId=" + clientDetailsId +
				", name='" + name + '\'' +
				", address='" + address + '\'' +
				", latitude='" + latitude + '\'' +
				", longitude='" + longitude + '\'' +
				", dob='" + dob + '\'' +
				", gender='" + gender + '\'' +
				", mobile='" + mobile + '\'' +
				", email='" + email + '\'' +
				", password='" + password + '\'' +
				", clientDetailsId=" + clientDetailsId +
				'}';
	}
}
