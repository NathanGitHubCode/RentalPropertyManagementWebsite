<template>
  <div class="account-info">
    <!-- <router-link 
    class="login-button"
    v-bind:to=" { name: 'login'}"
    v-show="this.loggedIn == false" 
    >Login</router-link> -->
    <button 
    class="dropdown"
    @click="toggleDropdown">
      {{ userName }}
    </button>
    <div v-if="isDropdownVisible" class="dropdown-content">
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
      isDropdownVisible: false
    };
  },
  methods: {
    toggleDropdown() {
      this.isDropdownVisible = !this.isDropdownVisible;
    }
    
  },
  computed: {
    getUsername(){
      return this.$store.state.user
    }
  }

  
};
</script>

<style>

.account-info {
  display: flex;
  justify-content: center;
  align-content: center;
}

.login-button {
    background-color: transparent;
    color: black;
    display: flex;
    font-weight: bold;
    text-decoration: none;
    justify-content: center;
    align-content: center;
}



</style>