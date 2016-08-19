package com.mpal.bo.request.user;

public class RegistrationRequestBO {
	private int usertypeid;
	private String name;
	private String mobile;
	private String email;
	private String password;
	private int clientdetailsId;

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

	public int getUserTypeId() { return usertypeid; }

	public void setUserTypeId(int usertypeid) {
		this.usertypeid = usertypeid;
	}

	public int getClientDetailsId() { return clientdetailsId; }

	public void setClientDetailsId(int clientdetailsId) {
		this.clientdetailsId = clientdetailsId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		RegistrationRequestBO that = (RegistrationRequestBO) o;
		if (usertypeid != that.usertypeid) return false;
		if (name != null ? !name.equals(that.name) : that.name != null) return false;
		if (mobile != null ? !mobile.equals(that.mobile) : that.mobile != null) return false;
		if (email != null ? !email.equals(that.email) : that.email != null) return false;
		if (password != null ? !password.equals(that.password) : that.password != null) return false;
		return (clientdetailsId != that.clientdetailsId);
	}

	@Override
	public int hashCode() {
		int result= 1;
		result = 31 * result + usertypeid;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (mobile != null ? mobile.hashCode() : 0);
		result = 31 * result + (email != null ? email.hashCode() : 0);
		result = 31 * result + (password != null ? password.hashCode() : 0);
		result = 31 * result + clientdetailsId;
		return result;
	}

	@Override
	public String toString() {
		return "RegistrationRequestBO{" +
				"userTypeId='" + usertypeid  +
				", name='" + name + '\'' +
				", mobile='" + mobile + '\'' +
				", email='" + email + '\'' +
				", password='" + password + '\'' +
				", clientDetailsId=" + clientdetailsId +
				'}';
	}
}
