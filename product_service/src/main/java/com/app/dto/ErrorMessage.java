package com.app.dto;

import java.util.Date;

public class ErrorMessage {

    private Date timeStamp;

    private String message;

    private String details;

    public ErrorMessage(Date timeStamp, String message, String details) {
        this.timeStamp = timeStamp;
        this.details = details;
        this.message = message;
    }

    public Date getTimeStamp() {return timeStamp;}
    public String getMessage() {
        return message;
    }
    public String getDetails() {return details;}


}
