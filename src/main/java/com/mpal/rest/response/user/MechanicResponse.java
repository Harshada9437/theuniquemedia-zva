package com.mpal.rest.response.user;

/**
 * Created by System1 on 8/23/2016.
 */
public class MechanicResponse {

    private int id;
    private String name;
    private String address;
    private  String mobile;
    private String email;
    private  String gender;
    private String latitude;
    private String longitude;
    private String status;
    private int requestedAutomobile;
    private int isHired;

    public MechanicResponse(int id, String name, String address, String mobile, String email, String gender, String latitude, String longitude,String status,int requestedAutomobile,int isHired) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.mobile = mobile;
        this.email = email;
        this.gender = gender;
        this.latitude = latitude;
        this.longitude = longitude;
        this.status=status;
        this.requestedAutomobile=requestedAutomobile;
        this.isHired=isHired;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getRequestedAutomobile() {
        return requestedAutomobile;
    }

    public void setRequestedAutomobile(int requestedAutomobile) {
        this.requestedAutomobile = requestedAutomobile;
    }

    public int getIsHired() {
        return isHired;
    }

    public void setIsHired(int isHired) {
        this.isHired = isHired;
    }

    @Override
    public String toString() {
        return "MechanicResponse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", status='" + status + '\'' +
                ", requestedAutomobile=" + requestedAutomobile +
                ", isHired=" + isHired +
                '}';
    }
}
