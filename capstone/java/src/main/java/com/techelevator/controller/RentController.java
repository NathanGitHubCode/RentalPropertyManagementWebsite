package com.techelevator.controller;

import com.techelevator.dao.PropertyDao;
import com.techelevator.dao.RentDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Rent;
import com.techelevator.model.User;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.security.Principal;

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
}
