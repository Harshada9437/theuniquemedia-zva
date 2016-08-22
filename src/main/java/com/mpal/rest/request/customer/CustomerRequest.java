package com.mpal.rest.request.customer;

/**
 * Created by Sumedh on 21-08-2016.
 */
public class CustomerRequest {
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
    public String toString() {
        return "CustomerRequest{" +
                "customerId=" + customerId +
                ", mechanicId=" + mechanicId +
                ", automobileDetailsId=" + automobileDetailsId +
                ", serviceId=" + serviceId +
                '}';
    }
}
