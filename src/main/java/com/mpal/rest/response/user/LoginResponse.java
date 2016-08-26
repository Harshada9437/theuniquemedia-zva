package com.mpal.rest.response.user;

import javax.ws.rs.ext.Provider;

/**
 * Created by Hp on 07-02-2016.
 */
@Provider
public class LoginResponse {
	private int userId;
	private String messageType;
	private String message;
    private String name;
    private String address;
    private  String mobile;
    private String email;
    private  String gender;
    private String DOB;
    private String latitude;
    private String longitude;
    private int usertypeid;
    private int clientDetailsId;
    private  String isVerified;
    private String status;


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
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

    public int getUserTypeId() {
        return usertypeid;
    }

    public void setUserTypeId(int usertypeid) {
        this.usertypeid = usertypeid;
    }

    public int getClientDetailsId() {
        return clientDetailsId;
    }

    public void setClientDetailsId(int clientDetailsId) {
        this.clientDetailsId = clientDetailsId;
    }

    public String getIsVerified() {
        return isVerified;
    }

    public void setIsVerified(String isVerified) {
        this.isVerified = isVerified;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "userId=" + userId +
                ", messageType='" + messageType + '\'' +
                ", message='" + message + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", DOB='" + DOB + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", userTypeId=" + usertypeid +
                ", clientDetailsId=" + clientDetailsId +
                ", isVerified='" + isVerified + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
