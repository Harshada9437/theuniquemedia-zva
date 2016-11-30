package com.zva.rest.response.zone;

/**
 * Created by System-2 on 11/29/2016.
 */
public class ZoneResponse {
    private int id;
    private String zone;
    private int cityId;
    private String status;

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getZone() {return zone;}

    public void setZone(String zone) {this.zone = zone;}

    public int getCityId() {return cityId;}

    public void setCityId(int cityId) {this.cityId = cityId;}

    public String getStatus() {return status;}

    public void setStatus(String status) {this.status = status;}

    @Override
    public String toString() {
        return "ZoneResponse{" +
                "id=" + id +
                ", zone='" + zone + '\'' +
                ", cityId=" + cityId +
                ", status='" + status + '\'' +
                '}';
    }
}
