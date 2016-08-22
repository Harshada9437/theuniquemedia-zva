package com.mpal.dto.user;

public class UsersDTO {
	private int id;
	private int usertypeid;
	private String name;
	private String address;
	private String latitude;
	private String longitude;
	private String gender;
	private String DOB;
	private String mobile;
	private String email;
	private String password;
	private int clientdetailsId;
	private String isVerified;
	private  String status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserTypeId() {
		return usertypeid;
	}

	public void setUserTypeId(int usertypeid) {
		this.usertypeid = usertypeid;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getClientDetailsId() { return clientdetailsId; }

	public void setClientDetailsId(int clientdetailsId) {
		this.clientdetailsId = clientdetailsId;
	}

	public String getIsVerified() {
		return isVerified;
	}

	public void setIsVerified(String isVerified) {
		this.isVerified = isVerified;
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

	public int getClientdetailsId() {
		return clientdetailsId;
	}

	public void setClientdetailsId(int clientdetailsId) {
		this.clientdetailsId = clientdetailsId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof UsersDTO)) return false;

		UsersDTO usersDTO = (UsersDTO) o;

		if (id != usersDTO.id) return false;
		if (usertypeid != usersDTO.usertypeid) return false;
		if (clientdetailsId != usersDTO.clientdetailsId) return false;
		if (name != null ? !name.equals(usersDTO.name) : usersDTO.name != null) return false;
		if (address != null ? !address.equals(usersDTO.address) : usersDTO.address != null) return false;
		if (latitude != null ? !latitude.equals(usersDTO.latitude) : usersDTO.latitude != null) return false;
		if (longitude != null ? !longitude.equals(usersDTO.longitude) : usersDTO.longitude != null) return false;
		if (gender != null ? !gender.equals(usersDTO.gender) : usersDTO.gender != null) return false;
		if (DOB != null ? !DOB.equals(usersDTO.DOB) : usersDTO.DOB != null) return false;
		if (mobile != null ? !mobile.equals(usersDTO.mobile) : usersDTO.mobile != null) return false;
		if (email != null ? !email.equals(usersDTO.email) : usersDTO.email != null) return false;
		if (password != null ? !password.equals(usersDTO.password) : usersDTO.password != null) return false;
		if (isVerified != null ? !isVerified.equals(usersDTO.isVerified) : usersDTO.isVerified != null) return false;
		return status != null ? status.equals(usersDTO.status) : usersDTO.status == null;

	}

	@Override
	public int hashCode() {
		int result = id;
		result = 31 * result + usertypeid;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (address != null ? address.hashCode() : 0);
		result = 31 * result + (latitude != null ? latitude.hashCode() : 0);
		result = 31 * result + (longitude != null ? longitude.hashCode() : 0);
		result = 31 * result + (gender != null ? gender.hashCode() : 0);
		result = 31 * result + (DOB != null ? DOB.hashCode() : 0);
		result = 31 * result + (mobile != null ? mobile.hashCode() : 0);
		result = 31 * result + (email != null ? email.hashCode() : 0);
		result = 31 * result + (password != null ? password.hashCode() : 0);
		result = 31 * result + clientdetailsId;
		result = 31 * result + (isVerified != null ? isVerified.hashCode() : 0);
		result = 31 * result + (status != null ? status.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "UsersDTO{" +
				"id=" + id +
				", usertypeid=" + usertypeid +
				", name='" + name + '\'' +
				", address='" + address + '\'' +
				", latitude='" + latitude + '\'' +
				", longitude='" + longitude + '\'' +
				", gender='" + gender + '\'' +
				", DOB=" + DOB +
				", mobile='" + mobile + '\'' +
				", email='" + email + '\'' +
				", password='" + password + '\'' +
				", clientdetailsId=" + clientdetailsId +
				", isVerified='" + isVerified + '\'' +
				", status='" + status + '\'' +
				'}';
	}
}
