package com.mpal.rest.response.user;

public class RegistrationResponse {
	private String messagetype;
	private String message;

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
		return "RegistrationResponse{" + "messageType='" + messagetype + '\''
				+ " ,message='" + message + '\'' +
				+ '}';
	}
}
