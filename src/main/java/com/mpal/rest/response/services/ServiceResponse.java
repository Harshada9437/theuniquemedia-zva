package com.mpal.rest.response.services;

/**
 * Created by System1 on 8/31/2016.
 */
public class ServiceResponse {
    private  int id;
    private String serviceName;
    private String imagePath;
    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ServiceResponse{" +
                "id=" + id +
                ", serviceName='" + serviceName + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
