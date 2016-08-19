package com.mpal.rest.request.user;

import java.util.List;
/**
 * Created by System1 on 8/19/2016.
 */
public class AutomobilesInfo {
    private int userId;
    private List<Integer> automobileDetailsIds;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<Integer> getAutomobileDetailsIds() {
        return automobileDetailsIds;
    }

    public void setAutomobileDetailsIds(List<Integer> automobileDetailsIds) {
        this.automobileDetailsIds = automobileDetailsIds;
    }

    @Override
    public String toString() {
        return "AutomobilesInfo{" +
                "userId=" + userId +
                ", automobileDetailsIds=" + automobileDetailsIds +
                '}';
    }
}
