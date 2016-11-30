package com.zva.rest.request.ticket;

/**
 * Created by System2 on 8/23/2016.
 */
public class UpdateCustomerRequest {
    private int updatedBy;
    private String status;
    private String remark;

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

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
                ", remark='" + remark + '\'' +
                '}';
    }
}



