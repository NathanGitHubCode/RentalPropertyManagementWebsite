<template>
  <div class="rent-form">
      <form @submit.prevent="">
          <div class="payment-amount">
              <input for="amount" v-model.number="payment.amount" placeholder="Amount"/>
          </div>
          <div class="payment-date">
              <input type="date" for="date" v-model="payment.date" placeholder="Date"/>
          </div>
          <div>
              <button>Submit</button>
          </div>
      </form>
  </div>
</template>

<script>
export default {
    data() {
        return {
            payment: {
                amount: '',
                date: ''
            }
        }
    },



}
</script>

<style scoped>

/* .rent-form {
   display: none;
} */

.rent-form > *{
    justify-content: center;
}

</style>