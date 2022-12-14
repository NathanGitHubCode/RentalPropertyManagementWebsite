<template>
  <div class="account-info">
  <div class="nav-element">
    <router-link
    class="login-button"
    :to="{ name: 'login' }"
    v-if="this.$store.state.loggedIn == false"
    >Login</router-link>

    <div class="dropdown-all"
    v-else>
    <h1 
    class="dropdown"
    @click="toggleDropdown"
    >
      {{ userName }} 
    </h1>

    <div 
    class="dropdown-content" 
    id="account-drop"
    @mouseleave="toggleDropdown">
      <p>Username: {{ userName }}</p>
      <p>Account Type: {{ userType }}</p>
      <button @click="logout">Logout</button>
    </div>
    </div>
  </div>
  </div>
</template>
 
<script>
export default {
name: 'AccountDropDown',
props: {
    userName: String,
    userType: String,
    logout: Function
  }, 
  data() {
    return {
    }
  },
  methods: {
    toggleDropdown() {
      document.getElementById("account-drop").classList.toggle("show");
    }
  }

  
};
</script>


<style scoped>

.nav-element{
  display: flex;
  justify-content: center;
}

.login-button{
  background: rgba(104, 0, 0);
  color: white;
  font-size: 1rem;
  font-weight: bold;
  display: flex;
  justify-content: center;
  align-content: center;
  }

.account-info{
  display: flex;
}


.dropdown-content {
  display: none;
  position:absolute;
  background-color: #f1f1f1;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
  margin-block: 23px;
}

.dropdown-content > * {
  color: black;
  padding: 12px 16px;
  text-decoration: none;
}


.dropdown-all {
  position: relative;
  display: block;
  align-items: center;  
}

 .dropdown-all > * {
    color: white;
  }

  .show {
  display:flex;
  flex-wrap: wrap;
  justify-self: flex-start;
  align-self: flex-start; 
  justify-content: flex-start;
  justify-items: flex-start;
  }


  .dropdown{
    background-color: black;
    color:white;
    margin: -10px;
    border-radius: 50%;
    width: 35px;
    height: 35px; 
    text-align: center;
    cursor: pointer;
    
  }

  .dropdown:hover {
    background-color: rgb(65, 65, 65);
  }

</style>