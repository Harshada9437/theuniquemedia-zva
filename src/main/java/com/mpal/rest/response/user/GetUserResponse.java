package com.mpal.rest.response.user;

public class GetUserResponse {
	private int id;
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
	private String messagetype;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMessageType() {
		return messagetype;
	}

	public void setMessageType(String messagetype) {
		this.messagetype = messagetype;
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


	public int getUserTypeId() {
		return usertypeid;
	}

	public void setUserTypeId(int usertypeid) {
		this.usertypeid = usertypeid;
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

	public int getClientDetailsId() {
		return clientDetailsId;
	}

	public void setClientDetailsId(int clientDetailsId) {
		this.clientDetailsId = clientDetailsId;
	}

	@Override
	public String toString() {
		return "GetUserResponse{" +
				"id=" + id +
				", name='" + name + '\'' +
				", address='" + address + '\'' +
				", mobile='" + mobile + '\'' +
				", email='" + email + '\'' +
				", gender='" + gender + '\'' +
				", DOB='" + DOB + '\'' +
				", latitude='" + latitude + '\'' +
				", longitude='" + longitude + '\'' +
				", usertypeid=" + usertypeid +
				", clientDetailsId=" + clientDetailsId +
				", status='" + status + '\'' +
				", messageType='" + messagetype + '\'' +
				'}';
	}
}
