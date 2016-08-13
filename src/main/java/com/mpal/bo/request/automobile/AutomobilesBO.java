package com.mpal.bo.request.automobile;

/**
 * Created by System1 on 8/6/2016.
 */
public class AutomobilesBO {
    private String company;
    private String model;
    private String builtYear;
    private int automobiletypeId;

    public String getCompany() { return  company; }

    public AutomobilesBO setCompany(final String company)
    {
        this.company=company;
        return this;
    }

    public String getModel() { return  model; }

    public AutomobilesBO setModel(final String model)
    {
        this.model=model;
        return this;
    }

    public String getBuiltYear() { return  builtYear; }

    public AutomobilesBO setBuiltYear(final String builtYear)
    {
        this.builtYear=builtYear;
        return this;
    }

    public int getAutomobileTypeId() { return  automobiletypeId; }

    public AutomobilesBO setAutomobileTypeId(final int automobiletypeId)
    {
        this.automobiletypeId=automobiletypeId;
        return this;
    }

    @Override
    public String toString() {
        return "AutomobilesBO{" + "company=" + company + '\'' +
                ", model='" + model + '\'' + ", builtYear='" + builtYear + '\'' +
                ", automobileTypeId=" + automobiletypeId +
                '}';
    }
}
