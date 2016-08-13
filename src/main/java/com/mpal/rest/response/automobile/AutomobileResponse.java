package com.mpal.rest.response.automobile;

/**
 * Created by System1 on 8/8/2016.
 */
public class AutomobileResponse {

    private String company;
    private String model;
    private String builtYear;
    private int automobiletypeId;
    private String status;
    private String messageType;
    private String message;


    public String getCompany() { return  company; }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getModel() { return  model; }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBuiltYear() { return  builtYear; }

    public void setBuiltYear(String builtYear) {
        this.builtYear = builtYear;
    }

    public int getAutomobileTypeId() { return  automobiletypeId; }

    public void setAutomobileTypeId(int automobiletypeId) {
        this.automobiletypeId = automobiletypeId;
    }

    public String getMessageType() { return  messageType; }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getMessage() { return  message; }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() { return  status; }

    public void setStatus(String status) {
        this.status = status;
    }



    @Override
    public String toString() {
        return "AutomobileResponseList{" +
                "company='" + company + '\'' +
                ", model='" + model + '\'' +
                ", BuiltYear='" + builtYear + '\'' +
                ", AutomobileTypeId=" + automobiletypeId +
                ", status='" + status + '\'' +
                ", messageType='" + messageType + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

}
