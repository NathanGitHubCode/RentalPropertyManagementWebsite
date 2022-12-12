package com.techelevator.controller;

import com.techelevator.dao.PropertyDao;
import com.techelevator.dao.RentDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Rent;
import com.techelevator.model.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.security.Principal;

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
    public BigDecimal viewMyRent(Principal principal){
        int id = userDao.findIdByUsername(principal.getName());
        return rentDao.viewMyRent(id);
    }
}
