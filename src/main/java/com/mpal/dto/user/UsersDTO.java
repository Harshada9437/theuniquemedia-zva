package com.mpal.dto.user;

public class UsersDTO {
	private int id;
	private String type;
	private String name;
	private String mobile;
	private String email;
	private String password;
	private int clientdetailsId;
	private String isVerified;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserType() {
		return type;
	}

	public void setUserType(String type) {
		this.type = type;
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


	public String isVerified() {
		return isVerified;
	}

	public void setVerified(String verified) {
		isVerified = verified;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		UsersDTO usersDTO = (UsersDTO) o;
		if (id != usersDTO.id) return false;
		if (type != null ? !type.equals(usersDTO.type) : usersDTO.type != null) return false;
		if (name != null ? !name.equals(usersDTO.name) : usersDTO.name != null) return false;
		if (mobile != null ? !mobile.equals(usersDTO.mobile) : usersDTO.mobile != null) return false;
		if (email != null ? !email.equals(usersDTO.email) : usersDTO.email != null) return false;
		if (password != null ? !password.equals(usersDTO.password) : usersDTO.password != null) return false;
		if (clientdetailsId != usersDTO.clientdetailsId) return false;
		return (isVerified != null ? !isVerified.equals(usersDTO.isVerified) : usersDTO.isVerified != null);
	}


	@Override
	public String toString() {
		return "UsersDTO{" +
				"id=" + id +
				", type=" + type + '\'' +
				", name=" + name + '\'' +
				", mobile=" + mobile + '\'' +
				", email='" + email + '\'' +
				", password='" + password + '\'' +
				", clientdetailsId=" + clientdetailsId +
				", isVerified=" + isVerified +
				'}';
	}

    @Override
    public int hashCode() {
        int result = id;
		result = 31 * result + (type != null ? type.hashCode() : 0);
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (mobile != null ? mobile.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
		result = 31 * result + clientdetailsId;
        result = 31 * result + (isVerified != null ? isVerified.hashCode() : 0);
        return result;
    }
}
