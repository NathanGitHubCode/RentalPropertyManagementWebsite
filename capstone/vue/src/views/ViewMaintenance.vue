<template>
  <div>
      <maintenance-form />
      <maintenance-list />
      <maintenance-detail />
  </div>
</template>

<script>
import MaintenanceForm from "../components/MaintenanceForm.vue";
import MaintenanceList from "../components/MaintenanceList.vue";
import MaintenanceDetail from "../components/MaintenanceDetail.vue";
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