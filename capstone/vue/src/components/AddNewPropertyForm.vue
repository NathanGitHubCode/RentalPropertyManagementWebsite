<template id="prop-page">
  <div class="add-prop-page">
    <form @submit.prevent="addRentalProperty">

      <h2 v-if="landlordMessage">Thank you for using Dreamville Properties.</h2>
      <h2 v-if="userMessage">You must be a landlord to add a property</h2>

    <div class="input-element">
      <label>Image:</label>
      <input type="text" v-model="formData.imgSrc" />
    </div>  

      <img :src="formData.imgSrc" />
      
      <label>Address:</label>
      <input v-model="formData.address" type="text" />
 
      <label>Listing Price:</label>
      <input v-model="formData.price" type="number" />
 
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
        imgSrc: '',
        address: '',
        price: 0,
        bedrooms: 0,
        bathrooms: 0,
        area: 0,
        landlordId: this.$store.state.user.id
      },
      landlordMessage: false,
      userMessage: false
    }
    },
    methods: {
         addRentalProperty() {
      // TODO: Add the rental property to the database
      if(this.$store.state.user.authorities[0].name.substring(5, this.$store.state.user.authorities[0].name.length) == 'LANDLORD'){
        propService
        .addProperty(this.formData)
        .then( response => {
          if(response.status == 200){
            this.$store.commit('ADD_USER_PROP', response.data)
            this.formData = {};
            this.landlordMessage = true
            this.$router.push('/browseProperties')
          }
        });

      }
      else{
          this.userMessage = true
      }
    }
  }
}
</script>






<style >

.add-prop-page{
  /* background-color: #a8a8a7; */
  margin: 20px;
    
}

form {
  width: 500px;
  margin: auto;
  padding: 10vh 15vw 40vh 15vw;
  background-color: rgb(8, 134, 61);
  /* width: 20%; */
  
  border-radius: 50px;
}
label {
  display: block;
  margin-bottom: 0.5em;
  font-weight: bold;
  color:white;

}
input {
  width: 100%;
  padding: 0.5em;
  border: 1px solid #ccc;
  border-radius: 3px;
  background-color: rgb(205, 247, 255);
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
  margin-top: 10px;
  }
button:hover {
  background-color: #ec9d36;
}

#amenities {
    display:inline-block;
    margin: 1rem;  
}



</style>