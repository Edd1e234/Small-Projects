package com.Flashcard.Backend.Status;

public class Status {
    private Boolean Status = true;
    private String StatusMessage;

    public Status() {}

    public Boolean getStatus() {
        return Status;
    }

    public void setStatus(Boolean status) {
        Status = status;
    }

    public String getStatusMessage() {
        return this.StatusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        StatusMessage = statusMessage;
    }
}
