package com.techelevator.dao;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class JdbcRentDao implements RentDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcRentDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public BigDecimal viewRent(int rentId){
        String sql = "SELECT amount FROM rent WHERE rent_id = ?;";
        BigDecimal rent = jdbcTemplate.queryForObject(sql, BigDecimal.class, rentId);
        return rent;
    }


}
