package com.techelevator.dao;

import com.techelevator.model.Property;

import java.util.List;

public interface PropertyDao {
    List<Property> findAllProperties();

    Property findProperty(int propertyId);
}


