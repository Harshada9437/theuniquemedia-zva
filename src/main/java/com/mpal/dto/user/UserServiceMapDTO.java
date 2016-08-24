package com.mpal.dto.user;

/**
 * Created by System1 on 8/24/2016.
 */
public class UserServiceMapDTO {
    private  int id;
    private int userId;
    private int serviceId;
    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserServiceMapDTO that = (UserServiceMapDTO) o;

        if (id != that.id) return false;
        if (userId != that.userId) return false;
        if (serviceId != that.serviceId) return false;
        return status != null ? status.equals(that.status) : that.status == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + userId;
        result = 31 * result + serviceId;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserServiceMapDTO{" +
                "id=" + id +
                ", userId=" + userId +
                ", serviceId=" + serviceId +
                ", status='" + status + '\'' +
                '}';
    }
}
