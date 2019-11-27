<template>
  <div>
    <v-row justify="center" align="center">
      <v-col cols="12" sm="6" md="3">
        <h1>สมัครสมาชิก</h1>
        {{name}}
        {{username}}
        {{password}}
      </v-col>
    </v-row>

    <v-row justify="center" align="center">
      <v-col cols="12" sm="6" md="3">
        <v-text-field v-model="name" label="ชื่อ"></v-text-field>
      </v-col>
    </v-row>
    <v-row justify="center" align="center">
      <v-col cols="12" sm="6" md="3">
        <v-text-field v-model="username" label="ชื่อผู้ใข้"></v-text-field>
      </v-col>
    </v-row>
    <v-row justify="center" align="center">
      <v-col cols="12" sm="6" md="3">
        <v-text-field type="password" v-model="password" label="รหัสผ่าน"></v-text-field>
      </v-col>
    </v-row>
    <div class="text-center">
      <v-btn @click="register">สมัครสมาชิก</v-btn>
    </div>
  </div>
</template>



<script>
import api from "../http-common";

export default {
  data() {
    return {
      name: undefined,
      username: null,
      password: null
    };
  },
  methods: {
    register() {

      const customer = {
        name: this.name,
        username: this.username,
        password: this.password
      };

      api
      .post("/customer")
      .then(response =>{
        console.log(JSON.parse(JSON.stringify(response.data)));
      })
      .catch(e => {
          console.log(e);
      })
      
    }
  }
};
</script>