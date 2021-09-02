package com.sahil.movieBookingSystem.dtos;

public class InvalidResponseDTO {

    private String errorMessage;
    private String status;
    private String resourceName;

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public InvalidResponseDTO(String errorMessage, String status, String resourceName) {
        this.errorMessage = errorMessage;
        this.status = status;
        this.resourceName = resourceName;
    }

    @Override
    public String toString() {
        return "InvalidResponseDTO{" +
                "errorMessage='" + errorMessage + '\'' +
                ", status='" + status + '\'' +
                ", resourceName='" + resourceName + '\'' +
                '}';
    }
}
