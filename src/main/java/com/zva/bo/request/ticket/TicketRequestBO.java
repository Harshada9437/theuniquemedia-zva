package com.zva.bo.request.ticket;

/**
 * Created by Sumedh on 22-08-2016.
 */
public class TicketRequestBO {
    private int requestId;
    private int vendorId;
    private String status;

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

        TicketRequestBO that = (TicketRequestBO) o;

        if (requestId != that.requestId) return false;
        if (vendorId != that.vendorId) return false;
        return status != null ? status.equals(that.status) : that.status == null;
    }

    @Override
    public int hashCode() {
        int result = requestId;
        result = 31 * result + vendorId;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TicketRequestBO{" +
                "requestId=" + requestId +
                ", vendorId=" + vendorId +
                ", status='" + status + '\'' +
                '}';
    }
}
