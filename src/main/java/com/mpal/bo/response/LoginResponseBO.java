package com.mpal.bo.response;

public class LoginResponseBO {
	private Boolean isValidUser;
	private Boolean isAvtiveUser;
	private int id;
	private String sessionId;

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Boolean getValidUser() {
		return isValidUser;
	}

	public void setValidUser(Boolean validUser) {
		isValidUser = validUser;
	}

	public Boolean getAvtiveUser() {
		return isAvtiveUser;
	}

	public void setAvtiveUser(Boolean avtiveUser) {
		isAvtiveUser = avtiveUser;
	}

	@Override
	public String toString() {
		return "LoginResponseBO{" +
				"isValidUser=" + isValidUser +
				", isAvtiveUser=" + isAvtiveUser +
				", id=" + id +
				", sessionId='" + sessionId + '\'' +
				'}';
	}
}
