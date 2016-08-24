package com.mpal.rest.response.user;

/**
 * Created by System1 on 8/24/2016.
 */
public class UserAutomobileMapResponseList {
    private  int id;
    private int userId;
    private int automobileDetailsId;
    private String status;

    public UserAutomobileMapResponseList(int id, int userId, int automobileDetailsId, String status) {
        this.id = id;
        this.userId = userId;
        this.automobileDetailsId = automobileDetailsId;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public int getAutomobileDetailsId() {
        return automobileDetailsId;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "UserAutomobileMapResponseList{" +
                "id=" + id +
                ", userId=" + userId +
                ", automobileDetailsId=" + automobileDetailsId +
                ", status='" + status + '\'' +
                '}';
    }
}
