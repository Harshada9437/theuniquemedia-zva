package com.mpal.dto.user;

/**
 * Created by System1 on 8/24/2016.
 */
public class UserAutomobileMapDTO {
    private  int id;
    private int userId;
    private int automobileDetailsId;
    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getAutomobileDetailsId() {
        return automobileDetailsId;
    }

    public void setAutomobileDetailsId(int automobileDetailsId) {
        this.automobileDetailsId = automobileDetailsId;
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

        UserAutomobileMapDTO that = (UserAutomobileMapDTO) o;

        if (id != that.id) return false;
        if (userId != that.userId) return false;
        if (automobileDetailsId != that.automobileDetailsId) return false;
        return status != null ? status.equals(that.status) : that.status == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + userId;
        result = 31 * result + automobileDetailsId;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserAutomobileMapDTO{" +
                "id=" + id +
                ", userId=" + userId +
                ", automobileDetailsId=" + automobileDetailsId +
                ", status='" + status + '\'' +
                '}';
    }
}
