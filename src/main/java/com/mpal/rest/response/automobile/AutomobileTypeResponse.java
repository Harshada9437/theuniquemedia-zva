package com.mpal.rest.response.automobile;

/**
 * Created by System1 on 8/16/2016.
 */
public class AutomobileTypeResponse {

    private int id;
    private String type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "AutomobileTypeResponse{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }


}
