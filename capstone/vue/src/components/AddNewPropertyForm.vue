<template>
  <div>
    <form>
      <label>Address:</label>
      <input v-model="formData.address" type="text" />
 
      <label>Rent:</label>
      <input v-model="formData.rent" type="price" />
 
      <label>Bedrooms:</label>
      <input v-model="formData.bedrooms" type="number" />
 
      <label>Bathrooms:</label>
      <input v-model="formData.bathrooms" type="number" />
 
      <label>Amenities:</label>
      <div  id="amenities" v-for="amenity in amenities" <template>
  <div>
    <h1>Maintenance Request List</h1>
    <table>
      <tr>
        <th>Username</th>
        <th>Category</th>
        <th>Description</th>
        <th>Contact Phone</th>
      </tr>
      <tr v-for="request in requests">
        <td>{{ request.username }}</td>
        <td>{{ request.category }}</td>
        <td>{{ request.description }}</td>
        <td>{{ request.contactPhone }}</td>
      </tr>
    </table>
  </div>
</template>
 
<script>
export default {
  data() {
    return {
      requests: [
        {
          username: '',
          category: '',
          description: '',
          contactPhone: '',
          status: ''
        }
      ]
    }
  }
}
</script>amenity">
        <label > {{ amenity }} </label>
        <input 
          v-model="formData.amenities[amenity]"
          type="checkbox" 
        />
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