package com.mpal.dto.automobile;

public class AutomobileTypesDTO {
    private int id;
    private String type;
    private String status;

    public String getType() {return type;}

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AutomobileTypesDTO)) return false;

        AutomobileTypesDTO that = (AutomobileTypesDTO) o;

        if (id != that.id) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        return status != null ? status.equals(that.status) : that.status == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AutomobileTypesDTO [ id=" + id + ", type=" + type + '\'' + ", status=" + status + '\'' + "]";
    }

}
