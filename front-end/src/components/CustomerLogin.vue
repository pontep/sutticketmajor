<template>
  <v-app id="inspire">
    <v-content>
      <v-container class="fill-height" fluid>
        <v-row align="center" justify="center">
          <v-col cols="12" sm="8" md="4">
            <v-card class="elevation-12">
              <v-toolbar color="primary" dark flat>
                <v-icon>mdi-login-variant</v-icon>&nbsp;&nbsp;
                <v-toolbar-title>เข้าสู่ระบบในฐานะลูกค้า</v-toolbar-title>
                <div class="flex-grow-1"></div>
              </v-toolbar>
              <v-card-text>
                <v-form>
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
                </v-form>
              </v-card-text>
              <v-card-actions>
                <div class="flex-grow-1"></div>
                <v-btn color="primary" @click="customerLogin">เข้าสู่ระบบ</v-btn>
                <v-btn color="success" router-link to="/register">
                <v-icon>mdi-account-plus</v-icon>
                  สมัครสมาชิก
                  
                </v-btn>
                <v-btn color="warning" router-link to="/employeelogin">
                  <v-icon>mdi-hard-hat</v-icon>พนักงาน?
                </v-btn>
              </v-card-actions>
            </v-card>
          </v-col>
        </v-row>
      </v-container>
    </v-content>
  </v-app>
</template>

<script>
import api from "../http-common";
export default {
  props: {
    source: String
  },
  data: () => ({
    drawer: null,
    username: null,
    password: null,
    auth: {}
  }),
  methods: {
    customerLogin() {
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
              this.$router.push("/customerhome/" + this.auth.id);
            }
          })
          .catch(e => {
            console.log(e);
          });
      }
    }
  }
};
</script>