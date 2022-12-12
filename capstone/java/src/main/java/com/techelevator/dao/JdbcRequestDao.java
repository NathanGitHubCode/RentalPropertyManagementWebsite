package com.techelevator.dao;

import com.techelevator.model.Request;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcRequestDao implements RequestDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcRequestDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

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
    @Override
    public Request submitRequest(Request request){
        String sql = "INSERT INTO maintenance_requests(renter_id, property_id, date, description, maintenance_status_id) VALUES(?, ?, ?, ?, 1) RETURNING request_id";
        int requestId = jdbcTemplate.queryForObject(sql, Integer.class, request.getRenterId(), request.getPropertyId(), request.getDate(), request.getDescription());

        request.setRequestId(requestId);
        return request;

    }

//    @Override
//    public void updateRequest(int requestId){
//        String sql = "UPDATE maintenance_requests SET maintenance_status_id = 2"
//    }



    private Request mapRowToRequest(SqlRowSet rowset){
        Request request = new Request();
        request.setRequestId(rowset.getInt("request_id"));
        request.setRenterId(rowset.getInt("renter_id"));
        request.setPropertyId(rowset.getInt("property_id"));
        request.setMaintStatusId(rowset.getInt("maintenance_status_id"));
        request.setDate(rowset.getDate("date"));
        request.setDescription(rowset.getString("description"));
        return request;
    }
}
