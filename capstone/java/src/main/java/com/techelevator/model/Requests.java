package com.techelevator.model;

import java.util.Objects;

public class Requests {
    private int requestId;
    private int renterId;
    private String requestName;
    private String description;
    private int propertyId;
    private String maintenanceWorker;
    private boolean isCompleted;

    public Requests(int requestId, int renterId, String requestName, String description, int propertyId, String maintenanceWorker, boolean isCompleted) {
        this.requestId = requestId;
        this.renterId = renterId;
        this.requestName = requestName;
        this.description = description;
        this.propertyId = propertyId;
        this.maintenanceWorker = maintenanceWorker;
        this.isCompleted = isCompleted;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public int getRenterId() {
        return renterId;
    }

    public void setRenterId(int renterId) {
        this.renterId = renterId;
    }

    public String getRequestName() {
        return requestName;
    }

    public void setRequestName(String requestName) {
        this.requestName = requestName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    public String getMaintenanceWorker() {
        return maintenanceWorker;
    }

    public void setMaintenanceWorker(String maintenanceWorker) {
        this.maintenanceWorker = maintenanceWorker;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Requests requests = (Requests) o;
        return requestId == requests.requestId && renterId == requests.renterId && propertyId == requests.propertyId && isCompleted == requests.isCompleted && Objects.equals(requestName, requests.requestName) && Objects.equals(description, requests.description) && Objects.equals(maintenanceWorker, requests.maintenanceWorker);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requestId, renterId, requestName, description, propertyId, maintenanceWorker, isCompleted);
    }

}
