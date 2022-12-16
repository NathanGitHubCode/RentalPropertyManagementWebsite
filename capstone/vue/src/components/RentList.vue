<template>
  <div class="view-rent">
    <div class="rent-list" 
    v-for="property in this.$store.state.rentedProperties" 
    v-bind:key="property.id"
    >
    <div class="rent-card" >
      <img :src="property.imgSrc" />
      <div class="rent-details" v-if="property.status != 2">
      <h1>Amount Due: {{ property.balance }}</h1>
      <h1>Due Date: {{ property.dueDate }}</h1>
      </div>
      <h1 v-if="property.status == 1">Status: Due</h1>
      <h1 v-else-if="property.status == 2">Status: Paid</h1>
      <h1 v-else>Status: Overdue</h1>
      <button 
      @click="payRent(property.propertyId)"
      v-if="property.status != 2">Pay Rent</button>
      <!-- <div class="rent-form" v-show="showForm">
        <pay-rent-form/>
      </div> -->
    </div>
    </div>
  </div>
</template>

<script>
// import PayRentForm from '../components/PayRentForm.vue';
// import propService from '../services/PropService';
import rentService from '../services/RentService';

export default {
  // components: { PayRentForm },
  data() {
    return {
      properties: [
        {
          id: null,
          renter: null,
          landlord: null,
          amount: null, 
          date: null
        }
      ],
      showForm: false

    }
  },

  methods: {
    listRents() {
      this.$store.commit('SET_RENTED_PROPS');
      // propService.getUserProperties().then( response => {
      //   if(response.status == 200) {
      //     this.$store.commit('SET_RENTED_PROPS', response.data);
      //   }
        
      // });
    },
    payRent(propertyId){
      rentService.payRent(propertyId).then( response => {
        if(response.status == 200){
          this.$router.push('/viewMyRent');
          this.$store.commit('SET_PAID_STATUS', propertyId);
        }
      })
    }

  },
  created() {
    this.listRents();
  }

}
</script>

<style scoped>

.rent-list{
  background: white;
  display: flex;
  margin: 10px 10px 10px 10px;
}

img {
  width: 10vw;
  height: 15vh;
  margin: 8px;
}

/* .rent-form {
  display:none;
} */

.rent-card {
  display: flex;
  flex-wrap: wrap;
}

h1{
  margin: 10px;
}

</style>