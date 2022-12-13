<template>
  <div class="account-info">
  <div class="nav-element">
    <router-link
    class="login-button"
    :to="{ name: 'login' }"
    v-if="this.$store.state.loggedIn == false"
    >Login</router-link>
    <button 
    class="dropdown"
    @click="toggleDropdown"
    v-else>
      {{ userName }}
    </button>
  </div>
    <div v-show="this.$store.state.isDropdownVisible" class="account-details">
      <p>Username: {{ userName }}</p>
      <p>Account Type: {{ userType }}</p>
      <button @click="logout">Logout</button>
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
      this.$store.state.isDropdownVisible = !this.$store.state.isDropdownVisible;
    }
  }

  
};
</script>

<style>

/* .login-button{
  justify-content: center;
  align-content: center;
} */

.nav-element{
  display: flex;
  justify-content: center;
}

.nav-element > *{
  background: rgba(104, 0, 0);
  color: white;
  margin: -10px;
  font-size: 1rem;
  font-weight: bold;
  display: flex;
  justify-content: center;
  align-content: center;
  }

.account-info{
  display: block;
}

.nav-element :hover, .nav-element :focus{
  color: white;
  background-color: rgb(129, 0, 0);
  border: 200px;
  }


.account-details {
  justify-content: center;
  align-content: center;
  display: flex;
}

</style>