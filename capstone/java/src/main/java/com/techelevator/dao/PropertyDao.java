package com.techelevator.dao;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.techelevator.model.Property;

import java.security.Principal;
import java.util.List;

public interface PropertyDao {
    List<Property> findAllProperties();

    Property findProperty(int propertyId);

    Property createAvailableProperty(Property property);

    public void updateProperty(Property property);

    public int findPropertyIdByRenterId(Principal principal);

    public String findAddressByPropertyId(int propertyId);

//    public int findLandlordId(Principal principal);
}


