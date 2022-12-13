package com.techelevator.controller;

import com.techelevator.dao.PropertyDao;
import com.techelevator.dao.RentDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Property;
import com.techelevator.model.PropertyDto;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;
import java.util.List;

@CrossOrigin
@RestController
public class PropertyController {
    private final PropertyDao propertyDao;
    private final UserDao userDao;
    private final RentDao rentDao;

    public PropertyController(PropertyDao propertyDao, UserDao userDao, RentDao rentDao ){
        this.propertyDao = propertyDao;
        this.userDao = userDao;
        this.rentDao = rentDao;
    }

    @RequestMapping(path = "/properties", method = RequestMethod.GET)
    public List<Property> returnListings(){
        return propertyDao.findAllProperties();
    }

    @RequestMapping(path = "/properties/{propertyId}", method = RequestMethod.GET)
    public Property viewProperty(@PathVariable Integer propertyId){
        return propertyDao.findProperty(propertyId);
    }

    @RequestMapping(path = "/addProperty", method = RequestMethod.POST)
    public void addProperty(@RequestBody PropertyDto propertyDto, Principal principal){
        mapToPropertyFromDto(propertyDto, principal);
    }

    @RequestMapping(path = "/updateProperty/{propertyId}", method = RequestMethod.PUT)
    public void updateProperty(@PathVariable int propertyId, Principal principal){
        Property currentProperty = propertyDao.findProperty(propertyId);
        Property property = new Property();
        int principalId = userDao.findIdByUsername(principal.getName());
        int landlordId = currentProperty.getLandlordId();
        if(principalId == landlordId){
            property.setPropertyId(propertyId);
            property.setImgSrc(currentProperty.getImgSrc());
            property.setHasImage(currentProperty.getHasImage());
            property.setBathrooms(currentProperty.getBathrooms());
            property.setBedrooms(currentProperty.getBedrooms());
            property.setLivingArea(currentProperty.getLivingArea());
            property.setPrice(currentProperty.getPrice());
            property.setAvailable(currentProperty.isAvailable());
            propertyDao.updateProperty(property);
        }
    }

    @RequestMapping(path = "/updateProperty/assignRenter/{propertyId}/{renterId}", method = RequestMethod.PUT)
    public void assignRenter(@PathVariable int propertyId, @PathVariable int renterId, Principal principal){
//        Property currentProperty = propertyDao.findProperty(propertyId);
//        Property property = new Property();
//        property.setRenterId(renterId);
        rentDao.assignRenterToProperty(propertyId, renterId, principal);
    }

    @RequestMapping(path = "/whoami", method = RequestMethod.GET)
    public String whoAmI(Principal principal){
        return principal.getName();
    }

    public Property mapToPropertyFromDto(PropertyDto propertyDto, Principal principal){
        Property property = new Property();
        property.setAddress(propertyDto.getAddress());
        property.setImgSrc(propertyDto.getImgSrc());
        property.setHasImage(propertyDto.getHasImage());
        property.setBathrooms(propertyDto.getBathrooms());
        property.setBedrooms(propertyDto.getBedrooms());
        property.setLivingArea(propertyDto.getLivingArea());
        property.setPrice(propertyDto.getPrice());
        property.setLandlordId(userDao.findIdByUsername(principal.getName()));
        property.setAvailable(true);
        return propertyDao.createAvailableProperty(property);
    }

}
