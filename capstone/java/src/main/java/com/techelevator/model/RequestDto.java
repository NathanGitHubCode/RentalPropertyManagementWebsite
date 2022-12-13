package com.techelevator.model;

import java.util.Date;

public class RequestDto {

    private Integer requestId;
    private Integer renterId;
    private Integer propertyId;
    private Date date;
    private String description;
    private Integer maintenanceStatusId;
    private String phoneNumber;

    public Integer getRequestId() {
        return requestId;
    }

    public void setRequestId(Integer requestId) {
        this.requestId = requestId;
    }

    public Integer getRenterId() {
        return renterId;
    }

    public void setRenterId(Integer renterId) {
        this.renterId = renterId;
    }

    public Integer getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Integer propertyId) {
        this.propertyId = propertyId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getMaintenanceStatusId() {
        return maintenanceStatusId;
    }

    public void setMaintenanceStatusId(Integer maintenanceStatusId) {
        this.maintenanceStatusId = maintenanceStatusId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
