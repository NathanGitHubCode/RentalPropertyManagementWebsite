package com.techelevator.model;

import java.math.BigDecimal;
import java.util.Objects;
import java.awt.image.BufferedImage;
public class Property {
    private int propertyId;
    private String name;
    private int landlordId;
    private String address;
    private String description;
    private BigDecimal price;
    private boolean isAvailable;
    private int renterId;
//    private BufferedImage image;

    public Property(int propertyId, String name, int landlordId, String address, String description, BigDecimal price, boolean isAvailable, int renterId) {
        this.propertyId = propertyId;
        this.name = name;
        this.landlordId = landlordId;
        this.address = address;
        this.description = description;
        this.price = price;
        this.isAvailable = isAvailable;
        this.renterId = renterId;
//        this.image = image;
    }

    public Property() {

    }

    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLandlordId() {
        return landlordId;
    }

    public void setLandlordId(int landlordId) {
        this.landlordId = landlordId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public int getRenterId() {
        return renterId;
    }

    public void setRenterId(int renterId) {
        this.renterId = renterId;
    }

//    public BufferedImage getImage() {
//        return image;
//    }
//
//    public void setImage(BufferedImage image) {
//        this.image = image;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Property property = (Property) o;
        return propertyId == property.propertyId && landlordId == property.landlordId && isAvailable == property.isAvailable && renterId == property.renterId && Objects.equals(name, property.name) && Objects.equals(address, property.address) && Objects.equals(description, property.description) && Objects.equals(price, property.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(propertyId, name, landlordId, address, description, price, isAvailable, renterId);
    }

    @Override
    public String toString() {
        return "Property{" +
                "propertyId=" + propertyId +
                ", name='" + name + '\'' +
                ", landlordId=" + landlordId +
                ", address='" + address + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", isAvailable=" + isAvailable +
                ", renterId=" + renterId +
                '}';
    }
}


