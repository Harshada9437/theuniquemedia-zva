package com.mpal.rest.response.user;

public class UserLoggedInResponse {
	private int userId;

	public UserLoggedInResponse(int userId, String email) {
		this.userId = userId;
	}

	public int getUserId() {
		return userId;
	}

	@Override
	public String toString() {
		return "UserLoggedInResponse [userId=" + userId + "]";
	}

}
