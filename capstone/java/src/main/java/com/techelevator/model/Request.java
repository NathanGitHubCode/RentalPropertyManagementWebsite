package com.techelevator.model;

import java.util.Date;
import java.util.Objects;

public class Request {
    private int requestId;
    private int renterId;
    private int propertyId;
    private int maintStatusId;
    private Date date;
    private String description;

    public Request(int requestId, int renterId, int propertyId, int maintStatusId, Date date, String description) {
        this.requestId = requestId;
        this.renterId = renterId;
        this.propertyId = propertyId;
        this.maintStatusId = maintStatusId;
        this.date = date;
        this.description = description;
    }

    public Request(){

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

    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    public int getMaintStatusId() {
        return maintStatusId;
    }

    public void setMaintStatusId(int maintStatusId) {
        this.maintStatusId = maintStatusId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Request requests = (Request) o;
        return requestId == requests.requestId && renterId == requests.renterId && propertyId == requests.propertyId && maintStatusId == requests.maintStatusId && date.equals(requests.date) && description.equals(requests.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requestId, renterId, propertyId, maintStatusId, date, description);
    }

    @Override
    public String toString() {
        return "Requests{" +
                "requestId=" + requestId +
                ", renterId=" + renterId +
                ", propertyId=" + propertyId +
                ", maint_status=" + maintStatusId +
                ", date=" + date +
                ", description='" + description + '\'' +
                '}';
    }
}
