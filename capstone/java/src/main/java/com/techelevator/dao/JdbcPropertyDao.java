package com.techelevator.dao;

import com.techelevator.model.Property;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcPropertyDao implements PropertyDao {
    private JdbcTemplate jdbcTemplate;
    private UserDao userDao;

    public JdbcPropertyDao(JdbcTemplate jdbcTemplate, UserDao userDao) {
        this.jdbcTemplate = jdbcTemplate;
        this.userDao = userDao;
    }

    @Override
    public List<Property> findAllProperties(){
        List<Property> properties = new ArrayList<>();
        String sql = "SELECT property_id, address, property_image, has_image, bathrooms, bedrooms, living_area, price, landlord_id, is_available, renter_id, balance, status, due_date FROM available_properties";
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
        String sql = "SELECT property_id, address, property_image, has_image, bathrooms, bedrooms, living_area, price, landlord_id, is_available, renter_id, balance, status, due_date FROM available_properties WHERE property_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, propertyId);
        if(results.next()){
            property = mapRowToProperty(results);
        }
        return property;
    }

    @Override
    public Property createAvailableProperty(Property property){
        String sql ="INSERT INTO available_properties(address, property_image, has_image, bathrooms, bedrooms, living_area, price, landlord_id, is_available) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING property_id; ";
        int propertyId = jdbcTemplate.queryForObject(sql, Integer.class, property.getAddress(), property.getImgSrc(), property.getHasImage(), property.getBathrooms(), property.getBedrooms(), property.getLivingArea(), property.getPrice(), property.getLandlordId(), property.isAvailable());

        property.setPropertyId(propertyId);
        return property;
    }

    @Override
    public void updateProperty(Property property){
        Property propCheck = property;
        String sql = "UPDATE available_properties SET bathrooms = ?, bedrooms = ?, living_area = ?, price = ?, is_available = ? WHERE property_id = ?;";
        jdbcTemplate.update(sql, property.getBathrooms(), property.getBedrooms(), property.getLivingArea(), property.getPrice(), property.isAvailable(), property.getPropertyId());
    }

//    @Override
//    public int findLandlordId(Principal principal){
//        String sql = "SELECT properties.landlord_id FROM properties JOIN users ON properties.landlord_id = users.user_id WHERE users.user_id = ?;";
//        int landlordId = jdbcTemplate.queryForObject(sql, Integer.class, principal.getName());
//        return landlordId;
//    }

    @Override
    public int findPropertyIdByRenterId(Principal principal){
        int propertyId = 0;
        int renterId = userDao.findIdByUsername(principal.getName());
        String sql = "SELECT property_id FROM available_properties WHERE renter_id = ?;";
        propertyId = jdbcTemplate.queryForObject(sql, Integer.class, renterId);
        return propertyId;
    }

    @Override
    public String findAddressByPropertyId(int propertyId) {
        String address = "";
        String sql = "SELECT address FROM available_properties WHERE property_id = ?;";
        address = jdbcTemplate.queryForObject(sql, String.class, propertyId);
        return address;
    }

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
        property.setLandlordId(rowset.getInt("landlord_id"));
        property.setAvailable(rowset.getBoolean("is_available"));
        property.setRenterId(rowset.getInt("renter_id"));
//        if(rowset.getInt("balance") != null){
        property.setBalance(rowset.getInt("balance"));
        if(rowset.getString("status") != null) {
            property.setStatus(rowset.getString("status"));
        }
        if(rowset.getString("due_date") != null) {
            property.setDueDate(rowset.getDate("due_date"));
        }
        return property;
    }
}
