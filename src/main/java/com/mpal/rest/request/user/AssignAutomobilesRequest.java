package com.mpal.rest.request.user;

import java.util.List;

/**
 * Created by System1 on 8/19/2016.
 */
public class AssignAutomobilesRequest {
    private List<AutomobilesInfo> AutomobilesInfoList;

    public List<AutomobilesInfo> getAutomobilesInfoList() {
        return AutomobilesInfoList;
    }

    public void setAutomobilesInfoList(List<AutomobilesInfo> automobilesInfoList) {
        AutomobilesInfoList = automobilesInfoList;
    }

    @Override
    public String toString() {
        return "AssignAutomobilesRequest{" +
                "AutomobilesInfoList=" + AutomobilesInfoList +
                '}';
    }
}
