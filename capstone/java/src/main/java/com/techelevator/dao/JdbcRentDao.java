package com.techelevator.dao;

import com.techelevator.model.Property;
import com.techelevator.model.PropertyLandlordRent;
import com.techelevator.model.Rent;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class JdbcRentDao implements RentDao{

    private JdbcTemplate jdbcTemplate;
    private UserDao userDao;

    public JdbcRentDao(JdbcTemplate jdbcTemplate, UserDao userDao){
        this.jdbcTemplate = jdbcTemplate;
        this.userDao = userDao;
    }

    //ToDo Check if amount is all that is needed
    @Override
    public int viewMyRent(int id){
        String sql = "SELECT price FROM available_properties WHERE renter_id = ?;";
        int rent = jdbcTemplate.queryForObject(sql, Integer.class, id);
        return rent;
    }

    @Override
    public List<PropertyLandlordRent> viewRentalsByLandlord(int landlordId) {
        List<PropertyLandlordRent> landlordProperties = new ArrayList<>();
        String sql = "SELECT property_id, address, price, balance, due_date, status FROM available_properties WHERE landlord_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, landlordId);
        while(results.next()){
            landlordProperties.add(mapRowForLandlord(results));
        }
        return landlordProperties;
    }

    @Override
    public void updateLandlordRentDetails(Property property, Principal principal) {
        int id = userDao.findIdByUsername(principal.getName());
        String sql2 = "SELECT landlord_id FROM available_properties WHERE property_id = ?;";
        int landlordId = jdbcTemplate.queryForObject(sql2, Integer.class, property.getPropertyId());
        if (id == landlordId) {
            String sql = "UPDATE available_properties SET balance = ?, status = ?, due_date = ? WHERE property_id = ?;";
            jdbcTemplate.update(sql, property.getBalance(), property.getStatus(), property.getDueDate(), property.getPropertyId());
        }
    }

    @Override
    public void assignRenterToProperty(int propertyId, int renterId, Principal principal){
        String sql2 = "SELECT landlord_id FROM available_properties WHERE property_id = ?;";
        int landlordId = jdbcTemplate.queryForObject(sql2, Integer.class, propertyId);
        if(landlordId != userDao.findIdByUsername(principal.getName())){
            String sql = "UPDATE available_properties SET renter_id = ?, is_available = ? WHERE property_id = ?;";
            jdbcTemplate.update(sql, renterId, false, propertyId);
        }
        //Todo what to return if update isn't successful/conditions aren't met
    }


    private PropertyLandlordRent mapRowForLandlord(SqlRowSet rowSet){
        PropertyLandlordRent property = new PropertyLandlordRent();
        property.setPropertyId(rowSet.getInt("property_id"));
        property.setAddress(rowSet.getString("address"));
        property.setPrice(rowSet.getInt("price"));
        property.setStatus(rowSet.getString("status"));
        property.setBalance(rowSet.getInt("balance"));
        property.setDueDate(rowSet.getDate("due_date"));
        return property;
    }


    private Rent mapRowToRent(SqlRowSet rowSet){
        Rent rent = new Rent();
        rent.setRentId(rowSet.getInt("rent_id"));
        rent.setPropertyId(rowSet.getInt("property_id"));
        rent.setRenterId(rowSet.getInt("renter_id"));
        rent.setStatus(rowSet.getInt("status"));
        rent.setDate(rowSet.getDate("date"));
        return rent;
    }




}
