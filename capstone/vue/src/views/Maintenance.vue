<template>
  <div>
      <maintenance-form />
      <maintenance-list />
  </div>
</template>

<script>
import MaintenanceForm from "../components/Maintenance/MaintenanceForm.vue";
import MaintenanceList from "../components/Maintenance/MaintenanceList.vue";
export default {
components: {
    MaintenanceForm,
    MaintenanceList,
}
}
</script>

<style>

</style>