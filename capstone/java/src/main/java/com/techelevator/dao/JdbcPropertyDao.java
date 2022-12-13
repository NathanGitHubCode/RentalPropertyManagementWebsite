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
        String sql = "SELECT property_id, address, property_image, has_image, bathrooms, bedrooms, living_area, price, landlord_id, is_available FROM available_properties";
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
        String sql = "SELECT property_id, address, property_image, has_image, bathrooms, bedrooms, living_area, price, landlord_id, is_available FROM available_properties WHERE property_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, propertyId);
        if(results.next()){
            property = mapRowToProperty(results);
        }
        return property;
    }

    @Override
    public Property createAvailableProperty(Property property){
        String sql ="INSERT INTO available_properties(address, property_image, has_image, bathrooms, bedrooms, living_area, price, landlord_id, is_available) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING property_id ";
        int propertyId = jdbcTemplate.queryForObject(sql, Integer.class, property.getAddress(), property.getImgSrc(), property.getHasImage(), property.getBathrooms(), property.getBedrooms(), property.getLivingArea(), property.getPrice(), property.getLandlord_id(), property.isAvailable());

        property.setPropertyId(propertyId);
        return property;

    }

    @Override
    public void updateProperty(Property property){
        String sql = "UPDATE available_properties SET bathrooms = ?, bedrooms = ?, living_area = ?, price = ?, landlord_id = ?, is_available = ? WHERE property_id = ?;";
        jdbcTemplate.update(sql, property.getBathrooms(), property.getBedrooms(), property.getLivingArea(), property.getPrice(),property.getLandlord_id(), property.isAvailable(), property.getPropertyId());
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
        property.setImgSrc(rowset.getString("property_image"));
        property.setHasImage(rowset.getBoolean("has_image"));
        property.setAddress(rowset.getString("address"));
        property.setBathrooms(rowset.getInt("bathrooms"));
        property.setBedrooms(rowset.getInt("bedrooms"));
        property.setLivingArea(rowset.getInt("living_area"));
        property.setPrice(rowset.getInt("price"));
        property.setLandlord_id(rowset.getInt("landlord_id"));
        property.setAvailable(rowset.getBoolean("is_available"));
        return property;
    }
}
