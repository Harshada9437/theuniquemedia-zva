package com.mpal.bo.request.customer;

/**
 * Created by System2 on 8/23/2016.
 */
public class UpdateCustomerRequestBO {
    private int updatedBy;
    private String status;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UpdateCustomerRequestBO that = (UpdateCustomerRequestBO) o;

        if (updatedBy != that.updatedBy) return false;
        return status != null ? status.equals(that.status) : that.status == null;

    }

    @Override
    public int hashCode() {
        int result = updatedBy;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UpdateCustomerRequestBO{" +
                "updatedBy=" + updatedBy +
                ", status='" + status + '\'' +
                '}';
    }
}
