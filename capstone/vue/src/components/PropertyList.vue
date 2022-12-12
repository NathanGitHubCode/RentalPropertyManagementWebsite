<template>
  <div>
    <h1>Rental Props</h1>
    <div 
    class="property-card"
    v-for="property in this.$store.state.rentalProperties"
    v-bind:key="property.id">
      <img src="https://images.unsplash.com/photo-1560518883-ce09059eeffa?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8cHJvcGVydHl8ZW58MHx8MHx8&w=1000&q=80" />
      <div class="property-details">
        <h1 id="address">Address: {{ property.address }}</h1>
        <h1 id="bathrooms">Bathrooms: {{ property.bathrooms }}</h1>
        <h1 id="bedrooms">Bedrooms: {{ property.bedrooms }}</h1>
        <h1 id="area">{{property.livingArea }} sqft</h1>
        <h1 id="price">Price: ${{ property.price }}</h1>
      </div>
    </div>
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
  },

  created() {
    this.getProperties();
  }
}
</script>

<style scoped>

.property-card{
  background: white;
  display: flex;
  margin: 10px 10px 10px 10px;
}

img {
  width: 10vw;
  height: 15vh;
  margin: 8px;
}

.property-details {
    margin-top: 10px;
}


</style>