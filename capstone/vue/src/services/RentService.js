import axios from "axios";

export default {

    viewRent() {
        return axios.get('/viewRent');
    },
    assignRenter(propertyId) {
        return axios.put(`/properties/${propertyId}`)
    }



}