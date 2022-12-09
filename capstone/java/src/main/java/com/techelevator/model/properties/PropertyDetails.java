package com.techelevator.model.properties;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "zpid",
        "address",
        "imgSrc",
        "hasImage",
        "contingentListingType",
        "currency",
        "country",
        "daysOnZillow",
        "dateSold",
        "bathrooms",
        "bedrooms",
        "livingArea",
        "lotAreaValue",
        "lotAreaUnit",
        "propertyType",
        "listingStatus",
        "listingSubType",
        "price",
        "latitude",
        "longitude"
})
@Generated("jsonschema2pojo")
public class PropertyDetails {

    @JsonProperty("zpid")
    private String zpid;
    @JsonProperty("address")
    private String address;
    @JsonProperty("imgSrc")
    private String imgSrc;
    @JsonProperty("hasImage")
    private Boolean hasImage;
    @JsonProperty("contingentListingType")
    private Object contingentListingType;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("country")
    private String country;
    @JsonProperty("daysOnZillow")
    private Integer daysOnZillow;
    @JsonProperty("dateSold")
    private Object dateSold;
    @JsonProperty("bathrooms")
    private Integer bathrooms;
    @JsonProperty("bedrooms")
    private Integer bedrooms;
    @JsonProperty("livingArea")
    private Integer livingArea;
    @JsonProperty("lotAreaValue")
    private Integer lotAreaValue;
    @JsonProperty("lotAreaUnit")
    private String lotAreaUnit;
    @JsonProperty("propertyType")
    private String propertyType;
    @JsonProperty("listingStatus")
    private String listingStatus;
    @JsonProperty("listingSubType")
    private ListingSubType listingSubType;
    @JsonProperty("price")
    private Integer price;
    @JsonProperty("latitude")
    private Double latitude;
    @JsonProperty("longitude")
    private Double longitude;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("zpid")
    public String getZpid() {
        return zpid;
    }

    @JsonProperty("zpid")
    public void setZpid(String zpid) {
        this.zpid = zpid;
    }

    @JsonProperty("address")
    public String getAddress() {
        return address;
    }

    @JsonProperty("address")
    public void setAddress(String address) {
        this.address = address;
    }

    @JsonProperty("imgSrc")
    public String getImgSrc() {
        return imgSrc;
    }

    @JsonProperty("imgSrc")
    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    @JsonProperty("hasImage")
    public Boolean getHasImage() {
        return hasImage;
    }

    @JsonProperty("hasImage")
    public void setHasImage(Boolean hasImage) {
        this.hasImage = hasImage;
    }

    @JsonProperty("contingentListingType")
    public Object getContingentListingType() {
        return contingentListingType;
    }

    @JsonProperty("contingentListingType")
    public void setContingentListingType(Object contingentListingType) {
        this.contingentListingType = contingentListingType;
    }

    @JsonProperty("currency")
    public String getCurrency() {
        return currency;
    }

    @JsonProperty("currency")
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
    }

    @JsonProperty("daysOnZillow")
    public Integer getDaysOnZillow() {
        return daysOnZillow;
    }

    @JsonProperty("daysOnZillow")
    public void setDaysOnZillow(Integer daysOnZillow) {
        this.daysOnZillow = daysOnZillow;
    }

    @JsonProperty("dateSold")
    public Object getDateSold() {
        return dateSold;
    }

    @JsonProperty("dateSold")
    public void setDateSold(Object dateSold) {
        this.dateSold = dateSold;
    }

    @JsonProperty("bathrooms")
    public Integer getBathrooms() {
        return bathrooms;
    }

    @JsonProperty("bathrooms")
    public void setBathrooms(Integer bathrooms) {
        this.bathrooms = bathrooms;
    }

    @JsonProperty("bedrooms")
    public Integer getBedrooms() {
        return bedrooms;
    }

    @JsonProperty("bedrooms")
    public void setBedrooms(Integer bedrooms) {
        this.bedrooms = bedrooms;
    }

    @JsonProperty("livingArea")
    public Integer getLivingArea() {
        return livingArea;
    }

    @JsonProperty("livingArea")
    public void setLivingArea(Integer livingArea) {
        this.livingArea = livingArea;
    }

    @JsonProperty("lotAreaValue")
    public Integer getLotAreaValue() {
        return lotAreaValue;
    }

    @JsonProperty("lotAreaValue")
    public void setLotAreaValue(Integer lotAreaValue) {
        this.lotAreaValue = lotAreaValue;
    }

    @JsonProperty("lotAreaUnit")
    public String getLotAreaUnit() {
        return lotAreaUnit;
    }

    @JsonProperty("lotAreaUnit")
    public void setLotAreaUnit(String lotAreaUnit) {
        this.lotAreaUnit = lotAreaUnit;
    }

    @JsonProperty("propertyType")
    public String getPropertyType() {
        return propertyType;
    }

    @JsonProperty("propertyType")
    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    @JsonProperty("listingStatus")
    public String getListingStatus() {
        return listingStatus;
    }

    @JsonProperty("listingStatus")
    public void setListingStatus(String listingStatus) {
        this.listingStatus = listingStatus;
    }

    @JsonProperty("listingSubType")
    public ListingSubType getListingSubType() {
        return listingSubType;
    }

    @JsonProperty("listingSubType")
    public void setListingSubType(ListingSubType listingSubType) {
        this.listingSubType = listingSubType;
    }

    @JsonProperty("price")
    public Integer getPrice() {
        return price;
    }

    @JsonProperty("price")
    public void setPrice(Integer price) {
        this.price = price;
    }

    @JsonProperty("latitude")
    public Double getLatitude() {
        return latitude;
    }

    @JsonProperty("latitude")
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    @JsonProperty("longitude")
    public Double getLongitude() {
        return longitude;
    }

    @JsonProperty("longitude")
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
