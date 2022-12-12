package com.techelevator.controller;

import com.techelevator.dao.PropertyDao;
import com.techelevator.dao.RequestDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Property;
import com.techelevator.model.Request;
import com.techelevator.model.RequestDto;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
public class RequestController {
    private final RequestDao requestDao;
    private final UserDao userDao;
    private final PropertyDao propertyDao;

    public RequestController(RequestDao requestDao, UserDao userDao, PropertyDao propertyDao){
        this.requestDao = requestDao;
        this.userDao = userDao;
        this.propertyDao = propertyDao;
    }

    @RequestMapping(path = "/maintenanceRequests", method = RequestMethod.GET)
    public List<Request> viewRequests(){
        return requestDao.viewMaintRequests();
    }

    @RequestMapping(path = "/submitMaintenanceRequest", method = RequestMethod.POST)
    public void submitRequest(@RequestBody RequestDto requestDto, Principal principal){
        Request request = new Request();
        request.setRenterId(requestDto.getRenter_id());
        request.setPropertyId(requestDto.getProperty_id());
        request.setDate(requestDto.getDate());
        request.setDescription(requestDto.getDescription());
        requestDao.submitRequest(request);
    }

//    @RequestMapping(path = "/assignMaintenanceWorker", method = RequestMethod.PUT)
//    public void assignWorker(@RequestBody )

}
