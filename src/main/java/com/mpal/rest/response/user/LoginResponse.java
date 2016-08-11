package com.mpal.rest.response.user;

import javax.ws.rs.ext.Provider;

/**
 * Created by Hp on 07-02-2016.
 */
@Provider
public class LoginResponse {
	private int userId;
	private String messagetype;
	private String message;

	public String getMessageType() {
		return messagetype;
	}

	public void setMessageType(String messagetype) {
		this.messagetype= messagetype;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message= message;
	}



	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "LoginResponse{" +
				"messageType='" + messagetype + '\'' +
				"message='" + message + '\'' +
				"userId=" + userId +
				'}';
	}
}
