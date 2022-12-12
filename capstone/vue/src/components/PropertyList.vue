<template>
  <div>
      
  </div>
</template>

<script>
import rentService from '../services/RentService'
export default {
  methods: {
  getProperties() {
    rentService.getPropertyList().then( response => {
      if(response.status === 200) {
        this.$store.commit('SET_PROPERTIES', response.data);
      }
    })
   }
  }
}
</script>

<style>

</style>