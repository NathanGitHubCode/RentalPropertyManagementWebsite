import axios from "axios";

export default {

    getMaintenanceList() {
        return axios.get(`/maintenanceRequests`)
    },
    addMaintenanceRequest(request) {
        return axios.post('/requestMaintenance', request)
    },
    markRequestComplete(requestId) {
        return axios.put(`/completeMaintenanceRequest/${requestId}`)
    },
    getEmployees(){
        return axios.get('/getEmployees');
    },
    assignWorker(employeeId, requestId){
        return axios.put(`/assignMaintenanceWorker/employee/${employeeId}/request/${requestId}`);
    }
}