package com.mpal.rest.response.user;

public class GetUserResponse {
	private int id;
	private int usertypeid;
	private String name;
	private String mobile;
	private String email;
	private int clientdetailsId;
	private String status;
	private String messagetype;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getClientDetailsId() {
		return clientdetailsId;
	}

	public void setClientDetailsId(int clientdetailsId) {
		this.clientdetailsId = clientdetailsId;
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

	@Override
	public String toString() {
		return "GetUserResponse{" +
				"id=" + id +
				", userTypeId='" + usertypeid + '\'' +
				", name='" + name + '\'' +
				", mobile='" + mobile + '\'' +
				", email='" + email + '\'' +
				", clientdetailsId=" + clientdetailsId +
				", status=" + status + '\'' +
				", messagaeType=" + messagetype + '\'' +
				'}';
	}
}
