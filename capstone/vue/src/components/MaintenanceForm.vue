 <template>
  <form>
    <!-- <label for="username">Username:</label>
    <input type="text" id="username" value="username" placeholder="Username" v-model="request.username" /> -->
   
    <!-- <label>Category:</label>
    <div>
    <input type="radio" id="plumbing" value="plumbing" v-model="request.category" />
    <label for="plumbing">Plumbing</label>
    </div>
    <input type="radio" id="electrical" value="electrical" v-model="request.category" />
    <label for="electrical">Electrical</label>
    <input type="radio" id="hvac" value="hvac" v-model="request.category" />
    <label for="hvac">HVAC</label>
    <input type="radio" id="structural" value="structural" v-model="request.category" />
    <label for="structural">Structural</label>
    <input type="radio" id="other" value="other" v-model="request.category" />
    <label for="other">Other (please specify):</label>
    <input type="text" id="other-category" v-model="request.otherCategory" /> -->
 
    <label for="description">Description:</label>
    <input type="text" id="description" v-model="request.description"/>
 
    <label for="contact">Contact Phone:</label>
    <input type="text" id="contact" v-model="request.contact" />
 
    <button type="submit">Submit</button>
      
    </form>
</template>
 
<script>
export default {
  data() {
    return {
      request: {
        username: '',
        category: '',
        otherCategory: '',
        description: '',
        contact: '',
      },
      idCounter: 0
    }
  },
  methods: {
   
  }
}
</script>

<style scoped>
label{
  display: inline-block;
  text-align: right;
}
div{
  margin-bottom: 10px;;
}

button {
  margin-top: 10px;
}
</style>
