package com.mpal.bo.request.automobile;

/**
 * Created by System2 on 8/12/2016.
 */
public class UpdateAutomobileBO {

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
        return "UpdateAutomobileBO [id=" + id + ",model=" + model + ", company=" + company +
                ", builtYear=" + builtYear + ", automobileTypeId=" + automobiletypeId + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((model == null) ? 0 : model.hashCode());
        result = prime * result + ((company == null) ? 0 : company.hashCode());
        result = prime * result + ((builtYear == null) ? 0 : builtYear.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        UpdateAutomobileBO other = (UpdateAutomobileBO) obj;
        if (model == null) {
            if (other.model != null)
                return false;
        } else if (!model.equals(other.model))
            return false;
        if (company == null) {
            if (other.company != null)
                return false;
        } else if (!company.equals(other.company))
            return false;
        if (builtYear == null) {
            if (other.builtYear != null)
                return false;
        } else if (!builtYear.equals(other.builtYear))
            return false;


        return true;
    }


    }
