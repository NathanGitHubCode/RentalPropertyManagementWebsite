package com.techelevator.dao;

import com.techelevator.model.Request;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.security.Principal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcRequestDao implements RequestDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcRequestDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Request> viewMaintRequests(Principal principal ){
        String sql1 = "SELECT role FROM users WHERE username = ?";
        String role = jdbcTemplate.queryForObject(sql1, String.class, principal.getName());
        String sql = "";
        List<Request> maintRequests = new ArrayList<>();
        if (role.equals("ROLE_LANDLORD")){
             sql = "SELECT mr.request_id, mr.renter_id, mr.property_id, mr.address, mr.maintenance_status_id, mr.employee_id, mr.date, mr.description, mr.contact_phone " +
                     "FROM maintenance_requests AS mr" +
                     "JOIN available_properties AS ap ON ap.property_id = mr.property_id" +
                     "WHERE ap.landlord_id = ?" +
                     "ORDER BY date";
        }else if (role.equals("ROLE_EMPLOYEE")){
             sql = "SELECT request_id, renter_id, property_id, address, maintenance_status_id, employee_id, date, description, contact_phone " +
                    " FROM maintenance_requests " +
                     "WHERE employee_id = ?" +
                      "ORDER BY date";
        }else if (role.equals("ROLE_RENTER")) {
             sql = "SELECT request_id, renter_id, property_id, address, maintenance_status_id, employee_id, date, description, contact_phone " +
                    " FROM maintenance_requests" +
                     "WHERE renter_id = ?" +
                     "ORDER BY date";
        }
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()){
            Request request = mapRowToRequest(results);
            maintRequests.add(request);
        }
        return maintRequests;
    }
    @Override
    public Request submitRequest(Request request){
        String sql = "INSERT INTO maintenance_requests(renter_id, property_id, address, date, description, maintenance_status_id, contact_phone) VALUES(?, ?, ?, ?, ?, 1, ?) RETURNING request_id";
        int requestId = jdbcTemplate.queryForObject(sql, Integer.class, request.getRenterId(), request.getPropertyId(), request.getAddress(), request.getDate(), request.getDescription(), request.getPhoneNumber());

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
        request.setAddress(rowset.getString("address"));
        request.setMaintStatusId(rowset.getInt("maintenance_status_id"));
        request.setDate(LocalDate.now());
        request.setDescription(rowset.getString("description"));
        request.setPhoneNumber(rowset.getString("contact_phone"));
        return request;
    }
}
