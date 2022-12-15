<template>
  <div>
    <form @submit.prevent="addRentalProperty">

      <h2 v-if="message">Thank you for using Dreamville Properties.</h2>

    <div class="input-element">
      <label>Image:</label>
      <input type="text" v-model="formData.image" />
    </div>  

      <img :src="formData.image" />
      
      <label>Address:</label>
      <input v-model="formData.address" type="text" />
 
      <label>Listing Price:</label>
      <input v-model="formData.rent" type="number" />
 
      <label>Bedrooms:</label>
      <input v-model="formData.bedrooms" type="number" />
 
      <label>Bathrooms:</label>
      <input v-model="formData.bathrooms" type="number" />

      <label>Area: </label>
      <input v-model="formData.area" type="number" />
 
      <button type="submit" >Add Property</button>
    </form>
  </div>
</template>

<script>
import propService from '../services/PropService'
export default {
    data() {
    return {
      // Initialize the form data
      formData: {
        image: '',
        address: '',
        balance: 0,
        bedrooms: 0,
        bathrooms: 0,
        area: 0,
        landlordId: this.$store.state.user.id
      }
    }
    },
    methods: {
         addRentalProperty() {
      // TODO: Add the rental property to the database
        propService
        .addProperty(this.formData)
        .then( response => {
          if(response.status == 200){
            this.$store.commit('ADD_USER_PROP', response.data)
            this.formData = {};
            this.$router.push('/browseProperties')
          }
        });

      }
    }

}
</script>






<style>
form {
  width: 500px;
  margin: 0 auto;
  padding: 5vh 25vw 40vh 25vw;

  border-radius: 5px;
}
label {
  display: block;
  margin-bottom: 0.5em;
  font-weight: bold;
  color: #333;
}
input {
  width: 100%;
  padding: 0.5em;
  border: 1px solid #ccc;
  border-radius: 3px;
}
button {
  background-color: #4CAF50;
  color: white;
  padding: 0.5em;
  border: none;
  border-radius: 3px;
  cursor: pointer;
  transition: 0.3s;
  display: flex;
  margin: auto;
  }
button:hover {
  background-color: #3e8e41;
}

#amenities {
    display:inline-block;
    margin: 1rem;  
}



</style>