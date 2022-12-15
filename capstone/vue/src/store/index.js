import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'
// import { use } from 'chai'

Vue.use(Vuex)

/*
 * The authorization header is set for axios when you login but what happens when you come back or
 * the page is refreshed. When that happens you need to check for the token in local storage and if it
 * exists you should set the header so that it will be attached to each request
 */
const currentToken = localStorage.getItem('token')
const currentUser = JSON.parse(localStorage.getItem('user'));
if(currentToken != null) {
  axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
}

export default new Vuex.Store({
  state: {
    token: currentToken || '',
    user: currentUser || {},
    loggedIn: false,
    landlordProperties: [],
    userProperties: [],
    rentedProperties: [],
    maintenanceList: [],
    employeeList: [],
    renterList: []
    
  },
  mutations: {
    SET_AUTH_TOKEN(state, token) {
      state.token = token;
      localStorage.setItem('token', token);
      axios.defaults.headers.common['Authorization'] = `Bearer ${token}`
    },
    SET_USER(state, user) {
      state.user = user;
      localStorage.setItem('user',JSON.stringify(user));
    },
    LOGOUT(state) {
      localStorage.removeItem('token');
      localStorage.removeItem('user');
      state.token = '';
      state.user = {};
      axios.defaults.headers.common = {};
      state.loggedIn = false;
    },
    LOGGED_IN(state) {
        state.loggedIn = true;
    },
    SET_LANDLORD_PROPERTIES(state, properties) {
     state.landlordProperties = properties;

     state.landlordProperties.filter( landlordProp => {
       let prop = state.landlordProperties.indexOf(landlordProp);
       state.userProperties.filter( userProp => {
         if(landlordProp.address == userProp.address){
            state.landlordProperties.splice(prop, 1);
         }
       });
     });
    },
    SET_MAINTENANCE(state, maintenance) {
      state.maintenanceList = maintenance;
    },
    UPDATE_LANDLORD_PROPERTIES(state, index) {
      // const availProps = state.rentalProperties.filter( property => {
      //  if(property.zpid == ID){
      //   return property;
      //  }
       
      // });

      // const propIndex = state.rentalProperties.indexOf(availProps);
      
      // if(propIndex > -1) {
        state.landlordProperties.splice(index, 1);
        // state.purchasedProperties.push(availProps);
      // }

    },
    SET_USER_PROPERTIES(state, properties) {
      state.userProperties = properties;
    },
    UPDATE_USER_PROPERTIES(state, index){
      state.userProperties.splice(index, 1);
    },
    SET_EMPLOYEES(state, employees) {
      state.employeeList = employees;
    },
    SET_RENTERS(state, renters) {
      state.renterList = renters;
    },
    ADD_USER_PROP(state, property){
      state.userProperties.push(property);
    },
    SET_RENTED_PROPS(state, properties){
      properties.filter( prop => {
          if(prop.renterId == state.user.id){
            state.rentedProperties.push(prop)
          }
      }); 
    }
  }
})
