package com.techelevator.model;

import org.apache.tomcat.jni.Local;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

public class Request {
    private int requestId;
    private int renterId;
    private int propertyId;
    private String address;
    private int maintStatusId;
    private int employeeId;
    private LocalDate date;
    private String phoneNumber;
    private String description;

    public Request(int requestId, int renterId, int propertyId, String address, int maintStatusId, int employeeId, LocalDate date, String phoneNumber, String description) {
        this.requestId = requestId;
        this.renterId = renterId;
        this.propertyId = propertyId;
        this.address = address;
        this.maintStatusId = maintStatusId;
        this.employeeId = employeeId;
        this.date = date;
        this.phoneNumber = phoneNumber;
        this.description = description;
    }

    public Request(){

    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
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
