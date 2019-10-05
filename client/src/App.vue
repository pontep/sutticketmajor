<template>
  <v-app>
    <v-app-bar app>
      <v-toolbar-title class="headline text-uppercase">
        <span>SUT Ticket Major</span>
        <span class="font-weight-light"> </span>
      </v-toolbar-title>
      <v-spacer></v-spacer>
      <v-btn
        text
        target="_blank"
      >
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
    username: 'Patcharaphon Ticharoen',
  }),
};
</script>