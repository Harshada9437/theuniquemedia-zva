package com.mpal.bo.response;

public class LoginResponseBO {
	private Boolean isValidUser;
	private int id;
	private String sessionId;

	private String name;
	private String address;
	private String mobile;
	private String email;
	private String gender;
	private String DOB;
	private String latitude;
	private String longitude;
	private int usertypeid;
	private int clientDetailsId;
	private String status;
	private String isVerified;

	public Boolean getValidUser() {
		return isValidUser;
	}

	public void setValidUser(Boolean validUser) {
		isValidUser = validUser;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String DOB) {
		this.DOB = DOB;
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

	public int getUserTypeId() {
		return usertypeid;
	}

	public void setUserTypeId(int usertypeid) {
		this.usertypeid = usertypeid;
	}

	public int getClientDetailsId() {
		return clientDetailsId;
	}

	public void setClientDetailsId(int clientDetailsId) {
		this.clientDetailsId = clientDetailsId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getIsVerified() {
		return isVerified;
	}

	public void setIsVerified(String isVerified) {
		this.isVerified = isVerified;
	}

	@Override
	public String toString() {
		return "LoginResponseBO{" +
				"isValidUser=" + isValidUser +
				", id=" + id +
				", sessionId='" + sessionId + '\'' +
				", name='" + name + '\'' +
				", address='" + address + '\'' +
				", mobile='" + mobile + '\'' +
				", email='" + email + '\'' +
				", gender='" + gender + '\'' +
				", DOB='" + DOB + '\'' +
				", latitude='" + latitude + '\'' +
				", longitude='" + longitude + '\'' +
				", userTypeId=" + usertypeid +
				", clientDetailsId=" + clientDetailsId +
				", status='" + status + '\'' +
				", isVerified='" + isVerified + '\'' +
				'}';
	}
}
