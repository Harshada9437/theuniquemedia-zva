package com.mpal.rest.response.user;

public class GetTypesResponse {
	private String type;
	private String status;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String gatStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "GetTypesResponse{" + ", type='" + type
				+ '\'' + ", status='" + status + '\'' + '}';
	}
}
