package com.zva.dto.ticket;

public class TicketDTO {
    private int id;
    private int requestId;
    private int vendorId;
    private String createdDtm;
    private String updatedDtm;
    private String status;
    private int updatedBy;

    public int getUpdatedBy() {return updatedBy;}

    public void setUpdatedBy(int updatedBy) {this.updatedBy = updatedBy;}

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public int getVendorId() {
        return vendorId;
    }

    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
    }

    public String getCreatedDtm() {
        return createdDtm;
    }

    public void setCreatedDtm(String createdDtm) {
        this.createdDtm = createdDtm;
    }

    public String getUpdatedDtm() {
        return updatedDtm;
    }

    public void setUpdatedDtm(String updatedDtm) {
        this.updatedDtm = updatedDtm;
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
        if (o == null || getClass() != o.getClass()) return false;

        TicketDTO ticketDTO = (TicketDTO) o;

        if (id != ticketDTO.id) return false;
        if (requestId != ticketDTO.requestId) return false;
        if (vendorId != ticketDTO.vendorId) return false;
        if (updatedBy != ticketDTO.updatedBy) return false;
        if (createdDtm != null ? !createdDtm.equals(ticketDTO.createdDtm) : ticketDTO.createdDtm != null) return false;
        if (updatedDtm != null ? !updatedDtm.equals(ticketDTO.updatedDtm) : ticketDTO.updatedDtm != null) return false;
        return status != null ? status.equals(ticketDTO.status) : ticketDTO.status == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + requestId;
        result = 31 * result + vendorId;
        result = 31 * result + (createdDtm != null ? createdDtm.hashCode() : 0);
        result = 31 * result + (updatedDtm != null ? updatedDtm.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + updatedBy;
        return result;
    }

    @Override
    public String toString() {
        return "TicketDTO{" +
                "id=" + id +
                ", requestId=" + requestId +
                ", vendorId=" + vendorId +
                ", createdDtm='" + createdDtm + '\'' +
                ", updatedDtm='" + updatedDtm + '\'' +
                ", status='" + status + '\'' +
                ", updatedBy=" + updatedBy +
                '}';
    }
}
