package com.mpal.rest.response.user;

import java.util.List;

/**
 * Created by Hp on 10-02-2016.
 */
public class UserTypesResponse {
	private List<GetTypesResponse> getTypesResponseList;
	private String messageType;
	private String message;

	public List<GetTypesResponse> getGetTypesResponseList() {
		return getTypesResponseList;
	}

	public void setGetTypesResponseList(
			List<GetTypesResponse> getTypesResponseList) {
		this.getTypesResponseList = getTypesResponseList;
	}

	public String getMessageType() {
		return messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "UserTypesResponse{" +
				"getTypesResponseList=" + getTypesResponseList +
				", messageType='" + messageType + '\'' +
				", message='" + message + '\'' +
				'}';
	}
}
