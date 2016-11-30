package com.zva.dto.area;

/**
 * Created by System1 on 8/12/2016.
 */
public class AreaDTO {

    private  int id;
    private String area;
    private  String zone;
    private String status;


    public int getId() {
        return id;
    }

    public String getArea() {
        return area;
    }

    public String getZone() {
        return zone;
    }

    public String getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AreaDTO areaDTO = (AreaDTO) o;

        if (id != areaDTO.id) return false;
        if (area != null ? !area.equals(areaDTO.area) : areaDTO.area != null) return false;
        if (zone != null ? !zone.equals(areaDTO.zone) : areaDTO.zone != null) return false;
        return status != null ? status.equals(areaDTO.status) : areaDTO.status == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (area != null ? area.hashCode() : 0);
        result = 31 * result + (zone != null ? zone.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AreaDTO{" +
                "id=" + id +
                ", area='" + area + '\'' +
                ", zone='" + zone + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
