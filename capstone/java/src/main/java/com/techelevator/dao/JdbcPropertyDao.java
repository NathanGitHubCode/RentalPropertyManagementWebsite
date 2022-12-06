package com.techelevator.dao;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.techelevator.model.Property;
import com.techelevator.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.jdbc.support.rowset.SqlRowSetMetaData;
import org.springframework.stereotype.Component;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class JdbcPropertyDao implements PropertyDao {
    private JdbcTemplate jdbcTemplate;

    public JdbcPropertyDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Property> findAllProperties(){
        List<Property> properties = new ArrayList<>();
        String sql = "SELECT property_id, name, landlord_id, address, description, price, isAvailable, renter_id FROM properties";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()){
            Property property = mapRowToProperty(results);
            properties.add(property);
        }
        return properties;


    }

    private Property mapRowToProperty(SqlRowSet rowset) {
        Property property = new Property();
        property.setPropertyId(rowset.getInt("property_id"));
        property.setName(rowset.getString("name"));
        property.setLandlordId(rowset.getInt("landlord_id"));
        property.setAddress(rowset.getString("address"));
        property.setDescription(rowset.getString("description"));
        property.setPrice(rowset.getBigDecimal("price"));
        property.setAvailable(rowset.getBoolean("isAvailable"));
        property.setRenterId(rowset.getInt("renter_id"));
        return property;
    }
}
