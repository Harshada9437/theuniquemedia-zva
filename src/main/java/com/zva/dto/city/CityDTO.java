package com.zva.dto.city;

/**
 * Created by System1 on 8/31/2016.
 */
public class CityDTO {
    private int id;
    private String state;
    private String city;
    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CityDTO cityDTO = (CityDTO) o;

        if (id != cityDTO.id) return false;
        if (state != null ? !state.equals(cityDTO.state) : cityDTO.state != null) return false;
        if (city != null ? !city.equals(cityDTO.city) : cityDTO.city != null) return false;
        return status != null ? status.equals(cityDTO.status) : cityDTO.status == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CityDTO{" +
                "id=" + id +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
