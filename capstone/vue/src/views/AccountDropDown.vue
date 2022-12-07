<template>
  <div>
    <account-drop-down
      v-bind:userName="currentUser.username"
      v-bind:userType="currentUser.role"
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
        username: this.$store.state.user.username,
        role: this.$store.state.user.authorities[0].name.substring(5, this.$store.state.user.authorities[0].name.length)
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