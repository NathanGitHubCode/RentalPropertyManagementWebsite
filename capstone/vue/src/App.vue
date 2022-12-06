<template>
  <div id="app">
    <div id="nav">
      <router-link v-bind:to="{ name: 'login' }">Login</router-link>
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
      <router-link v-bind:to="{ name: 'addNewProperty' }">New Property Form</router-link>
    </div>
    <router-view />
  </div>
</template>

<script>
export default {

}
</script>

<style>

</style>