package com.techelevator.service;

import com.techelevator.model.Property;
import com.techelevator.model.PropertyDetailsDto;
import com.techelevator.model.properties.PropertyDetails;
import com.techelevator.model.properties.RentalProperties;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import org.springframework.http.*;
import org.springframework.http.HttpHeaders;

import java.util.ArrayList;
import java.util.List;


@Service
public class RestPropertyService {

    private static final String API_KEY = "X-RapidAPI-Key";
    private static final String API_VALUE = "c786a1110dmsh96a4d70ff5f2b67p1e1552jsn2f2f31d7153e";
    private static final String API_URL = "https://zillow69.p.rapidapi.com/search";
    private final RestTemplate restTemplate;

    public RestPropertyService(){
        this.restTemplate = new RestTemplate();
    }

    public PropertyDetails[] getRentalProperty(int location, int rentMinPrice, int rentMaxPrice, int bedsMin, int bedsMax){

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set(API_KEY, API_VALUE); //ToDo Need to make sure API KEY and API VALUE are entered into headers correctly
        HttpEntity<String> entity = new HttpEntity<>(null, headers); //ToDo Make sure this is correct

        try{
            ResponseEntity<RentalProperties> response = restTemplate.exchange(
                    API_URL + "?location=" + location + "&status_type=ForRent&home_type=Apartments&rentMinPrice=" + rentMinPrice +
                            "&rentMaxPrice=" + rentMaxPrice + "&bedsMin=" + bedsMin + "&bedsMax=" + bedsMax, HttpMethod.GET, entity, RentalProperties.class);

            if(response != null && response.getBody() != null){
                return response.getBody().getListOfDetails().toArray(new PropertyDetails[0]);
            }
        }catch(RestClientResponseException e){
            System.out.println(e.getMessage());
        }catch(ResourceAccessException e){
            System.out.println(e.getMessage());
        }
        return new PropertyDetails[] {};
    }

    public List<PropertyDetailsDto> getPropertyDetailsDtoList(int location, int rentMinPrice, int rentMaxPrice, int bedsMin, int bedsMax){
        PropertyDetails[] propertyDetails = getRentalProperty(location, rentMinPrice, rentMaxPrice, bedsMin, bedsMax);
        List<PropertyDetailsDto> propertiesList = new ArrayList<>();
        for(PropertyDetails thisProperty : propertyDetails){
            PropertyDetailsDto currentPropertyDetailDto = mapToDto(thisProperty);
            propertiesList.add(currentPropertyDetailDto);
        }

        return propertiesList;
    }


    public PropertyDetailsDto mapToDto(PropertyDetails propertyDetails){
        PropertyDetailsDto propertyDetailsDto = new PropertyDetailsDto();
        propertyDetailsDto.setZpid(propertyDetails.getZpid());
        propertyDetailsDto.setAddress(propertyDetails.getAddress());
        propertyDetailsDto.setImgSrc(propertyDetails.getImgSrc());
        propertyDetailsDto.setHasImage(propertyDetails.getHasImage());
        propertyDetailsDto.setBathrooms(propertyDetails.getBathrooms());
        propertyDetailsDto.setBedrooms(propertyDetails.getBedrooms());
        propertyDetailsDto.setLivingArea(propertyDetails.getLivingArea());
        propertyDetailsDto.setPrice(propertyDetails.getPrice());
        propertyDetailsDto.setLatitude(propertyDetails.getLatitude());
        propertyDetailsDto.setLongitude(propertyDetails.getLongitude());
        return propertyDetailsDto;
    }
}
