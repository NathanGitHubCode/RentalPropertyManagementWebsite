package com.techelevator.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class Rent {
    private int rentId;
    private int renterId;
    private int propertyId;
    private Date date;
    private int status;

    public Rent() {

    }



    @Override
    public int hashCode() {
        return Objects.hash(rentId, renterId, propertyId, date, status);
    }

    public int getRentId() {
        return rentId;
    }

    public void setRentId(int rentId) {
        this.rentId = rentId;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Rent(int rentId, int renterId, int propertyId, Date date, int status) {
        this.rentId = rentId;
        this.renterId = renterId;
        this.propertyId = propertyId;
        this.date = date;
        this.status = status;
    }
}
