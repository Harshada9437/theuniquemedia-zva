package com.mpal.bo.request.customer;

/**
 * Created by Sumedh on 22-08-2016.
 */
public class CreateCustomerRequestBO {
    private int customerId;
    private int mechanicId;
    private int automobileDetailsId;
    private int serviceId;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CreateCustomerRequestBO that = (CreateCustomerRequestBO) o;

        if (customerId != that.customerId) return false;
        if (mechanicId != that.mechanicId) return false;
        if (automobileDetailsId != that.automobileDetailsId) return false;
        return serviceId == that.serviceId;

    }

    @Override
    public int hashCode() {
        int result = customerId;
        result = 31 * result + mechanicId;
        result = 31 * result + automobileDetailsId;
        result = 31 * result + serviceId;
        return result;
    }

    @Override
    public String toString() {
        return "CreateCustomerRequestBO{" +
                "customerId=" + customerId +
                ", mechanicId=" + mechanicId +
                ", automobileDetailsId=" + automobileDetailsId +
                ", serviceId=" + serviceId +
                '}';
    }
}
