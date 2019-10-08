<template>
  <v-row align="center" justify="center">
    <v-col cols="12" md="5">
      <h1>Home.vue</h1>
      <p> ยินดีต้อนรับ...{{ customer.name }} </p>
      <!-- <v-btn router-link to="/ticketbooking">จองตั๋วการแสดง</v-btn> -->
    </v-col>
  </v-row>
</template>

<script>
import api from '../http-common.js';
export default { 
  mounted(){
    this.din();
  },
  data() {
    return {
      customer_id : null,
      customer:{}
    };
  },methods:{
    din(){
      this.customer_id = this.$route.params.customer_id;
      console.log("Home -> "+ this.customer_id)
      api.get("/customer/"+this.customer_id)
      .then(res=>{
        this.customer = res.data;
      })
      .catch(e=>{
        console.log(e);
      })
    }
  }
};
</script>
