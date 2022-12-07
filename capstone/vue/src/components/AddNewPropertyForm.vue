<template>
  <div>
    <form>
      <label>Address:</label>
      <input v-model="formData.address" type="text" />
 
      <label>Rent:</label>
      <input v-model="formData.rent" type="number" />
 
      <label>Bedrooms:</label>
      <input v-model="formData.bedrooms" type="number" />
 
      <label>Bathrooms:</label>
      <input v-model="formData.bathrooms" type="number" />
 
      <label>Amenities:</label>
      <div v-for="amenity in amenities" v-bind:key="amenity">
        <input
          v-model="formData.amenities"
          type="checkbox" 
        />
        {{ amenity }}
      </div>
 
      <button @click="addRentalProperty">Add Property</button>
    </form>
  </div>
</template>

<script>
export default {
    data() {
    return {
      // Initialize the form data
      formData: {
        address: '',
        rent: 0,
        bedrooms: 0,
        bathrooms: 0,
        amenities: []
      },
        amenities: ['Pool', 'Gym', 'Parking', 'Elevator']
    }
    },
    methods: {
         addRentalProperty() {
      // TODO: Add the rental property to the database
    }
    }

}
</script>

<style>

</style>