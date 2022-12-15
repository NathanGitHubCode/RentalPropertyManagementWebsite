import axios from "axios";

export default {

    viewRent() {
        return axios.get('/viewMyRent');
    },
    assignRenter(propertyId, renterId) {
        return axios.put(`/updateProperty/assignRenter/${propertyId}/${renterId}`);
    },
    listRenters(){
        return axios.get('/getRenters');
    }



}