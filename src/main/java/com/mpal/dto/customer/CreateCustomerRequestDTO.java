package com.mpal.dto.customer;

import java.sql.Timestamp;

public class CreateCustomerRequestDTO {
    private int customerId;
    private int mechanicId;
    private int automobileDetailsId;
    private int serviceId;
    private Timestamp createdDtm;
    private Timestamp updatedDtm;
    private String token;
    private String status;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getMechanicId() {
        return mechanicId;
    }

    public void setMechanicId(int mechanicId) {
        this.mechanicId = mechanicId;
    }

    public int getAutomobileDetailsId() {
        return automobileDetailsId;
    }

    public void setAutomobileDetailsId(int automobileDetailsId) {
        this.automobileDetailsId = automobileDetailsId;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public Timestamp getCreatedDtm() {
        return createdDtm;
    }

    public void setCreatedDtm(Timestamp createdDtm) {
        this.createdDtm = createdDtm;
    }

    public Timestamp getUpdatedDtm() {
        return updatedDtm;
    }

    public void setUpdatedDtm(Timestamp updatedDtm) {
        this.updatedDtm = updatedDtm;
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

        CreateCustomerRequestDTO that = (CreateCustomerRequestDTO) o;

        if (customerId != that.customerId) return false;
        if (mechanicId != that.mechanicId) return false;
        if (automobileDetailsId != that.automobileDetailsId) return false;
        if (serviceId != that.serviceId) return false;
        if (createdDtm != null ? !createdDtm.equals(that.createdDtm) : that.createdDtm != null) return false;
        if (updatedDtm != null ? !updatedDtm.equals(that.updatedDtm) : that.updatedDtm != null) return false;
        if (token != null ? !token.equals(that.token) : that.token != null) return false;
        return status != null ? status.equals(that.status) : that.status == null;

    }

    @Override
    public int hashCode() {
        int result = customerId;
        result = 31 * result + mechanicId;
        result = 31 * result + automobileDetailsId;
        result = 31 * result + serviceId;
        result = 31 * result + (createdDtm != null ? createdDtm.hashCode() : 0);
        result = 31 * result + (updatedDtm != null ? updatedDtm.hashCode() : 0);
        result = 31 * result + (token != null ? token.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CreateCustomerRequestDTO{" +
                "customerId=" + customerId +
                ", mechanicId=" + mechanicId +
                ", automobileDetailsId=" + automobileDetailsId +
                ", serviceId=" + serviceId +
                ", createdDtm=" + createdDtm +
                ", updatedDtm=" + updatedDtm +
                ", token='" + token + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
