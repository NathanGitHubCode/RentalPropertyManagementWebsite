 <template>
  <form @submit.prevent="submitRequest">
    <h2 v-if="message">Thank you for submitting your request. We will get back to you shortly.  </h2>
    <br />
    <label for="description">Description:</label>
    <input type="text" id="description" v-model="request.description"/>

    <label for="contact">Contact Phone:</label>
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

form{
  margin-top: 10vh;
}
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
