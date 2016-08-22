package com.mpal.bo.request.user;

public class RegistrationRequestBO {
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

	public int getClientDetailsId() {
		return clientDetailsId;
	}

	public void setClientDetailsId(int clientDetailsId) {
		this.clientDetailsId = clientDetailsId;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUserTypeId() {
		return usertypeid;
	}

	public void setUserTypeId(int usertypeid) {
		this.usertypeid = usertypeid;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof RegistrationRequestBO)) return false;

		RegistrationRequestBO that = (RegistrationRequestBO) o;

		if (usertypeid != that.usertypeid) return false;
		if (clientDetailsId != that.clientDetailsId) return false;
		if (name != null ? !name.equals(that.name) : that.name != null) return false;
		if (address != null ? !address.equals(that.address) : that.address != null) return false;
		if (mobile != null ? !mobile.equals(that.mobile) : that.mobile != null) return false;
		if (email != null ? !email.equals(that.email) : that.email != null) return false;
		if (gender != null ? !gender.equals(that.gender) : that.gender != null) return false;
		if (DOB != null ? !DOB.equals(that.DOB) : that.DOB != null) return false;
		if (latitude != null ? !latitude.equals(that.latitude) : that.latitude != null) return false;
		if (longitude != null ? !longitude.equals(that.longitude) : that.longitude != null) return false;
		return password != null ? password.equals(that.password) : that.password == null;

	}

	@Override
	public int hashCode() {
		int result = name != null ? name.hashCode() : 0;
		result = 31 * result + (address != null ? address.hashCode() : 0);
		result = 31 * result + (mobile != null ? mobile.hashCode() : 0);
		result = 31 * result + (email != null ? email.hashCode() : 0);
		result = 31 * result + (gender != null ? gender.hashCode() : 0);
		result = 31 * result + (DOB != null ? DOB.hashCode() : 0);
		result = 31 * result + (latitude != null ? latitude.hashCode() : 0);
		result = 31 * result + (longitude != null ? longitude.hashCode() : 0);
		result = 31 * result + (password != null ? password.hashCode() : 0);
		result = 31 * result + usertypeid;
		result = 31 * result + clientDetailsId;
		return result;
	}

	@Override
	public String toString() {
		return "RegistrationRequestBO{" +
				"name='" + name + '\'' +
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
