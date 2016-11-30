package com.zva.dto.ticket;

/**
 * Created by System1 on 8/31/2016.
 */
public class RequestMDTO {
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
    private String updatedBy;
    private String token;
    private String status;

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

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RequestMDTO that = (RequestMDTO) o;

        if (serviceId != that.serviceId) return false;
        if (id != that.id) return false;
        if (customerName != null ? !customerName.equals(that.customerName) : that.customerName != null) return false;
        if (customerNo != null ? !customerNo.equals(that.customerNo) : that.customerNo != null) return false;
        if (customerEmail != null ? !customerEmail.equals(that.customerEmail) : that.customerEmail != null)
            return false;
        if (serviceName != null ? !serviceName.equals(that.serviceName) : that.serviceName != null) return false;
        if (make != null ? !make.equals(that.make) : that.make != null) return false;
        if (model != null ? !model.equals(that.model) : that.model != null) return false;
        if (createdDtm != null ? !createdDtm.equals(that.createdDtm) : that.createdDtm != null) return false;
        if (updatedDtm != null ? !updatedDtm.equals(that.updatedDtm) : that.updatedDtm != null) return false;
        if (updatedBy != null ? !updatedBy.equals(that.updatedBy) : that.updatedBy != null) return false;
        if (token != null ? !token.equals(that.token) : that.token != null) return false;
        return status != null ? status.equals(that.status) : that.status == null;

    }

    @Override
    public int hashCode() {
        int result = customerName != null ? customerName.hashCode() : 0;
        result = 31 * result + (customerNo != null ? customerNo.hashCode() : 0);
        result = 31 * result + (customerEmail != null ? customerEmail.hashCode() : 0);
        result = 31 * result + serviceId;
        result = 31 * result + (serviceName != null ? serviceName.hashCode() : 0);
        result = 31 * result + (make != null ? make.hashCode() : 0);
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + id;
        result = 31 * result + (createdDtm != null ? createdDtm.hashCode() : 0);
        result = 31 * result + (updatedDtm != null ? updatedDtm.hashCode() : 0);
        result = 31 * result + (updatedBy != null ? updatedBy.hashCode() : 0);
        result = 31 * result + (token != null ? token.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "RequestMDTO{" +
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
