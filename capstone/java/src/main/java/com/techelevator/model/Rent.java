package com.techelevator.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class Rent {
    private int rentId;
    private int renterId;
    private BigDecimal amount;
    private int propertyId;
    private Date date;
    private String status;

    public Rent() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rent rent = (Rent) o;
        return rentId == rent.rentId && renterId == rent.renterId && propertyId == rent.propertyId && Objects.equals(amount, rent.amount) && Objects.equals(date, rent.date) && Objects.equals(status, rent.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rentId, renterId, amount, propertyId, date, status);
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

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Rent(int rentId, int renterId, BigDecimal amountDue, int propertyId, Date date, String status) {
        this.rentId = rentId;
        this.renterId = renterId;
        this.amount = amountDue;
        this.propertyId = propertyId;
        this.date = date;
        this.status = status;
    }
}
