package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.techelevator.model.properties.ListingSubType;

public class PropertyDetailsDto {

    private String zpid;
    private String address;
    private String imgSrc;
    private Boolean hasImage;
    private Integer bathrooms;
    private Integer bedrooms;
    private Integer livingArea;
    private Integer price;
    private Double latitude;
    private Double longitude;

    public String getZpid() {
        return zpid;
    }

    public void setZpid(String zpid) {
        this.zpid = zpid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public Boolean getHasImage() {
        return hasImage;
    }

    public void setHasImage(Boolean hasImage) {
        this.hasImage = hasImage;
    }

    public Integer getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(Integer bathrooms) {
        this.bathrooms = bathrooms;
    }

    public Integer getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(Integer bedrooms) {
        this.bedrooms = bedrooms;
    }

    public Integer getLivingArea() {
        return livingArea;
    }

    public void setLivingArea(Integer livingArea) {
        this.livingArea = livingArea;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
