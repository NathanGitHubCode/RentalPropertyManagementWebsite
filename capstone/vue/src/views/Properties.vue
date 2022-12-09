<template>
  <div>
      <property-detail />
      <property-list />
  </div>
</template>

<script>
import PropertyDetail from "../components/PropertyDetail.vue";
import PropertyList from "../components/PropertyList.vue";
export default {
components: {
    PropertyDetail,
    PropertyList
}
}
</script>

<style>

</style>