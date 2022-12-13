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
    <button 
    class="dropdown"
    @mouseenter="toggleDropdown"
    @mouseleave="toggleDropdown"
    >
      {{ userName }} 
    </button>

    <div 
    class="dropdown-content" 
    id="account-drop"
    @mouseenter="toggleDropdown"
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

<style>

.login-button{
    justify-content: center;
}

.nav-element{
  display: flex;
  justify-content: center;
}

.nav-element > *{
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

.nav-element :hover, .nav-element :focus{
  color: white;
  background-color: rgb(129, 0, 0);
  border: 200px;
  }
  


.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f1f1f1;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  /* z-index: 1; */
}

/* Links inside the dropdown */
.dropdown-content > * {
  color: black;
  padding: 12px 16px;
  text-decoration: none;
}

/* Change color of dropdown links on hover */
.dropdown-content > *:hover {
  background-color: #ddd;
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
  display:block;
  }

  .dropdown{
    color:white;
    background-color: rgba(104, 0, 0);
    margin: -10px;
  }

</style>