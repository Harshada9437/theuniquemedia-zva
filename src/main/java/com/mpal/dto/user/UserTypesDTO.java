package com.mpal.dto.user;

public class UserTypesDTO {
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        result = prime * result + ((status == null) ? 0 : status.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserTypesDTO that = (UserTypesDTO) o;

        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        return status != null ? status.equals(that.status) : that.status == null;

    }

    @Override
    public String toString() {
        return "UserTypesDTO [type=" + type + '\'' + " status=" + status + '\'' + "]";
    }

}
