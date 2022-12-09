<template>
  <div>
    <h1>Maintenance Request List</h1>
    <table>
      <tr>
        <th>Username</th>
        <th>Category</th>
        <th>Description</th>
        <th>Contact Phone</th>
      </tr>
      <tr v-for="request in requests" v-bind:key="request">
        <td>{{ request.username }}</td>
        <td>{{ request.category }}</td>
        <td>{{ request.description }}</td>
        <td>{{ request.contactPhone }}</td>
      </tr>
    </table>
  </div>
</template>
 
<script>
export default {
  data() {
    return {
      requests: [
        {
          username: '',
          category: '',
          description: '',
          contactPhone: '',
          status: ''
        }
      ]
    }
  }
}
</script>

<style>

</style>