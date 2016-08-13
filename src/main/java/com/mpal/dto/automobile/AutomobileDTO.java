package com.mpal.dto.automobile;

/**
 * Created by System1 on 8/6/2016.
 */
public class AutomobileDTO {

    private String company;
    private String model;
    private String builtYear;
    private int automobiletypeId;
    private String status;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AutomobileDTO automobilesDTO = (AutomobileDTO) o;
        if (company != null ? !company.equals(automobilesDTO.company) : automobilesDTO.company != null) return false;
        if (model != null ? !model.equals(automobilesDTO.model) : automobilesDTO.model != null) return false;
        if (builtYear != null ? !builtYear.equals(automobilesDTO.builtYear) : automobilesDTO.builtYear != null) return false;
        if (status != null ? !status.equals(automobilesDTO.status) : automobilesDTO.status != null) return false;
        return (automobiletypeId != automobilesDTO.automobiletypeId);
    }

    @Override
    public String toString() {
        return "AutomobileDTO{" +
                "company=" + company + '\'' +
                "model=" + model + '\'' +
                ", builtYear=" + builtYear + '\'' +
                ", automobiletypeId=" + automobiletypeId +
                ", status=" + status + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + (company != null ? company.hashCode() : 0);
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + (builtYear != null ? builtYear.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + automobiletypeId;
        return result;
    }
}
