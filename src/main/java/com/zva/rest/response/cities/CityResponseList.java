package com.zva.rest.response.cities;

import com.zva.rest.response.util.GenericResponse;

import java.util.List;

/**
 * Created by System1 on 8/31/2016.
 */
public class CityResponseList implements GenericResponse {
    private List<CityResponse> cities;
    private String messageType;
    private String message;

    public List<CityResponse> getCities() {
        return cities;
    }

    public void setCities(List<CityResponse> cities) {
        this.cities = cities;
    }

    public String getMessageType() {return messageType;}

    public String getMessage() {return message;}

    @Override
    public String toString() {
        return "CityResponseList{" +
                "cities=" + cities +
                ", messageType='" + messageType + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    @Override
    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }
}
