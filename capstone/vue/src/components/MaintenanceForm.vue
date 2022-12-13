 <template>
  <form @submit.prevent="submitRequest">
    <h2 v-if="message">Thank you for submitting form. We will get back to you shortly.  </h2>
    <br />
    <label for="description">Description:</label>
    <input type="text" id="description" v-model="request.description"/>
 
    <label for="contact">Property ID:</label>
    <input type="text" id="contact" v-model="request.propertyId" />

    <label for="contact">Contact :</label>
    <input type="text" id="contact" v-model="request.phoneNumber" />
 
    <button type="submit">Submit</button>
    
      
    </form>
</template>
 
<script>
import mainService from '../services/MainService'
export default {

  data() {
    return {
      request: {
        propertyId: '',
        description: '',
        phoneNumber: ''
      },
      message: false,
      idCounter: 0
    }
  },
  methods: {
    submitRequest(){
      mainService.addMaintenanceRequest(this.request).then(response => {

        if(response.status == 200){
           this.message = true;
           this.request = {};       
        }
      })
     
    }
  }
}
</script>

<style scoped>
label{
  display: inline-block;
  text-align: right;
}
h2{
  margin-bottom: 10px;
  text-align: center;
}

button {
  margin-top: 10px;
}
</style>
