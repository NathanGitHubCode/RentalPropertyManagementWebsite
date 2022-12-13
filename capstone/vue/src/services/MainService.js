import axios from "axios";

export default {

    getMaintenanceList() {
        return axios.get(`/maintenanceRequests`)
    },
    addMaintenanceRequest(request) {
        return axios.post('/submitMaintenanceRequest', request)
    },
    markRequestComplete(ID) {
        return axios.put(`/updateMaintenanceRequest/${ID}`)
    }
}