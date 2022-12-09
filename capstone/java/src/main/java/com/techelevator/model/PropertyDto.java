package com.techelevator.model;

import java.math.BigDecimal;

public class PropertyDto {
    private String name;
    private int landlordId;
    private String address;
    private String description;
    private BigDecimal price;

    public String getName() {
        return name;
    }

    public int getLandlordId() {
        return landlordId;
    }

    public String getAddress() {
        return address;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
