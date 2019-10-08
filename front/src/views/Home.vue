<template>
  <v-row align="center" justify="center">
    <v-col cols="12" md="5">
      <h1>SUT Ticket Major - จองตั๋วการแสดง</h1>
      <p>โปรดเข้าสู่ระบบ เพื่อทำการจองตั๋วการแสดง</p>
      {{ customer.name }}
    </v-col>
  </v-row>
</template>

<script>
import Home from "../components/Home";
export default {
  components: {
    Home
  },
  props:{
    customer:{}
  },
  data() {
    return {
      
    };
  }
};
</script>
