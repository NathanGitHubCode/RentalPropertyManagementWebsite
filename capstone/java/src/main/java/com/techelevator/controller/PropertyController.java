package com.techelevator.controller;

import com.techelevator.dao.PropertyDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Property;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.PermitAll;
import java.util.List;


@RestController
public class PropertyController {
    private final PropertyDao propertyDao;
    private final UserDao userDao;

    public PropertyController(PropertyDao propertyDao, UserDao userDao ){
        this.propertyDao = propertyDao;
        this.userDao = userDao;
    }

    @RequestMapping(path = "/viewListings", method = RequestMethod.GET)
    public List<Property> returnListings(){
        return propertyDao.findAllProperties();
    }

}
