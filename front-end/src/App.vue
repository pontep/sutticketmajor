<template>
  <v-app>
    <v-app-bar >
      <v-toolbar-title class="headline text-uppercase">
        <span>System</span>
        <span class="font-weight-light"> Analysis and Design</span>
      </v-toolbar-title>
      <v-spacer></v-spacer>
      <router-link class="btn btn-primary" to="/showschedule">ShowSchedule</router-link>
      <v-btn text target="_blank">
        <span class="mr-2">Username : {{username}}</span>
      </v-btn>
    </v-app-bar>

    <v-content>
      <!-- <VideoRental/> -->
      <router-view />
    </v-content>
  </v-app>
</template>

<script>
export default {
  name: 'App',
  data: () => ({
    username: 'NATTHAWUT SUNTRHORNROT',
  }),
};
</script>