package com.techelevator.dao;

import com.techelevator.model.Request;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcRequestDao implements RequestDao {

    private JdbcTemplate jdbcTemplate = new JdbcTemplate();

    @Override
    public List<Request> viewMaintRequests(){
        List<Request> maintRequests = new ArrayList<>();
        String sql = "SELECT request_id, renter_id, property_id, maintenance_status_id, date, description FROM maintenance_requests ORDER BY date";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()){
            Request request = mapRowToRequest(results);
            maintRequests.add(request);
        }
        return maintRequests;
    }

    private Request mapRowToRequest(SqlRowSet rowSet){
        Request request = new Request();
        request.setRequestId(rowSet.getInt("request_id"));
        request.setRenterId(rowSet.getInt("renter_id"));
        request.setPropertyId(rowSet.getInt("property_id"));
        request.setMaintStatusId(rowSet.getInt("maintenance_status_id"));
        request.setDate(rowSet.getDate("date"));
        request.setDescription(rowSet.getString("description"));
        return request;
    }
}
