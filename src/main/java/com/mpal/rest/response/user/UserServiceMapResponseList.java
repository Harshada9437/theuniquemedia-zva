package com.mpal.rest.response.user;

/**
 * Created by System1 on 8/24/2016.
 */
public class UserServiceMapResponseList {
    private  int id;
    private int userId;
    private int serviceId;
    private String status;

    public UserServiceMapResponseList(int id, int userId, int serviceId, String status) {
        this.id = id;
        this.userId = userId;
        this.serviceId = serviceId;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public int getServiceId() {
        return serviceId;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "UserServiceMapResponseList{" +
                "id=" + id +
                ", userId=" + userId +
                ", serviceId=" + serviceId +
                ", status='" + status + '\'' +
                '}';
    }
}
