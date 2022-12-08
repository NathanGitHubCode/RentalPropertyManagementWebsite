<template>
  <div id="app">
    <div class="header">
      <router-link class="home-nav" v-bind:to="{ name: 'home' }">Home</router-link>
      <router-link class="properties-nav" v-bind:to="{ name:'property-list' }">Properties</router-link>
      <router-link class="rent-nav" v-bind:to="{ name: 'rent-list', params: { id: userID} }">Rent</router-link>
      <router-link class="maintenance-nav" v-bind:to="{ name: 'maintenance-list', params: { id: userID } }">Maintenance</router-link>
      <account-drop-down class="dropdown" v-show="!loggedIn" />
      <router-link class="login-nav" v-bind:to="{ name: 'login' }" v-show="loggedIn">Login</router-link>
     </div>
    <router-view />
  </div>
</template>

<script>
import AccountDropDown from "../src/views/AccountDropDown.vue"

export default {
  name: 'main-app',
  components: { AccountDropDown },
  
  data() {
    return {
      loggedIn: false
    }
  },
  methods:{
    displayDropDown(){
      if(this.$data.currentUser.user == ""){
        this.loggedIn = false;
    }
    else{this.loggedIn = true;}
    }

  },

  created() {
    if(this.$store.state.user !=  null) {
      this.loggedIn = true;
    }
  }
}
</script>

<style>

.dropdown {
  background-color: transparent;
  color: black;
  display: block;
  font-weight: bold;
  }

  .header :hover {
    color: white;    
  }

  .header {
        color: #000;
        cursor: pointer;
        text-decoration: none;

  }

  .header {
      grid-area: header;
      background-color: cyan;
      color: #fff;
      padding: 20px;
      display: flex;
      flex-wrap: wrap;
      justify-content:space-between;

  }

  .header > * {
    text-decoration: none;
    color: black;
    font-weight: bold;
    display: flex;
    justify-content: space-evenly;
  }

</style>