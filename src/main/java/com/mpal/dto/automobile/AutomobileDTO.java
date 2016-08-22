package com.mpal.dto.automobile;

/**
 * Created by System1 on 8/6/2016.
 */
public class AutomobileDTO {
    private int id;
    private String company;
    private String model;
    private int automobiletypeId;
    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompany() { return  company; }

    public void setCompany(final String company)
    {
        this.company=company;
    }

    public String getStatus() { return  status; }

    public void setStatus(final String status)
    {
        this.status=status;
    }


    public String getModel() { return  model; }

    public void setModel(final String model)
    {
        this.model=model;
    }

    public int getAutomobileTypeId() { return  automobiletypeId; }

    public void setAutomobileTypeId(final int automobiletypeId)
    {
        this.automobiletypeId=automobiletypeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AutomobileDTO)) return false;

        AutomobileDTO that = (AutomobileDTO) o;

        if (id != that.id) return false;
        if (automobiletypeId != that.automobiletypeId) return false;
        if (company != null ? !company.equals(that.company) : that.company != null) return false;
        if (model != null ? !model.equals(that.model) : that.model != null) return false;
        return status != null ? status.equals(that.status) : that.status == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (company != null ? company.hashCode() : 0);
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + automobiletypeId;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AutomobileDTO{" +
                "id=" + id +
                ", company='" + company + '\'' +
                ", model='" + model + '\'' +
                ", automobiletypeId=" + automobiletypeId +
                ", status='" + status + '\'' +
                '}';
    }
}
