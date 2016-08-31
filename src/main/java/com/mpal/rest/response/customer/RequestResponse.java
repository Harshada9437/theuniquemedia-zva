package com.mpal.rest.response.customer;

/**
 * Created by System1 on 8/31/2016.
 */
public class RequestResponse {
    private String mechName;
    private  String mechNo;
    private String mechEmail;
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

    public RequestResponse(String mechName, String mechNo, String mechEmail, String customerName, String customerNo, String customerEmail, int serviceId, String serviceName, String make, String model, int id, String createdDtm, String updatedDtm, int updatedBy, String token, String status) {
        this.mechName = mechName;
        this.mechNo = mechNo;
        this.mechEmail = mechEmail;
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

    public String getMechName() {
        return mechName;
    }

    public void setMechName(String mechName) {
        this.mechName = mechName;
    }

    public String getMechNo() {
        return mechNo;
    }

    public void setMechNo(String mechNo) {
        this.mechNo = mechNo;
    }

    public String getMechEmail() {
        return mechEmail;
    }

    public void setMechEmail(String mechEmail) {
        this.mechEmail = mechEmail;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(int updatedBy) {
        this.updatedBy = updatedBy;
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

    @Override
    public String toString() {
        return "RequestResponse{" +
                "mechName='" + mechName + '\'' +
                ", mechNo='" + mechNo + '\'' +
                ", mechEmail='" + mechEmail + '\'' +
                ", customerName='" + customerName + '\'' +
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
