<template>
  <div>
    <h1>Maintenance Request List</h1>
     <table class="maintenance-table">
       <thead>
      <tr class="header">
        <th class="properties-header">Property</th>
        <th class="description-header">Description</th>
        <th class="date-header">Date</th>
        <th class="contact-header">Phone</th>
        <th class="status-header">Status</th>
      </tr>
      </thead>
      <tbody>
      <tr
      class="maintenance-card"
      v-for="main in this.$store.state.maintenanceList" 
      v-bind:key="main.id">
          <td class="properties">{{ main.propertyId }}</td>
          <td class="description">{{ main.description }}</td>
          <td class="date">{{ main.date }}</td>
          <td class="contact">{{ main.phoneNumber }}</td>
          <td 
          class="status"
          id="complete-button"
          type="button" 
          v-if="!isCompleted"  
          @click="markRequestComplete">Mark Complete</td>
          <div class="status-complete" v-else>
          <td class="status-text" >Completed</td>
          </div>
      </tr>
      </tbody>
    </table>
  </div>
</template>
 
<script>
import mainService from '../services/MainService.js';
export default {
  data() {
    return {
      isCompleted: false
    }
  },
  methods: {
    getMaintenanceList() {
      mainService.getMaintenanceList().then(response => {
        if(response.status === 200) {
          this.$store.commit('SET_MAINTENANCE', response.data);
        }
      });
    },
    markRequestComplete(){
      const ID = this.$route.params.ID;
      this.isCompleted = true;
      mainService.markRequestComplete(ID).then( response => {
          if(response.status === 200) {
            this.isCompleted = true
          }
      });
    }
  },
  created() {
    this.getMaintenanceList();
  }
}
</script>

<style scoped>

.maintenance-table{
  margin: 10px 10px 10px 10px;
  width: 100%;
  height: 100vh;
  background-color: white;
}


.header > *{
width: 30%;
text-align: left;
background-color: rgb(219, 219, 219);
border: 10px;
padding-left: 5px;
}

.properties{
width: 30%;
text-align: left;
background-color: white;
border: 10px;
padding-left: 5px;
}

.description{
width: 40%;
text-align: left;
background-color: white;
border: 10px;
padding-left: 5px;

}
.date{
width: 10%;
text-align: left;
background-color: white;
border: 10px;
padding-left: 5px;

}
.contact{
width: 10%;
text-align: left;
background-color: white;
border: 10px;
padding-left: 5px;

}
.status{
  background-color: white;
  width: 10%;
  padding: 10px;
  font-weight: bold;
  
}

#complete-button:hover{
    cursor: pointer;
    background-color: green;
    color: white;
}

.status-complete{
  background-color: rgb(32, 138, 50);
  font-weight: bold;
  width: 100px;
  height: 20px;
  padding: 10px;
  display: flex;
  justify-content:  center;
  justify-items: center;
  align-items: center;
} 


</style>