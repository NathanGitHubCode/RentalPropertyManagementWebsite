<template>
  <div>
    <h1>Assign Maintenance</h1>
    <form @submit.prevent="assignMaintenance">

      <label>
        Maintenance Request:
        <select v-model="maintenanceRequest">
          <option v-for="request in maintenanceRequests" v-bind:key="request">{{ request.request }}</option>
        </select>
      </label>
      <br />
      <label>
        Assign To:
        <select v-model="maintenancePersonId">
          <option v-for="person in maintenancePeople" v-bind:key="person">{{ person.name }}</option>
        </select>
      </label>
      <br />
      <button type="submit">Assign</button>
    </form>
  </div>
</template>
 
<script>
export default {
  data() {
    return {
      maintenanceRequest: null,
      maintenancePersonId: null,
      maintenanceRequests: [],
      maintenancePeople: []
    };
  },
  methods: {
    assignMaintenance() {
      // Assign the selected maintenance task to the selected property
      // and maintenance person, using the provided propertyId,
      // maintenanceType, and maintenancePersonId values.
    }
  }
};
</script>
 
<style-scoped>
  
  form {
    display: flex;
    flex-direction: column;
    align-items: center;
    padding: 20px;
    background-color: #f2f2f2;
    border-radius: 10px;
  }
 
  label {
    display: flex;
    flex-direction: column;
    align-items: flex-start;
    margin-bottom: 10px;
  }
 
  label > span {
    font-weight: bold;
  }
 
  select {
    width: 200px;
    height: 30px;
    padding: 5px;
    border: 1px solid #ccc;
    border-radius: 5px;
  }
 
  button {
    width: 100px;
    height: 30px;
    background-color: blue;
    color: white;
    border: none;
    border-radius: 5px;
    margin-top: 20px;
    cursor: pointer;
  }
 
  button:hover {
    background-color: #0070c9;
  }
 
  button:active {
    transform: scale(0.95);
  }
</style>
 
