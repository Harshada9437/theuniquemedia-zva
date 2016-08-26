package com.mpal.rest.response.serviceprovider;

/**
 * Created by System1 on 8/16/2016.
 */
public class ServiceTypeResponse {

    private int id;
    private String type;
    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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


    @Override
    public String toString() {
        return "ServiceTypeResponse{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
