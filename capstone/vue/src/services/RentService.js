import axios from "axios";

export default {
    getRentList(userID){
        return axios.get(`/rent/${userID}`)
    },
    
    getPropertyList(filter){
        const location = filter.zipCode;
        const minPrice = filter.minPrice;
        const maxPrice = filter.maxPrice;
        const beds = filter.beds;
        const bath = filter.baths;
        return axios.get(`/rentals/${location}/${minPrice}/${maxPrice}/${beds}/${bath}`)
    }
    
   
}