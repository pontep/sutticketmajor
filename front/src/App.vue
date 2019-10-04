<template>
  <v-app>
    <v-app-bar app>
      <v-toolbar-title class="headline text-uppercase">
        <span>sut ticket major</span>
        <span class="font-weight-light"> - จองตั๋วการแสดง มทส.</span>
      </v-toolbar-title>
      <v-spacer></v-spacer>
      <v-btn
        text
        router-link to="/"
      >
        <span class="mr-2">Home</span>
      </v-btn>
      <v-btn
        text router-link to="/ticketbooking">
        <span class="mr-2">จองตั๋วการแสดง</span>
      </v-btn>
      <v-btn
        text router-link to="/receipt">
        <span class="mr-2">(สำหรับพนักงาน)ออกใบเสร็จ</span>
      </v-btn>
      <v-btn
        text router-link to="/viewticketbooking">
        <span class="mr-2">(สำหรับพนักงาน)ดูการจองตั๋วการแสดง</span>
      </v-btn>
      <v-btn
        text router-link to="/register">
        <span class="mr-2">สมัครสมาชิก</span>
      </v-btn>
      <v-btn
        text router-link to="/login">
        <span class="mr-2">เข้าสู่ระบบ</span>
      </v-btn>
    </v-app-bar>


    <v-content>
      
      <router-view></router-view>
    </v-content>
  </v-app>
</template>

<script>

export default {
  name: 'App',
  
  data: () => ({
    //
  }),
};
</script>
