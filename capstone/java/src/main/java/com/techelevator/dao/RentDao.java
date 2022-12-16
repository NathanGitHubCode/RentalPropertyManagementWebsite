package com.techelevator.dao;

import com.techelevator.model.Property;
import com.techelevator.model.PropertyLandlordRent;
import com.techelevator.model.Rent;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;

public interface RentDao {

   int viewMyRent(int renterId);

   List<PropertyLandlordRent> viewRentalsByLandlord(int landlordId);

   void assignRenterToProperty(int propertyId, int renterId, Principal principal);

   void updateLandlordRentDetails(Property property, Principal principal);

//   void updateRentStatus(int propertyId, Principal principal);

//   void updateOverdueStatus(int propertyId, Principal principal);

   }
