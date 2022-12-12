package com.techelevator.dao;

import com.techelevator.model.Request;

import java.util.List;

public interface RequestDao {

    List<Request> viewMaintRequests();

    Request submitRequest(Request request);

//    public void updateRequest(int requestId);
}
