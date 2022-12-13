<template>
  <div>
    <h3 id="header">Dreamville Properties</h3>
      <form class="filter-list" @submit.prevent="getProperties">
        <label>Zip Code:</label>
        <input type="text" placeholder="Zipcode" v-model.number="filter.zipCode"/>
        <label>Min Price:</label>
        <input type="" placeholder="Min. Price" v-model.number="filter.minPrice"/>
        <label>Max Price:</label>
        <input type="number" placeholder="Max. Price" v-model.number="filter.maxPrice"/>
        <label>Beds:</label>
        <input type="number" placeholder="# of Beds" v-model.number="filter.beds"/>
        <label>Baths:</label>
        <input type="number" placeholder="# of Baths" v-model.number="filter.baths"/>
        <button type="submit"> Enter </button>

      </form>
    <div 
    class="property-card"
    v-for="property in this.$store.state.rentalProperties"
    v-bind:key="property.id">
      <img :src="property.imgSrc" />
      <div class="property-details">
        <h1 id="address">Address: {{ property.address }}</h1>
        <h1 id="bathrooms">Bathrooms: {{ property.bathrooms }}</h1>
        <h1 id="bedrooms">Bedrooms: {{ property.bedrooms }}</h1>
        <h1 id="price">Price: ${{ property.price }}</h1>
      </div>
    </div>
  </div>
</template>

<script>
import rentService from '../services/RentService'
export default {

data() {
  return{
    filter: {
      zipCode: null,
      minPrice: null,
      maxPrice: null,
      beds: null, 
      baths: null
    }
  }
},

methods: {
  getProperties() {
    rentService.getPropertyList(this.filter).then( response => {
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

#header {
  font-size: 35px;
}

.filter-list {
  display: inline-flex;
  flex-wrap: nowrap;
  background: blueviolet;  
  padding: 50px;
  width: 95vw;
  height: 10vh;

}

.filter-list > * {
  justify-content: flex-start;
  width: 100vw;
  display: flex;
  margin: 10px;
  align-items: center;
  
}



</style>