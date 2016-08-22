package com.mpal.rest.response.user;

public class UserResponseList {
	private int id;
	private String name;
	private String address;
	private  String mobile;
	private String email;
	private  String gender;
	private String DOB;
	private String latitude;
	private String longitude;
	private int usertypeid;
	private int clientDetailsId;
	private  String isVerified;
	private String status;

	public UserResponseList(int id, String name, String address, String mobile, String email, String gender, String DOB, String latitude, String longitude, int usertypeid, int clientDetailsId,String isVerified,String status) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.mobile = mobile;
		this.email = email;
		this.gender = gender;
		this.DOB = DOB;
		this.latitude = latitude;
		this.longitude = longitude;
		this.usertypeid = usertypeid;
		this.clientDetailsId = clientDetailsId;
		this.isVerified=isVerified;
		this.status=status;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getMobile() {
		return mobile;
	}

	public String getEmail() {
		return email;
	}

	public String getGender() {
		return gender;
	}

	public String getDOB() {
		return DOB;
	}

	public String getLatitude() {
		return latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public int getUserTypeId() {
		return usertypeid;
	}

	public int getClientDetailsId() {
		return clientDetailsId;
	}

	public String getIsVerified() {
		return isVerified;
	}

	public String getStatus() {
		return status;
	}

	@Override
	public String toString() {
		return "UserResponseList{" +
				"id=" + id +
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
				", isVerified='" + isVerified + '\'' +
				", status='" + status + '\'' +
				'}';
	}
}
