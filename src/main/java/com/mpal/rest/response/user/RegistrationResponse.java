package com.mpal.rest.response.user;

public class RegistrationResponse {
	private String messagetype;
	private String message;
	private int userId;

	public int getUserId() {

		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getMessageType() {return messagetype;}

	public void setMessageType(String messagetype) {
		this.messagetype = messagetype;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	@Override
	public String toString() {
		return "RegistrationResponse{" +
				"messagetype='" + messagetype + '\'' +
				", message='" + message + '\'' +
				", userId=" + userId +
				'}';
	}
}
