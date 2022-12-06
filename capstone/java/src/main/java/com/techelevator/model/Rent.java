package com.techelevator.model;

import java.math.BigDecimal;

public class Rent {
    private int rentId;
    private int renterId;
    private int landlordId;
    private BigDecimal amountDue;
    private int rentStatusId;

    public Rent(int rentId, int renterId, int landlordId, BigDecimal amountDue, int rentStatusId) {
        this.rentId = rentId;
        this.renterId = renterId;
        this.landlordId = landlordId;
        this.amountDue = amountDue;
        this.rentStatusId = rentStatusId;
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

    public int getRentStatusId() {
        return rentStatusId;
    }

    public void setRentId(int rentId) {
        this.rentId = rentId;
    }


}
