<template>
  <v-app id="inspire">
    <template v-if="register">
      <CustomerUI @register="doRegisterMethod"/>
    </template>
    <template v-else>
    <v-content>
      <v-container class="fill-height" fluid>
        <v-row align="center" justify="center">
          <v-col cols="12" sm="8" md="4">
            <v-card class="elevation-12">
              <v-toolbar color="primary" dark flat>
                <v-toolbar-title>เข้าสู่ระบบในฐานะลูกค้า</v-toolbar-title>
                <div class="flex-grow-1"></div>
              </v-toolbar>
              <v-card-text>
                <v-text-field
                  v-model="username"
                  label="Username"
                  name="login"
                  prepend-icon="person"
                  type="text"
                ></v-text-field>
                <v-text-field
                  v-model="password"
                  id="password"
                  label="Password"
                  name="password"
                  prepend-icon="lock"
                  type="password"
                ></v-text-field>
              </v-card-text>
              <v-card-actions>
                <div class="flex-grow-1"></div>
                <v-btn color="primary" @click="login">Login</v-btn>
                <v-btn color="secondary" @click="doRegister">Register</v-btn>
              </v-card-actions>
            </v-card>
          </v-col>
        </v-row>
      </v-container>
    </v-content>
    </template>
  </v-app>
</template>

<script>
import api from "../http-common";
import CustomerUI from '../components/CustomerUI'
import LoginUI from '../components/LoginUI'
export default {
  name: "Login",
  components:{
    CustomerUI
  },
  data: () => ({
    drawer: null,
    username: undefined,
    password: undefined,
    auth: {},
    register: false
  }),
  methods: {
    login() {
      if (!this.username || !this.password) {
        alert("Please enter username and password.");
      } else {
        api
          .get("/customer/" + this.username + "/" + this.password)
          .then(res => {
            console.log(JSON.parse(JSON.stringify(res.data)));
            this.auth = res.data;
            if (!this.auth.username) {
              alert("Username or password is in correct!");
              console.log(this.auth);
            } else {
              alert("Login successfully...\nWelcome " + this.auth.name);
              this.$emit("login", this.auth);
              this.$router.push("/home/"+this.auth.id);
            }
          })
          .catch(e => {
            console.log(e);
          });
      }
    },
    doRegister() {
      this.register = true;
    },
    doRegisterMethod(value){
      this.register = value;
      console.log("doRegisterMethod :");
      console.log(value);
    }
  }
};
</script>