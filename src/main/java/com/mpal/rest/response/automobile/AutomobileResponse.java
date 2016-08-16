package com.mpal.rest.response.automobile;

/**
 * Created by System1 on 8/6/2016.
 */
public class AutomobileResponse {

    private String company;
    private String model;
    private String builtYear;
    private int automobiletypeId;
    private String status;

    public AutomobileResponse(String company, String model, String builtYear, int automobiletypeId, String status)
    {
        this.company=company;
        this.model=model;
        this.builtYear=builtYear;
        this.automobiletypeId=automobiletypeId;
        this.status=status;
    }

    public String getCompany() { return  company; }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getModel() { return  model; }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBuiltYear() { return  builtYear; }

    public void setBuiltYear(String builtYear) {
        this.builtYear = builtYear;
    }

    public String getStatus() { return  status; }

    public void setStatus(final String status)
    {
        this.status=status;
    }

    public int getAutomobileTypeId() { return  automobiletypeId; }

    public void setAutomobileTypeId(int automobiletypeId) {
        this.automobiletypeId = automobiletypeId;
    }

    @Override
    public String toString() {
        return "AutomobileResponse{" +
                "company='" + company + '\'' +
                ", model='" + model + '\'' +
                ", BuiltYear='" + builtYear + '\'' +
                ", AutomobileTypeId=" + automobiletypeId +
                ", status='" + status + '\'' +
                '}';
    }

}
