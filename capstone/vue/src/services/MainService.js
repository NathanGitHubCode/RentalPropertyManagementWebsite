import axios from "axios";

export default {

    getMaintenanceList(ID) {
        return axios.get(`/maintenanceRequests/${ID}`);
    }
}