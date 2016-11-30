package com.zva.dto.zone;

/**
 * Created by System1 on 8/6/2016.
 */
public class ZoneDTO {
    private int id;
    private String zone;
    private int cityId;
    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getZone() { return zone; }

    public void setZone(final String zone)
    {
        this.zone = zone;
    }

    public String getStatus() { return  status; }

    public void setStatus(final String status)
    {
        this.status=status;
    }

    public int getCityId() { return cityId; }

    public void setCityId(final int cityId)
    {
        this.cityId =cityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZoneDTO zoneDTO = (ZoneDTO) o;

        if (id != zoneDTO.id) return false;
        if (cityId != zoneDTO.cityId) return false;
        if (zone != null ? !zone.equals(zoneDTO.zone) : zoneDTO.zone != null) return false;
        return status != null ? status.equals(zoneDTO.status) : zoneDTO.status == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (zone != null ? zone.hashCode() : 0);
        result = 31 * result + cityId;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ZoneDTO{" +
                "id=" + id +
                ", zone='" + zone + '\'' +
                ", cityId=" + cityId +
                ", status='" + status + '\'' +
                '}';
    }
}
