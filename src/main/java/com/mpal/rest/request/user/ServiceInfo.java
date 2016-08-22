package com.mpal.rest.request.user;

import java.util.List;

/**
 * Created by System1 on 8/22/2016.
 */
public class ServiceInfo {

    private int userId;
    private List<Integer> serviceIds;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<Integer> getServiceIds() {
        return serviceIds;
    }

    public void setServiceIds(List<Integer> serviceIds) {
        this.serviceIds = serviceIds;
    }

    @Override
    public String toString() {
        return "ServiceInfo{" +
                "userId=" + userId +
                ", serviceIds=" + serviceIds +
                '}';
    }
}
