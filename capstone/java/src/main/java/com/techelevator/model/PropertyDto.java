package com.techelevator.model;

import java.math.BigDecimal;

public class PropertyDto {

    private int propertyId;
    private String address;
    private String imgSrc;
    private Boolean hasImage;
    private Integer bathrooms;
    private Integer bedrooms;
    private Integer livingArea;
    private Integer price;
    private Integer landlordId;
    private boolean isAvailable;

    public Integer getLandlordId() {
        return landlordId;
    }

    public void setLandlordId(Integer landlordId) {
        this.landlordId = landlordId;
    }



    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public int getPropertyId() {
        return propertyId;
    }

    public String getAddress() {
        return address;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public Boolean getHasImage() {
        return hasImage;
    }

    public Integer getBathrooms() {
        return bathrooms;
    }

    public Integer getBedrooms() {
        return bedrooms;
    }

    public Integer getLivingArea() {
        return livingArea;
    }

    public Integer getPrice() {
        return price;
    }
}
