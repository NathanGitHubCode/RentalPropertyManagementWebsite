<template>
  <div>
    ...
    <account-drop-down
      v-bind:userName="currentUser.name"
      v-bind:userType="currentUser.type"
      v-bind:logout="logout"
    />
  </div>
</template>
 
<script>
import AccountDropDown from '../components/AccountDropDown.vue';
 
export default {
  components: {
    AccountDropDown
  },
  data() {
    return {
      currentUser: {
        name: 'John Doe',
        type: 'Renter'
      }
    };
  },
  methods: {
    logout() {
    this.$store.commit("LOGOUT");
    this.$router.push("/login");    }
  }
};
</script>