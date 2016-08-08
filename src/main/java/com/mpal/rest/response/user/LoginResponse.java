package com.mpal.rest.response.user;

import javax.ws.rs.ext.Provider;

/**
 * Created by Hp on 07-02-2016.
 */
@Provider
public class LoginResponse {
	private int userId;
	private String message_type;

	public String getMessage() {
		return message_type;
	}

	public void setMessage(String message_type) {
		this.message_type= message_type;
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
				"userId=" + userId +
				", Message_type='" + message_type + '\'' +
				'}';
	}
}
