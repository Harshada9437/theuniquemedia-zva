package com.mpal.bo.request.automobileInfo;

import java.sql.Time;

/**
 * Created by System1 on 8/12/2016.
 */
public class AutomobileInfoBO {
    private  int id;
    private String name;
    private String address;
    private String phoneNo;
    private String mobileNo;
    private String city;
    private String state;
    private String log;
    private String lat;
    private Time startTime;
    private Time endTime;
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

    public Time getStartTime() {
        return startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public int getAutomobileInfoId() {
        return automobileInfoId;
    }

    public String getStatus() {
        return status;
    }

    public AutomobileInfoBO setId(int id) {
        this.id = id;
        return this;
    }

    public AutomobileInfoBO setName(String name) {
        this.name = name;
        return this;
    }

    public AutomobileInfoBO setAddress(String address) {
        this.address = address;
        return this;
    }

    public AutomobileInfoBO setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
        return this;
    }

    public AutomobileInfoBO setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
        return this;
    }

    public AutomobileInfoBO setCity(String city) {
        this.city = city;
        return this;
    }

    public AutomobileInfoBO setState(String state) {
        this.state = state;
        return this;
    }

    public AutomobileInfoBO setLog(String log) {
        this.log = log;
        return this;
    }

    public AutomobileInfoBO setLat(String lat) {
        this.lat = lat;
        return this;
    }

    public AutomobileInfoBO setStartTime(Time startTime) {
        this.startTime = startTime;
        return this;
    }

    public AutomobileInfoBO setEndTime(Time endTime) {
        this.endTime = endTime;
        return this;
    }

    public AutomobileInfoBO setAutomobileInfoId(int automobileInfoId) {
        this.automobileInfoId = automobileInfoId;
        return this;
    }

    public AutomobileInfoBO setStatus(String status) {
        this.status = status;
        return this;
    }
}
