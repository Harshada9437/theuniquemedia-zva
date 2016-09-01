package com.mpal.rest.response.customer;

/**
 * Created by System1 on 8/24/2016.
 */
public class GetRequestResponse {

    private int id;
    private int customerId;
    private int mechanicId;
    private int automobileDetailsId;
    private int serviceId;
    private String createdDtm;
    private String updatedDtm;
    private int updatedBy;
    private String token;
    private String status;
    private String messageType;
    private String message;

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getCreatedDtm() {
        return createdDtm;
    }

    public void setCreatedDtm(String createdDtm) {
        this.createdDtm = createdDtm;
    }

    public String getUpdatedDtm() {
        return updatedDtm;
    }

    public void setUpdatedDtm(String updatedDtm) {
        this.updatedDtm = updatedDtm;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(int updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "GetRequestResponse{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", mechanicId=" + mechanicId +
                ", automobileDetailsId=" + automobileDetailsId +
                ", serviceId=" + serviceId +
                ", createdDtm='" + createdDtm + '\'' +
                ", updatedDtm='" + updatedDtm + '\'' +
                ", updatedBy=" + updatedBy +
                ", token='" + token + '\'' +
                ", status='" + status + '\'' +
                ", messageType='" + messageType + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
