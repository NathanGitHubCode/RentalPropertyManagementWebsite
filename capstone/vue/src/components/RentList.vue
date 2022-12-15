<template>
  <div class="view-rent">
    <div class="rent-list" 
    v-for="property in this.$store.state.userProperties" 
    v-bind:key="property.id">
      <img :src="property.imgSrc" />
      <h1>{{ property.renterId }}</h1>
      <h1>{{ property.landlordId }}</h1>
      <h1>{{ property.balance }}</h1>
      <h1>{{ property.dueDate }}</h1>
    </div>
    <pay-rent-form />
  </div>
</template>

<script>
import PayRentForm from '../components/PayRentForm.vue';
import rentService from '../services/RentService';

export default {
  components: { PayRentForm },
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
      ]

    }
  },

  methods: {
    listRents() {
      rentService.viewRent().then( response => {
        if(response.status == 200) {
          this.$store.commit('SET_RENTED_PROPS', response.data);
        }
        
      });
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

</style>