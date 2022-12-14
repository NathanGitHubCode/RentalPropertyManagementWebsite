<template>
  <div class="view-rent">
    <div class="rent-list" v-for="property in properties" v-bind:key="property">
      {{ property.id }}
      {{ property.renter }}
      {{ property.landlord }}
      {{ property.amount }}
      {{ property.date }}
    </div>
    <pay-rent-form />
  </div>
</template>

<script>
import rentService from '../services/PropService';
import PayRentForm from '../components/PayRentForm.vue';

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
      rentService.getRentList(this.properties.renter).then( response => {
        if(response.status == 200) {
          this.properties = this.response.data;
          this.$store.commit('SET_RENTED_PROPS', this.properties);
        }
        
      });
    }

  },
  created() {
    this.listRents();
  }

}
</script>

<style>

</style>