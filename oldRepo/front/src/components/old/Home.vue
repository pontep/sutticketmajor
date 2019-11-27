<template>
  <div>
    <v-row justify="center" align="center">
      Home
      <v-col cols="12" md="6"></v-col>
    </v-row>
  </div>
</template>

<script>
import api from "../http-common";
export default {
  data() {
    return {
      auth: [],
      username: undefined,
      password: undefined,
      name: "PontepThaweesup",
      tests: [],
      select: undefined
    };
  },
  
};
</script>