package com.zva.rest.request.ticket;

/**
 * Created by System-2 on 11/29/2016.
 */
public class UpdateTicketRequest {
    private int id;
    private String status;
    private int updatedBy;

    public int getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(int updatedBy) {
        this.updatedBy = updatedBy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UpdateTicketRequest that = (UpdateTicketRequest) o;

        if (id != that.id) return false;
        if (updatedBy != that.updatedBy) return false;
        return status != null ? status.equals(that.status) : that.status == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + updatedBy;
        return result;
    }

    @Override
    public String toString() {
        return "UpdateTicketRequest{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", updatedBy=" + updatedBy +
                '}';
    }
}
