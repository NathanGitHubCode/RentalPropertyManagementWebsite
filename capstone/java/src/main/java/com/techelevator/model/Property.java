package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.Objects;
import java.awt.image.BufferedImage;
public class Property {

    @JsonProperty("property_id")
    private int propertyId;
    private String address;
    private String imgSrc;
    private Boolean hasImage;
    private Integer bathrooms;
    private Integer bedrooms;
    private Integer livingArea;
    private Integer price;
    private Integer landlord_id;
    private boolean isAvailable;

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public Integer getLandlord_id() {
        return landlord_id;
    }

    public void setLandlord_id(Integer landlord_id) {
        this.landlord_id = landlord_id;
    }

    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Property property = (Property) o;
        return Objects.equals(propertyId, property.propertyId) && Objects.equals(address, property.address) && Objects.equals(imgSrc, property.imgSrc) && Objects.equals(hasImage, property.hasImage) && Objects.equals(bathrooms, property.bathrooms) && Objects.equals(bedrooms, property.bedrooms) && Objects.equals(livingArea, property.livingArea) && Objects.equals(price, property.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(propertyId, address, imgSrc, hasImage, bathrooms, bedrooms, livingArea, price);
    }

    @Override
    public String toString() {
        return "Property{" +
                "propertyId='" + propertyId + '\'' +
                ", address='" + address + '\'' +
                ", imgSrc='" + imgSrc + '\'' +
                ", hasImage=" + hasImage +
                ", bathrooms=" + bathrooms +
                ", bedrooms=" + bedrooms +
                ", livingArea=" + livingArea +
                ", price=" + price +
                '}';
    }

    //    @JsonProperty("property_id")
//    private int propertyId;
//    private String name;
//    @JsonProperty("landlord_id")
//    private int landlordId;
//    private String address;
//    private String description;
//    private BigDecimal price;
////    private BufferedImage image;
//
//    public Property(int propertyId, String name, int landlordId, String address, String description, BigDecimal price) {
//        this.propertyId = propertyId;
//        this.name = name;
//        this.landlordId = landlordId;
//        this.address = address;
//        this.description = description;
//        this.price = price;
//
////        this.image = image;
//    }
//
//    public Property() {
//
//    }
//
//    public int getPropertyId() {
//        return propertyId;
//    }
//
//    public void setPropertyId(int propertyId) {
//        this.propertyId = propertyId;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getLandlordId() {
//        return landlordId;
//    }
//
//    public void setLandlordId(int landlordId) {
//        this.landlordId = landlordId;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public BigDecimal getPrice() {
//        return price;
//    }
//
//    public void setPrice(BigDecimal price) {
//        this.price = price;
//    }
//
//
////    public BufferedImage getImage() {
////        return image;
////    }
////
////    public void setImage(BufferedImage image) {
////        this.image = image;
////    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Property property = (Property) o;
//        return propertyId == property.propertyId && landlordId == property.landlordId && Objects.equals(name, property.name) && Objects.equals(address, property.address) && Objects.equals(description, property.description) && Objects.equals(price, property.price);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(propertyId, name, landlordId, address, description, price);
//    }
//
//    @Override
//    public String toString() {
//        return "Property{" +
//                "propertyId=" + propertyId +
//                ", name='" + name + '\'' +
//                ", landlordId=" + landlordId +
//                ", address='" + address + '\'' +
//                ", description='" + description + '\'' +
//                ", price=" + price +
//                '}';
//    }
}


