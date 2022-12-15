<template>
  <div class="property-page">
    <h3 id="header">Dreamville Properties</h3>
    <div class="landlord-view" v-if="role == 'LANDLORD'">
      <form class="filter-list" @submit.prevent="getLandlordProperties">
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

    <h2 v-if="message">Thank you for using Dreamville Properties.</h2>

    <div 
    class="property-card"
    v-for="(property, index) in this.$store.state.landlordProperties"
    v-bind:key="property.id">
      <img :src="property.imgSrc" />
      <div class="property-details">
        <h1 id="address">Address: {{ property.address }}</h1>
        <h1 id="bathrooms">Bathrooms: {{ property.bathrooms }}</h1>
        <h1 id="bedrooms">Bedrooms: {{ property.bedrooms }}</h1>
        <h1 id="price">Price: ${{ property.price }}</h1>
        <button class="purchase" @click="purchaseRentalProperty(index, property)">Purchase Property </button>
      </div>
    </div>
    </div>

    <div class="user-view" v-else>
       <div 
       class="property-card"
       v-for="(property, index) in this.$store.state.userProperties"
       v-show="property.available == true"
       v-bind:key="property.id">
      <img :src="property.imgSrc" />
      <div class="property-details">
        <h1 id="address">Address: {{ property.address }}</h1>
        <h1 id="bathrooms">Bathrooms: {{ property.bathrooms }}</h1>
        <h1 id="bedrooms">Bedrooms: {{ property.bedrooms }}</h1>
        <h1 id="price">Price: ${{ property.price / 12}}</h1>
        <button class="purchase" @click="rentProperty(property.propertyId, index)"> Rent Property </button>
      </div>

    </div>
    </div>
  </div>
</template>

<script>
import propService from '../services/PropService'
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
    },
    purchaseProp: {
        address: null,
        propertyImage: null,
        hasImage: null,
        bathrooms: null,
        bedrooms: null,
        livingArea: null,
        price: null,
    },
    renterId: null,
    message: false,
    role: this.$store.state.user.authorities[0].name.substring(5, this.$store.state.user.authorities[0].name.length)
  }
},

methods: {
  getLandlordProperties() {
    propService.getLandlordProperties(this.filter).then( response => {
       if(response.status === 200) {
        this.$store.commit('SET_LANDLORD_PROPERTIES', response.data);
       }
    });
   },

   getUserProperties() {
    propService.getUserProperties().then( response => {
       if(response.status === 200) {
        this.$store.commit('SET_USER_PROPERTIES', response.data);
       }
    });
   },

   purchaseRentalProperty(index, property){
      this.$store.commit('UPDATE_LANDLORD_PROPERTIES', index);

      this.purchaseProp = property;

      propService
      .addProperty(this.purchaseProp)
      .then(response => {
        if(response.status == 200) {
          this.purchaseProp = {};
          this.message = true;
        }
      });

   },

   rentProperty(propertyId, index){
     this.$store.commit('UPDATE_USER_PROPERTIES', index);
     const renterId = this.$store.state.user.id;
      rentService
      .assignRenter(propertyId, renterId)
      .then(response => {
        if(response.status == 200) {
          this.$router.push('/browseProperties');
        }
      });

   }
  //  ,   getRentId(){
  //    rentService
  //    .listRenters()
  //    .then( response => {
  //      if(response.status == 200) {
  //        this.$store.commit('SET_RENTERS', response.data);
  //        if (response.data.username == this.$store.state.)
  //      }
  //    })
  //  }


  },

  created() {
    this.getLandlordProperties();
    this.getUserProperties();
      if(
      this.filter.minPrice === null,
      this.filter.maxPrice === null,
      this.filter.beds === null,
      this.filter.baths === null
      )
      {
      this.filter.minPrice = 0;
      this.filter.maxPrice = 0,
      this.filter.beds = 0,
      this.filter.baths = 0
      }
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
  background: chocolate;  
  padding: 10px;
  width: 99%;
  height: 5vh;

}

.filter-list > * {
  justify-content: flex-start;
  width: 100vw;
  display: flex;
  margin: 10px;
  align-items: center;
  
}



</style>