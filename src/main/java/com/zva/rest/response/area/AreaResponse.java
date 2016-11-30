package com.zva.rest.response.area;

/**
 * Created by System1 on 8/26/2016.
 */
public class AreaResponse {
    private int id;
    private String area;
    private String zone;
    private String status;

    public AreaResponse(int id, String area, String zone, String status) {
        this.id = id;
        this.area = area;
        this.zone = zone;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "AreaResponse{" +
                "id=" + id +
                ", area='" + area + '\'' +
                ", zone='" + zone + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
