package com.techelevator.model.properties;

import java.util.List;

public class RentalProperties {

    private List<PropertyDetails> listOfDetails = null;

    public List<PropertyDetails> getListOfDetails() {
        return listOfDetails;
    }

    public void setListOfDetails(List<PropertyDetails> listOfDetails) {
        this.listOfDetails = listOfDetails;
    }
}
