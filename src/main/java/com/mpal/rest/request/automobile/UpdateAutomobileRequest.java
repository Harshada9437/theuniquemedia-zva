package com.mpal.rest.request.automobile;

/**
 * Created by System2 on 8/12/2016.
 */
public class UpdateAutomobileRequest {


    private int id;
    private String company;
    private String model;
    private String builtYear;
    private int automobiletypeId;

    public int getId() { return id; }

    public void setId(final int id) {
        this.id = id;
    }

    public String getCompany() { return  company; }

    public void setCompany(final String company)
    {
        this.company=company;
    }

    public String getModel() { return  model; }

    public void setModel(final String model)
    {
        this.model=model;
    }

    public String getBuiltYear() { return  builtYear; }

    public void setBuiltYear(final String builtYear)
    {
        this.builtYear=builtYear;
    }

    public int getAutomobileTypeId() { return  automobiletypeId; }

    public void setAutomobileTypeId(final int automobiletypeId)
    {
        this.automobiletypeId=automobiletypeId;
    }


    @Override
    public String toString() {
        return "AutomobileRequest{" +
                "company=" + company + '\'' +
                "model=" + model + '\'' +
                ", builtYear=" + builtYear + '\'' +
                ", automobiletypeId=" + automobiletypeId +
                '}';
    }


}

