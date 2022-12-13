package com.techelevator.dao;

import com.techelevator.model.Property;
import com.techelevator.model.Rent;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Component
public class JdbcRentDao implements RentDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcRentDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    //ToDo Check if amount is all that is needed
    @Override
    public BigDecimal viewMyRent(int id){
        String sql = "SELECT amount FROM rent WHERE renter_id = ?;";
        BigDecimal rent = jdbcTemplate.queryForObject(sql, BigDecimal.class, id);
        return rent;
    }

    @Override
    public List<Property> viewRentalsByLandlord(int landlordId) {
        List<Property> landlordProperties = null;
        String sql = "SELECT property_id, address, price, amount, due_date, status FROM available_properties WHERE landlord_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, Property.class);
        while(results.next()){
//            landlordProperties.add(mapRowForLandlord(results));
        }
        return landlordProperties;
    }

    @Override
    public void assignRenterToProperty(){

    }


    private Rent mapRowForLandlord(SqlRowSet rowSet){
        Rent rent = new Rent();
        rent.setPropertyId(rowSet.getInt("property_id"));
        rent.setRenterId(rowSet.getInt("renter_id"));
        rent.setStatus(rowSet.getString("status"));
        rent.setAmount(rowSet.getBigDecimal("amount"));

//        rent.setDate(rowSet.getDate("due_date").toLocalDate());
        return rent;
    }


    private Rent mapRowToRent(SqlRowSet rowSet){
        Rent rent = new Rent();
        rent.setRentId(rowSet.getInt("rent_id"));
        rent.setPropertyId(rowSet.getInt("property_id"));
        rent.setRenterId(rowSet.getInt("renter_id"));
        rent.setStatus(rowSet.getString("status"));
        rent.setAmount(rowSet.getBigDecimal("amount"));
        rent.setDate(rowSet.getDate("date"));
        return rent;
    }




}
