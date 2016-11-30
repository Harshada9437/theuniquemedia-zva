package com.zva.bo.request.ticket;

/**
 * Created by System2 on 8/23/2016.
 */
public class UpdateCustomerRequestBO {
    private int updatedBy;
    private String status;
    private String remark;

    public int getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(int updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemark() {

        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UpdateCustomerRequestBO that = (UpdateCustomerRequestBO) o;

        if (updatedBy != that.updatedBy) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        return remark != null ? remark.equals(that.remark) : that.remark == null;

    }

    @Override
    public int hashCode() {
        int result = updatedBy;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UpdateCustomerRequestBO{" +
                "updatedBy=" + updatedBy +
                ", status='" + status + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
