<template>
  <div class="rent-form">
      <form @submit.prevent="">
          <div class="payment-amount">
              <label id="amount">Amount: </label>
              <input for="amount" v-model.number="payment.amount" />
          </div>
          <div class="payment-date">
              <label id="date">Date: </label>
              <input type="date" for="date" v-model="payment.date" />
          </div>
          <div>
              <button>Submit</button>
          </div>
      </form>
  </div>
</template>

<script>
export default {
    data: function() {
        return {
            payment: {
                amount: '',
                date: ''
            }
        }
    },



}
</script>

<style>

</style>