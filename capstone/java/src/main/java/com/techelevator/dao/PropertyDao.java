package com.techelevator.dao;

import com.techelevator.model.Property;

import java.security.Principal;
import java.util.List;

public interface PropertyDao {
    List<Property> findAllProperties();

    Property findProperty(int propertyId);

    Property createAvailableProperty(Property property);

    public void updateProperty(int propertyId);

//    public int findLandlordId(Principal principal);
}


