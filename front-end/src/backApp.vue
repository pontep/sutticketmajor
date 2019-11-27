<template>
  <v-app>
    <v-app-bar app color="amber accent-3">
      <v-app-bar-nav-icon class="black--text" @click="menu = !menu"></v-app-bar-nav-icon>

      <v-toolbar-title class="headline text-uppercase black--text">
        <span>SUT Ticket Major</span>
      </v-toolbar-title>
      <v-spacer></v-spacer>
      <v-btn v-if="status_login1" color="yellow darken-1" to="/">
        <span class="mr-2">Login</span>
      </v-btn>
      <v-btn v-if="status_login1" color="yellow darken-1" to="/Register">
        <span class="mr-2">Register</span>
      </v-btn>
    </v-app-bar>

    <!-- for employee -->
    <v-navigation-drawer v-if="!status_login_peron" app color="blue-grey darken-4" v-model="menu">
      <div class="pa-2">
        <h1 class="text-center white--text pb-2">Management</h1>
        <hr class="mx-4" />
        <v-list>
          <v-list-item
            v-for="list in menu_lists_of_Emp"
            :key="list.text"
            router
            :to="list.router"
            @click="Show"
          >
            <v-list-item-content class="px-1">
              <v-list-item-title class="white--text">{{ list.text }}</v-list-item-title>
            </v-list-item-content>
          </v-list-item>
        </v-list>
      </div>
      <template v-slot:append>
        <div class="pa-12">
          <v-btn v-if="status_login2" block to>Logout</v-btn>
        </div>
      </template>
    </v-navigation-drawer>

    <!-- for customer -->
    <v-navigation-drawer v-else app color="blue-grey darken-4" v-model="menu">
      <div class="pa-2">
        <h1 class="text-center white--text pb-2">Welcome</h1>
        <hr class="mx-4" />
        <v-list>
          <v-list-item
            v-for="list in menu_lists_of_Cus"
            :key="list.text"
            router
            :to="list.router"
            @click="Show"
          >
            <v-list-item-content class="px-1">
              <v-list-item-title class="white--text">{{ list.text }}</v-list-item-title>
            </v-list-item-content>
          </v-list-item>
        </v-list>
      </div>
      <template v-slot:append>
        <div class="pa-12">
          <v-btn v-if="status_login2" block to>Logout</v-btn>
        </div>
      </template>
    </v-navigation-drawer>

    <v-content>
      <router-view />
    </v-content>
  </v-app>
</template>

<script>
export default {
  data() {
    return {
      status_login1: false,
      status_login2: true,
      status_login_peron: true,
      menu: false,
      Authenticated: false,
      Accounts: [],
      menu_lists_of_Emp: [
        { text: "Show", router: "/ShowManagement" },
        { text: "Receipt", router: "/Receipt" },
        { text: "Show Schedule", router: "/ManageShowSchedule" }
      ],
      menu_lists_of_Cus: [
        { text: "Ticket Booking", router: "/ticketbooking/1" },
        { text: "Ticket Cancel", router: "/CancelTicket" }
      ]
    };
  },
  methods: {}
};
</script>
