package com.techelevator.controller;

import com.techelevator.dao.PropertyDao;
import com.techelevator.dao.RequestDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Property;
import com.techelevator.model.Request;
import com.techelevator.model.RequestDto;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@CrossOrigin
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
    public List<Request> viewRequests(Principal principal){

        return requestDao.viewMaintRequests(principal);
    }

    @RequestMapping(path = "/requestMaintenance", method = RequestMethod.POST)
    public void submitRequest(@RequestBody RequestDto requestDto, Principal principal){
        Request request = new Request();
        request.setRenterId(userDao.findIdByUsername(principal.getName()));
        request.setPropertyId(propertyDao.findPropertyIdByRenterId(principal));
        request.setAddress(propertyDao.findAddressByPropertyId(propertyDao.findPropertyIdByRenterId(principal)));
        request.setDate(LocalDate.now());
        request.setDescription(requestDto.getDescription());
        request.setPhoneNumber(requestDto.getPhoneNumber());
        requestDao.submitRequest(request);
    }

    @RequestMapping(path = "/assignMaintenanceWorker/employee/{employeeId}/property/{propertyId}/request/{requestId}", method = RequestMethod.PUT)
    public void assignWorker(@PathVariable int propertyId, @PathVariable int employeeId, @PathVariable int requestId, Principal principal){
        requestDao.assignEmployeeToRequest(propertyId, employeeId, requestId, principal);
    }

}
