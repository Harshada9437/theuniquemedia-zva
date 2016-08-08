package com.mpal.rest.response.user;

public class UpdateResponse {
	private String message;

	public String getsMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "UpdateResponse{" + "Message='" + message + '\''
				+ '}';
	}
}
