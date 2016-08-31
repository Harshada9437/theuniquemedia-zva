package com.mpal.rest.response.customer;

/**
 * Created by System1 on 8/31/2016.
 */
public class RequestMResponse {
    private String customerName;
    private  String customerNo;
    private String customerEmail;
    private int serviceId;
    private String serviceName;
    private String make;
    private String model;
    private int id;
    private String createdDtm;
    private String updatedDtm;
    private int updatedBy;
    private String token;
    private String status;

    public RequestMResponse(String customerName, String customerNo, String customerEmail, int serviceId, String serviceName, String make, String model, int id, String createdDtm, String updatedDtm, int updatedBy, String token, String status) {
        this.customerName = customerName;
        this.customerNo = customerNo;
        this.customerEmail = customerEmail;
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.make = make;
        this.model = model;
        this.id = id;
        this.createdDtm = createdDtm;
        this.updatedDtm = updatedDtm;
        this.updatedBy = updatedBy;
        this.token = token;
        this.status = status;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerNo() {
        return customerNo;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public int getServiceId() {
        return serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getId() {
        return id;
    }

    public String getCreatedDtm() {
        return createdDtm;
    }

    public String getUpdatedDtm() {
        return updatedDtm;
    }

    public int getUpdatedBy() {
        return updatedBy;
    }

    public String getToken() {
        return token;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "RequestMResponse{" +
                "customerName='" + customerName + '\'' +
                ", customerNo='" + customerNo + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", serviceId=" + serviceId +
                ", serviceName='" + serviceName + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", id=" + id +
                ", createdDtm='" + createdDtm + '\'' +
                ", updatedDtm='" + updatedDtm + '\'' +
                ", updatedBy=" + updatedBy +
                ", token='" + token + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
