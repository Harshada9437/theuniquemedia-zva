package com.mpal.rest.request.automobileInfo;

import java.sql.Time;

/**
 * Created by System2 on 8/12/2016.
 */
public class AutomobileInfoRequest {

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
    private  int automobileInfoId;
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

    public int getAutomobileInfoId() {
        return automobileInfoId;
    }

    public String getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public void setOpeningTime(String openingTime) {
        this.openingTime = openingTime;
    }

    public void setClosingTime(String closingTime) {
        this.closingTime = closingTime;
    }

    public void setAutomobileInfoId(int automobileInfoId) {
        this.automobileInfoId = automobileInfoId;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "AutomobileInfoRequest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", log='" + log + '\'' +
                ", lat='" + lat + '\'' +
                ", openingTime=" + openingTime +
                ", closingTime=" + closingTime +
                ", automobileInfoId=" + automobileInfoId +
                ", status='" + status + '\'' +
                '}';
    }




}
