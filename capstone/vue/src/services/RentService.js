import axios from "axios";

export default {

    viewRent() {
        return axios.get('/viewRent');
    },
    assignRenter(propertyId, renterId) {
        return axios.put(`/updateProperty/assignRenter/${propertyId}/${renterId}`);
    },
    listRenters(){
        return axios.get('/getRenters');
    }



}