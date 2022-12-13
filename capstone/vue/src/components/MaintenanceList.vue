<template>
  <div>
    <h1>Maintenance Request List</h1>
    <table>
      <tr>
        <th>Username</th>
        <th>Description</th>
        <th>Contact Phone</th>
      </tr>
      <tr v-for="main in this.$store.state.maintenanceList" v-bind:key="main.id">
        <td>{{ main.username }}</td>
        <td>{{ main.description }}</td>
        <td>{{ main.contactPhone }}</td>
      </tr>
    </table>
  </div>
</template>
 
<script>
import mainService from '../services/MainService.js';
export default {
  data() {
    return {
    }
  },
  methods: {
    getMaintenanceList() {
      mainService.getMaintenanceList().then(response => {
        if(response.status === 200) {
          this.$store.commit('SET_MAINTENANCE', response.data);
        }
      });
    }
  },
  created() {
    this.getMaintenanceList();
  }
}
</script>

<style>

</style>