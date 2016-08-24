package com.mpal.rest.request.customer;

/**
 * Created by System2 on 8/23/2016.
 */
public class UpdateCustomerRequest {
    private int updatedBy;
    private String status;

    public int getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(int updatedBy) {
        this.updatedBy = updatedBy;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "UpdateCustomerRequest{" +
                "updatedBy=" + updatedBy +
                ", status='" + status + '\'' +
                '}';
    }
}



