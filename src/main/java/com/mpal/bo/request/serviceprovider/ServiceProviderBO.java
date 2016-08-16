package com.mpal.bo.request.serviceprovider;

/**
 * Created by System1 on 8/12/2016.
 */
public class ServiceProviderBO {
    private  int id;
    private String name;
    private String address;
    private String phoneNo;
    private String mobileNo;
    private String city;
    private String state;
    private String log;
    private String lat;
    private String openingTime;
    private String closingTime;
    private  int serviceProviderId;
    private String status;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getLog() {
        return log;
    }

    public String getLat() {
        return lat;
    }

    public String getOpeningTime() {
        return openingTime;
    }

    public String getClosingTime() {
        return closingTime;
    }

    public int getServiceProviderId() {
        return serviceProviderId;
    }

    public String getStatus() {
        return status;
    }

    public ServiceProviderBO setId(int id) {
        this.id = id;
        return this;
    }

    public ServiceProviderBO setName(String name) {
        this.name = name;
        return this;
    }

    public ServiceProviderBO setAddress(String address) {
        this.address = address;
        return this;
    }

    public ServiceProviderBO setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
        return this;
    }

    public ServiceProviderBO setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
        return this;
    }

    public ServiceProviderBO setCity(String city) {
        this.city = city;
        return this;
    }

    public ServiceProviderBO setState(String state) {
        this.state = state;
        return this;
    }

    public ServiceProviderBO setLog(String log) {
        this.log = log;
        return this;
    }

    public ServiceProviderBO setLat(String lat) {
        this.lat = lat;
        return this;
    }

    public ServiceProviderBO setOpeningTime(String openingTime) {
        this.openingTime = openingTime;
        return this;
    }

    public ServiceProviderBO setClosingTime(String closingTime) {
        this.closingTime = closingTime;
        return this;
    }

    public ServiceProviderBO setServiceProviderId(int serviceProviderId) {
        this.serviceProviderId = serviceProviderId;
        return this;
    }

    public ServiceProviderBO setStatus(String status) {
        this.status = status;
        return this;
    }
}

