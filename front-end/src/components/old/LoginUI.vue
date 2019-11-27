<template>
  <v-row justify="center" align="center">
    <v-col cols="12" md="6">
      Login
      <v-text-field v-model="username" label="Username"></v-text-field>

      <v-text-field v-model="password" label="Password"></v-text-field>
      <v-btn @click="login">Login</v-btn>
    </v-col>
  </v-row>
</template>

<script>
export default {
  data() {
    return {
      username: undefined,
      password: undefined,
      name: undefined
    };
  },
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