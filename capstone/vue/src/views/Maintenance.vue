<template>
  <div>
      <maintenance-form />
      <maintenance-list />
      <maintenance-detail />
  </div>
</template>

<script>
import MaintenanceForm from "../components/Maintenance/MaintenanceForm.vue";
import MaintenanceList from "../components/Maintenance/MaintenanceList.vue";
import MaintenanceDetail from "../components/Maintenance/MaintenanceDetail.vue";
export default {
components: {
    MaintenanceForm,
    MaintenanceList,
    MaintenanceDetail
}
}
</script>

<style>

</style>