package com.techelevator.dao;

import com.techelevator.model.Property;
import com.techelevator.model.Rent;

import java.math.BigDecimal;
import java.util.List;

public interface RentDao {

   BigDecimal viewMyRent(int renterId);

   List<Property> viewRentalsByLandlord(int landlordId);

   public void assignRenterToProperty();
}
