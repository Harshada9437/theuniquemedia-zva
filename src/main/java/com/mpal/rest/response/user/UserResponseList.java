package com.mpal.rest.response.user;

public class UserResponseList {
	private int id;
	private int usertypeid;
	private String name;
	private String mobile;
	private String email;
	private int clientdetailsId;
	private String isVerified;
	private String status;

	public UserResponseList(int id, int usertypeid, String name, String mobile, String email, int clientdetailsId, String isVerified, String status) {
		this.id = id;
		this.usertypeid = usertypeid;
		this.name=name;
		this.mobile=mobile;
		this.email = email;
		this.clientdetailsId = clientdetailsId;
		this.isVerified = isVerified;
		this.status=status;
	}

	public String getIsVerified() {
		return isVerified;
	}

	public int getUserTypeId() {
		return usertypeid;
	}

	public int getClientDetailsId() {
		return clientdetailsId;
	}

	public String getName() {
		return name;
	}

	public String getMobile() {
		return mobile;
	}

	public String getEmail() {
		return email;
	}

	public int getId() {return id;}

	public String getStatus() {return status;}

	@Override
	public String toString() {
		return "UserResponseList{" +
				"id=" + id +
				", userTypeId=" + usertypeid +
				", name='" + name + '\'' +
				", mobile='" + mobile + '\'' +
				", email='" + email + '\'' +
				", clientdetailsId=" + clientdetailsId +
				", isVerified='" + isVerified + '\'' +
				", status='" + status + '\'' +
				'}';
	}
}
