package com.mpal.bo.request.user;

import com.mpal.rest.request.user.AutomobilesInfo;

import java.util.List;

/**
 * Created by System1 on 8/22/2016.
 */
public class AssignAutomobilesRequestBO {
    private List<AutomobilesInfo> automobileInfoList;

    public List<AutomobilesInfo> getAutomobileInfoList() {
        return automobileInfoList;
    }

    public void setAutomobileInfoList(List<AutomobilesInfo> automobileInfoList) {
        this.automobileInfoList = automobileInfoList;
    }

    @Override
    public String toString() {
        return "AssignAutomobilesRequestBO{" +
                "automobileInfoList=" + automobileInfoList +
                '}';
    }
}
