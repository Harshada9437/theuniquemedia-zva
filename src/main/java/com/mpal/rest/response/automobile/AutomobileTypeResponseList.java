package com.mpal.rest.response.automobile;

import java.util.List;

/**
 * Created by System1 on 8/8/2016.
 */
public class AutomobileTypeResponseList {

    List<AutomobileTypeResponseList> getAutomobileTypesResponseList;

    public List<AutomobileTypeResponseList> getGetAutomobileTypesResponseList(List<AutomobileResponseList> automobileByTypeId) {
        return getAutomobileTypesResponseList;
    }

    public List<AutomobileTypeResponseList> setGetAutomobileTypesResponseList(
            List<AutomobileResponseList> getAutomobileTypesResponseList) {
        this.getAutomobileTypesResponseList = getAutomobileTypesResponseList;
        return null;
    }

    @Override
    public String toString() {
        return "AutomobileTypeResponseList{" + "getAutomobileTypesResponseList="
                + getAutomobileTypesResponseList + '}';
    }
}
