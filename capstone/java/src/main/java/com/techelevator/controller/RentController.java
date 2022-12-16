package com.techelevator.controller;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.techelevator.dao.PropertyDao;
import com.techelevator.dao.RentDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Property;
import com.techelevator.model.PropertyLandlordRent;
import com.techelevator.model.Rent;
import com.techelevator.model.User;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;

@CrossOrigin
@RestController
public class RentController {
    private final RentDao rentDao;
    private final UserDao userDao;
    private final PropertyDao propertyDao;

    public RentController(RentDao rentDao, UserDao userDao, PropertyDao propertyDao){
        this.rentDao = rentDao;
        this.userDao = userDao;
        this.propertyDao = propertyDao;
    }

    @RequestMapping(path = "/viewMyRent", method = RequestMethod.GET)
    public int viewMyRent(Principal principal){
        int id = userDao.findIdByUsername(principal.getName());
        return rentDao.viewMyRent(id);
    }

    @RequestMapping(path = "/viewLandlordProperties", method = RequestMethod.GET)
    public List<PropertyLandlordRent> getLandlordProperties(Principal principal){
        int id = userDao.findIdByUsername(principal.getName());
        return rentDao.viewRentalsByLandlord(id);
    }

    @RequestMapping(path = "/updateRentDetails", method = RequestMethod.PUT)
    public void updateRentDetails(@RequestBody Property property, Principal principal){
        rentDao.updateLandlordRentDetails(property, principal);
    }

//    @RequestMapping(path = "/updateRentStatusToPaid/{propertyId}", method = RequestMethod.PUT)
//    public void updateRentStatus(@PathVariable int propertyId, Principal principal){
//        rentDao.updateRentStatus(propertyId, principal);
//    }
//
//    @RequestMapping(path = "/updateOverdueRent/{propertyId}", method = RequestMethod.PUT)
//    public void updateOverdueStatus(@PathVariable int propertyId, Principal principal){
//        rentDao.updateOverdueStatus(propertyId, principal);
//    }
}
