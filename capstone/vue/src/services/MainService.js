import axios from "axios";

export default {

    getMaintenanceList() {
        return axios.get(`/maintenanceRequests`)
    },
    addMaintenanceRequest(request) {
        return axios.post('/requestMaintenance', request)
    },
    markRequestComplete(requestId) {
        return axios.put(`/updateMaintenanceRequest/${requestId}`)
    },
    getEmployees(){
        return axios.get('/getEmployees');
    }
}