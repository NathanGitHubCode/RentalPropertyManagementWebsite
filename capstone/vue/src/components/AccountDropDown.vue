<template>
  <div class="account-info">
    <button @click="toggleDropdown">
      {{ userName + "'s Account" }}
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
    },
    
  }
};
</script>