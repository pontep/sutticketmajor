<template>
  <v-app>
    <v-app-bar app>
      <v-toolbar-title class="headline text-uppercase">
        <span>SUT Ticket</span>
        <span class="font-weight-light"> จองตั๋วการแสดง มทส.</span>
      </v-toolbar-title>
      <v-spacer></v-spacer>
      <v-btn
        text
        href="https://github.com/vuetifyjs/vuetify/releases/latest"
        target="_blank"
      >
        <span class="mr-2">Latest Release</span>
      </v-btn>
    </v-app-bar>

    <v-content>
      <CancelTicket/>
    </v-content>
  </v-app>
</template>

<script>
import CancelTicket from './components/CancelTicket';

export default {
  name: 'App',
  components: {
    CancelTicket,
  },
  data: () => ({
    
  }),
};
</script>