package com.techelevator.service;

import com.techelevator.model.Property;
import com.techelevator.model.PropertyDetailsDto;
import com.techelevator.model.properties.PropertyDetails;
import com.techelevator.model.properties.Props;
import com.techelevator.model.properties.RentalProperties;
import com.techelevator.model.properties.ZillowRoot;
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
    private static final String API_VALUE = "4b3b13aa59mshc55a207abaeab72p1e900ejsn2e91c34ef760";
    private static final String API_URL = "https://zillow69.p.rapidapi.com/search";
    private final RestTemplate restTemplate;

    public RestPropertyService(){
        this.restTemplate = new RestTemplate();
    }

    public Props[] getRentalProperty(int location, int rentMinPrice, int rentMaxPrice, int bedsMin, int bedsMax){

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set(API_KEY, API_VALUE); //ToDo Need to make sure API KEY and API VALUE are entered into headers correctly
        HttpEntity<String> entity = new HttpEntity<>(null, headers); //ToDo Make sure this is correct

        try{
            ResponseEntity<ZillowRoot> response = null;

            if (rentMinPrice == 0 && rentMaxPrice == 0 && bedsMin == 0 && bedsMax == 0) {
                response = restTemplate.exchange(
                        API_URL + "?location=" + location + "&status_type=ForRent&home_type=Apartments", HttpMethod.GET, entity, ZillowRoot.class);

            }
            else{
                    response = restTemplate.exchange(
                            API_URL + "?location=" + location + "&status_type=ForRent&home_type=Apartments&rentMinPrice=" + rentMinPrice +
                                    "&rentMaxPrice=" + rentMaxPrice + "&bedsMin=" + bedsMin + "&bedsMax=" + bedsMax, HttpMethod.GET, entity, ZillowRoot.class);
                }


            if(response != null && response.getBody() != null){
                return response.getBody().getProps().toArray(new Props[0]);
            }
        }catch(RestClientResponseException e){
            System.out.println(e.getMessage());
        }catch(ResourceAccessException e){
            System.out.println(e.getMessage());
        }
        return new Props[] {};
    }

    public List<PropertyDetailsDto> getPropertyDetailsDtoList(int location, int rentMinPrice, int rentMaxPrice, int bedsMin, int bedsMax){
        Props[] propertyDetails = getRentalProperty(location, rentMinPrice, rentMaxPrice, bedsMin, bedsMax);
        List<PropertyDetailsDto> propertiesList = new ArrayList<>();
        if(propertyDetails.length > 5){
            for(int i = 0; i < 5; i++){
                PropertyDetailsDto currentPropertyDetailDto = mapToDto(propertyDetails[i]);
                propertiesList.add(currentPropertyDetailDto);
            }
        }else {

            for (Props thisProperty : propertyDetails) {
                PropertyDetailsDto currentPropertyDetailDto = mapToDto(thisProperty);
                propertiesList.add(currentPropertyDetailDto);
            }
        }
        return propertiesList;
    }


    public PropertyDetailsDto mapToDto(Props props){
        PropertyDetailsDto propertyDetailsDto = new PropertyDetailsDto();
        propertyDetailsDto.setZpid(props.getZpid());
        propertyDetailsDto.setAddress(props.getAddress());
        propertyDetailsDto.setImgSrc(props.getImgSrc());
        propertyDetailsDto.setHasImage(props.getHasImage());
        propertyDetailsDto.setBathrooms(props.getBathrooms());
        propertyDetailsDto.setBedrooms(props.getBedrooms());
//        propertyDetailsDto.setLivingArea(props.getLivingArea());
        propertyDetailsDto.setPrice(props.getPrice());
//        propertyDetailsDto.setLatitude(props.getLatitude());
//        propertyDetailsDto.setLongitude(props.getLongitude());
        return propertyDetailsDto;
    }
}
