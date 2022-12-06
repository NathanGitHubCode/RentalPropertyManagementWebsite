import axios from "axios";

export default {
    getRentList(userID){
        return axios.get(`/rent/${userID}`)
    },
    
    getPropertyList(){
        return axios.get('/properties')
    },
    
   
}