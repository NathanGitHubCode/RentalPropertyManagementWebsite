<template>
  <div class="account-info">
    <button class="dropdown" @click="toggleDropdown">
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
      isDropdownVisible: false,
    };
  },
  methods: {
    toggleDropdown() {
      this.isDropdownVisible = !this.isDropdownVisible;
    }
    
  },
  created(){
    this.$store.commit('LOGGED_IN');
  }
  
};
</script>

<style>



</style>