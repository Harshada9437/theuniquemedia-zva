package com.mpal.rest.response.user;

public class GetTypesResponse {
	private int id;
	private String type;
	private String status;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "GetTypesResponse{" +
				"id=" + id +
				", type='" + type + '\'' +
				", status='" + status + '\'' +
				'}';
	}
}
