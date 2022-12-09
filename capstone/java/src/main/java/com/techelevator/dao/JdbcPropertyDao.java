package com.techelevator.dao;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.techelevator.model.Property;
import com.techelevator.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.jdbc.support.rowset.SqlRowSetMetaData;
import org.springframework.stereotype.Component;

import java.awt.image.BufferedImage;
import java.security.Principal;
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
        String sql = "SELECT property_id, name, landlord_id, address, description, price FROM properties";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()){
            Property property = mapRowToProperty(results);
            properties.add(property);
        }
        return properties;
    }

    @Override
    public Property findProperty(int propertyId){
        Property property = null;
        String sql = "SELECT property_id, name, landlord_id, address, description, price FROM properties WHERE property_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, propertyId);
        if(results.next()){
            property = mapRowToProperty(results);
        }
        return property;
    }

    @Override
    public Property createProperty(Property property){
        String sql ="INSERT INTO properties(name, address, description, price VALUES (?, ?, ?, ?, ?) RETURNING property_id ";
        int propertyId = jdbcTemplate.queryForObject(sql, Integer.class, property.getName(), property.getAddress(), property.getDescription(), property.getPrice());

        property.setPropertyId(propertyId);
        return property;

    }

    @Override
    public void updateProperty(int propertyId){
        String sql = "UPDATE properties SET name = ?, landlord_id = ?, address = ?, description = ?, price = ? WHERE property_id = ?;";
        jdbcTemplate.update(sql, propertyId);
    }

//    @Override
//    public int findLandlordId(Principal principal){
//        String sql = "SELECT properties.landlord_id FROM properties JOIN users ON properties.landlord_id = users.user_id WHERE users.user_id = ?;";
//        int landlordId = jdbcTemplate.queryForObject(sql, Integer.class, principal.getName());
//        return landlordId;
//    }



    private Property mapRowToProperty(SqlRowSet rowset) {
        Property property = new Property();
        property.setPropertyId(rowset.getInt("property_id"));
        property.setName(rowset.getString("name"));
        property.setLandlordId(rowset.getInt("landlord_id"));
        property.setAddress(rowset.getString("address"));
        property.setDescription(rowset.getString("description"));
        property.setPrice(rowset.getBigDecimal("price"));
        return property;
    }
}
