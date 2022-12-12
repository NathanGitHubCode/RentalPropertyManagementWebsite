package com.techelevator.model;

import java.math.BigDecimal;
import java.util.Date;

public class Rent {
    private int rentId;
    private int renterId;
    private int landlordId;
    private BigDecimal amountDue;
    private int propertyId;
    private Date date;

    public Rent(int rentId, int renterId, int landlordId, BigDecimal amountDue, int rentStatusId, int propertyId, Date date) {
        this.rentId = rentId;
        this.renterId = renterId;
        this.landlordId = landlordId;
        this.amountDue = amountDue;
        this.propertyId = propertyId;
        this.date = date;
    }

    public Rent(){

    }

    public int getRentId() {
        return rentId;
    }

    public int getRenterId() {
        return renterId;
    }

    public int getLandlordId() {
        return landlordId;
    }

    public BigDecimal getAmountDue() {
        return amountDue;
    }

    public int getPropertyId() {
        return propertyId;
    }

    public Date getDate(){ return date; }

    public void setRentId(int rentId) {
        this.rentId = rentId;
    }

    public void setRenterId(int renterId) {
        this.renterId = renterId;
    }

    public void setLandlordId(int landlordId) {
        this.landlordId = landlordId;
    }

    public void setAmountDue(BigDecimal amountDue) {
        this.amountDue = amountDue;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
