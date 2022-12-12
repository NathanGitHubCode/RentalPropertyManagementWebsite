package com.techelevator.dao;

import com.techelevator.model.Rent;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class JdbcRentDao implements RentDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcRentDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public BigDecimal viewMyRent(int id){
        String sql = "SELECT amount FROM rent WHERE renter_id = ?;";
        BigDecimal rent = jdbcTemplate.queryForObject(sql, BigDecimal.class, id);
        return rent;
    }

    private Rent mapRowToRent(SqlRowSet rowSet){
        Rent rent = new Rent();
        rent.setRentId(rowSet.getInt("rent_id"));
        rent.setPropertyId(rowSet.getInt("property_id"));
        rent.setRenterId(rowSet.getInt("renter_id"));
        rent.setLandlordId(rowSet.getInt("landlord_id"));
        rent.setAmountDue(rowSet.getBigDecimal("amount_due"));
        rent.setDate(rowSet.getDate("date"));
        return rent;
    }




}
