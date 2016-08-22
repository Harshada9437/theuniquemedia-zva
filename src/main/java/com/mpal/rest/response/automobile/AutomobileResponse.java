package com.mpal.rest.response.automobile;

/**
 * Created by System1 on 8/6/2016.
 */
public class AutomobileResponse {

    private  int id;
    private String company;
    private String model;
    private int automobiletypeId;
    private String status;

    public AutomobileResponse(int id, String company, String model, int automobiletypeId, String status)
    {
        this.id=id;
        this.company=company;
        this.model=model;
        this.automobiletypeId=automobiletypeId;
        this.status=status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompany() { return  company; }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getModel() { return  model; }

    public void setModel(String model) {
        this.model = model;
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
                "id=" + id +
                ", company='" + company + '\'' +
                ", model='" + model + '\'' +
                ", automobiletypeId=" + automobiletypeId +
                ", status='" + status + '\'' +
                '}';
    }
}
