package com.techelevator.model;

import java.util.Date;

public class RequestDto {

    private Integer request_id;
    private Integer renter_id;
    private Integer property_id;
    private Date date;
    private String description;
    private Integer maintenance_status_id;

    public Integer getRequest_id() {
        return request_id;
    }

    public void setRequest_id(Integer request_id) {
        this.request_id = request_id;
    }

    public Integer getRenter_id() {
        return renter_id;
    }

    public void setRenter_id(Integer renter_id) {
        this.renter_id = renter_id;
    }

    public Integer getProperty_id() {
        return property_id;
    }

    public void setProperty_id(Integer property_id) {
        this.property_id = property_id;
    }

    public Date getDate() {
        return date;
    }


    public String getDescription() {
        return description;
    }



    public Integer getMaintenance_status_id() {
        return maintenance_status_id;
    }

    public void setMaintenance_status_id(Integer maintenance_status_id) {
        this.maintenance_status_id = maintenance_status_id;
    }





}
