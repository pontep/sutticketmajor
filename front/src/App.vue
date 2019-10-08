<template>
  <v-app>
    <v-app-bar app>
      <v-toolbar-title class="headline text-uppercase">
        <span>sut ticket major</span>
        <span class="font-weight-light">- จองตั๋วการแสดง มทส.</span>
      </v-toolbar-title>
      <v-spacer></v-spacer>
      <template v-if="!customer.name">
        <v-btn text router-link to="/login">
          <span class="mr-2">เข้าสู่ระบบ/สมัครสมาชิก</span>
        </v-btn>
      </template>
      <template v-else>
        <v-btn text router-link to="/index">
          <span class="mr-2">{{ customer.name }}</span>
        </v-btn>
      </template>
    </v-app-bar>
    <template v-if="!customer.name">
      <v-content>
        <Login @login="loginMethod" />
      </v-content>
    </template>
    <template v-else>
      <v-content>
        <router-view customer></router-view>
      </v-content>
    </template>
  </v-app>
</template>

<script>
import Login from "./views/Login.vue";
export default {
  name: "App",
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
    }
  },
  components: {
    Login
  }
};
</script>
