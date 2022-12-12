<template>
  <div>
      <maintenance-form />
      <maintenance-list />
  </div>
</template>

<script>
import MaintenanceForm from "../components/MaintenanceForm.vue";
import MaintenanceList from "../components/MaintenanceList.vue";
export default {
components: {
    MaintenanceForm,
    MaintenanceList,
}
}
</script>

<style>

</style>