<template>
  <div class="main">
    <account-drop-down
      v-bind:userName="this.$store.state.user.username"
      v-bind:userType="this.$store.state.user.authorities[0].name.substring(5, this.$store.state.user.authorities[0].name.length)"
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
  props: { userName: String },
  data() {
    return {
      authorities: this.$store.state.user.authorities[0].name.substring(5, this.$store.state.user.authorities[0].name.length)
  
  };
  },
  methods: {
    logout() {
    this.$store.commit("LOGOUT");
    this.$router.push("/");
    }
  },
  
};
</script>

<style>

/* .login-button{
  display: flex;
  text-decoration: none;
  color: white;
} */

/* .login-button:hover {
  color: white;
  background-color: rgb(129, 0, 0) ;
} */


</style>