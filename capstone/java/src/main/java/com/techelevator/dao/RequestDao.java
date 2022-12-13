package com.techelevator.dao;

import com.techelevator.model.Request;

import java.security.Principal;
import java.util.List;

public interface RequestDao {

    List<Request> viewMaintRequests(Principal principal);

    Request submitRequest(Request request);

//    public void updateRequest(int requestId);
}
