package com.mpal.dto.user;

/**
 * Created by System1 on 8/23/2016.
 */
public class MechanicDTO {
    private int id;
    private String name;
    private String address;
    private String latitude;
    private String longitude;
    private String gender;
    private String mobile;
    private String email;
    private String status;
    private int requestedAutomobile;
    private int isHired;

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MechanicDTO)) return false;

        MechanicDTO that = (MechanicDTO) o;

        if (id != that.id) return false;
        if (requestedAutomobile != that.requestedAutomobile) return false;
        if (isHired != that.isHired) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (latitude != null ? !latitude.equals(that.latitude) : that.latitude != null) return false;
        if (longitude != null ? !longitude.equals(that.longitude) : that.longitude != null) return false;
        if (gender != null ? !gender.equals(that.gender) : that.gender != null) return false;
        if (mobile != null ? !mobile.equals(that.mobile) : that.mobile != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        return status != null ? status.equals(that.status) : that.status == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (latitude != null ? latitude.hashCode() : 0);
        result = 31 * result + (longitude != null ? longitude.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (mobile != null ? mobile.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + requestedAutomobile;
        result = 31 * result + isHired;
        return result;
    }

    @Override
    public String toString() {
        return "MechanicDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", gender='" + gender + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", status='" + status + '\'' +
                ", requestedAutomobile=" + requestedAutomobile +
                ", isHired=" + isHired +
                '}';
    }
}
