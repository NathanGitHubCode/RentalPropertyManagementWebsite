package com.techelevator.controller;

import com.techelevator.dao.PropertyDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Property;
import com.techelevator.model.PropertyDto;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;
import javax.annotation.security.PermitAll;
import java.security.Principal;
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

    @RequestMapping(path = "/viewListings/{propertyId}", method = RequestMethod.GET)
    public Property viewProperty(@PathVariable Integer propertyId){
        return propertyDao.findProperty(propertyId);
    }

    @RequestMapping(path = "/addProperty", method = RequestMethod.POST)
    public void addProperty(@RequestBody PropertyDto propertyDto, Principal principal){
        Property property = new Property();
        property.setName(propertyDto.getName());
//        property.setLandlordId(findLandlordId(principal));
        property.setAddress(propertyDto.getAddress());
        property.setDescription(propertyDto.getDescription());
        property.setPrice(propertyDto.getPrice());
        propertyDao.createProperty(property);
    }

}
