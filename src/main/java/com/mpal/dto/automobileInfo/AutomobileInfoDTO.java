package com.mpal.dto.automobileInfo;

import java.sql.Time;

/**
 * Created by System1 on 8/12/2016.
 */
public class AutomobileInfoDTO {

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

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public void setAutomobileInfoId(int automobileInfoId) {
        this.automobileInfoId = automobileInfoId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AutomobileInfoDTO)) return false;

        AutomobileInfoDTO that = (AutomobileInfoDTO) o;

        if (id != that.id) return false;
        if (automobileInfoId != that.automobileInfoId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (phoneNo != null ? !phoneNo.equals(that.phoneNo) : that.phoneNo != null) return false;
        if (mobileNo != null ? !mobileNo.equals(that.mobileNo) : that.mobileNo != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (state != null ? !state.equals(that.state) : that.state != null) return false;
        if (log != null ? !log.equals(that.log) : that.log != null) return false;
        if (lat != null ? !lat.equals(that.lat) : that.lat != null) return false;
        if (startTime != null ? !startTime.equals(that.startTime) : that.startTime != null) return false;
        if (endTime != null ? !endTime.equals(that.endTime) : that.endTime != null) return false;
        return status != null ? status.equals(that.status) : that.status == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (phoneNo != null ? phoneNo.hashCode() : 0);
        result = 31 * result + (mobileNo != null ? mobileNo.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (log != null ? log.hashCode() : 0);
        result = 31 * result + (lat != null ? lat.hashCode() : 0);
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
        result = 31 * result + automobileInfoId;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AutomobileInfoDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", log='" + log + '\'' +
                ", lat='" + lat + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", automobileInfoId=" + automobileInfoId +
                ", status='" + status + '\'' +
                '}';
    }
}
