package com.techelevator.controller;

import com.techelevator.model.PropertyDetailsDto;
import com.techelevator.service.RestPropertyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class ZillowController {
    private RestPropertyService restPropertyService;

    public ZillowController(RestPropertyService restPropertyService){
        this.restPropertyService = restPropertyService;
    }

    @RequestMapping(path = "/rentals/{location}/{rentMinPrice}/{rentMaxPrice}/{bedsMin}/{bedsMax}", method = RequestMethod.GET)
    public List<PropertyDetailsDto> getRentalPropertiesList(@PathVariable Integer location, @PathVariable Integer rentMinPrice,
                                                            @PathVariable Integer rentMaxPrice, @PathVariable Integer bedsMin, @PathVariable Integer bedsMax){
        List<PropertyDetailsDto> propertyDetailsDtoList = restPropertyService.getPropertyDetailsDtoList(location, rentMinPrice, rentMaxPrice, bedsMin, bedsMax);
        return propertyDetailsDtoList;
    }

}
