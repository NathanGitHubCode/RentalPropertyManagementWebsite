<template>
  <div id="app">
    <div class="header">
      <h1 class="home-button">Home</h1>
      <h1 class="show-properties">Properties</h1>
      <h1 class="show-rent">Rent</h1>
      <h1 class="show-maintenance">Maintenance</h1>
      <account-drop-down class="dropdown" v-show="loggedIn"/>
      <router-link class="login-button" v-bind:to="{ name: 'login' }" v-show="!loggedIn">Login</router-link>
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
      loggedIn: true
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

  .login-button {
    text-decoration: none;
    color: black;
  }

  .header h1 :hover {
    color: white;    
  }

  .header h1{
        margin: 0px 15px 0px 15px;
        color: #000;
        cursor: pointer;
  }

  .header {
      grid-area: header;
      background-color: cyan;
      color: #fff;
      padding: 20px;
      display: flex;
      flex-wrap: wrap;

  }

</style>