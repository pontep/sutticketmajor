<template>
  <v-app>
    <v-app-bar app>
      <v-toolbar-title class="headline text-uppercase">
        <span>sut ticket major</span>
        <span class="font-weight-light">- ระบบจองตั๋วการแสดง</span>
      </v-toolbar-title>
      <v-spacer></v-spacer>
      <template v-if="!customer.name">
        <v-btn @click="goToLoginOrRegister">
          <span class="mr-2">เข้าสู่ระบบ/สมัครสมาชิก</span>
        </v-btn>
      </template>
      <template v-else>
        <v-btn @click="goToTicketBooking">
          <span class="mr-2">จองตั๋วการแสดง</span>
        </v-btn>
        <v-btn @click="goToCancelTicketBooking">
          <span class="mr-2">ยกเลิกการจองตั๋ว</span>
        </v-btn>
        <v-btn>
          <span @click="goToHome" class="mr-2">{{ customer.name }}</span>
        </v-btn>
      </template>
    </v-app-bar>
    <template >
      <v-content>
        <!-- <Login @login="loginMethod" /> -->
        <router-view></router-view> 
      </v-content>
    </template>
  </v-app>
</template>

<script>
import Login from "../views/Login.vue"
import Home from '../views/Home.vue'
export default {
  name: "Header",
  data: () => ({
    customer: {
      id: undefined,
      name: undefined
    }
  }),
  methods:{
    loginMethod(value){
      console.log("loginMethod : ");
      console.log(value);
      this.customer = value;
      this.$router.push("/home/"+this.customer.id);
    },
    goToTicketBooking(){
      this.$router.push("/ticketbooking/"+this.customer.id);
    },
    goToCancelTicketBooking(){
      this.$router.push("/cancelticket/"+this.customer.id);
    },
    goToHome(){
      this.$router.push("/home/"+this.customer.id);
    },
    goToLoginOrRegister(){
      this.$router.push("/login");
    }
  },
  components: {
    Login,
    Home
  }
};
</script>
