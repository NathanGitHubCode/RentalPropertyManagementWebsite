import axios from "axios";

export default {
    
    getLandlordProperties(filter){
        const location = filter.zipCode;
        const minPrice = filter.minPrice;
        const maxPrice = filter.maxPrice;
        const beds = filter.beds;
        const bath = filter.baths;
        return axios.get(`/rentals/${location}/${minPrice}/${maxPrice}/${beds}/${bath}`)
    },

    getUserProperties(){
        return axios.get('/properties');
    },
    
    addProperty(property){
        return axios.post('/addProperty', property);
    }

    
   
}