<template>
  <v-app id="inspire">
    <v-navigation-drawer v-model="drawer" app>
      <v-list dense>
        <v-list-item @click="goCustomerHome">
          <v-list-item-action>
            <v-icon>mdi-home</v-icon>
          </v-list-item-action>
          <v-list-item-content>
            <v-list-item-title>Home</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
        <v-list-item @click="goTicketBooking">
          <v-list-item-action>
            <v-icon>mdi-contact-mail</v-icon>
          </v-list-item-action>
          <v-list-item-content>
            <v-list-item-title>จองตั๋วการแสดง</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
        <v-list-item @click="goCancelTicket">
          <v-list-item-action>
            <v-icon>mdi-contact-mail</v-icon>
          </v-list-item-action>
          <v-list-item-content>
            <v-list-item-title>ยกเลิกตั๋วการแสดง</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </v-list>
      <v-btn @click="logout">ออกจากระบบ</v-btn>
    </v-navigation-drawer>

    <v-app-bar app color="indigo" dark>
      <v-app-bar-nav-icon @click.stop="drawer = !drawer"></v-app-bar-nav-icon>
      <v-toolbar-title>{{ customer.name }}</v-toolbar-title>
    </v-app-bar>

    <v-content>
      <v-container class="fill-height" fluid>
        <v-row align="center" justify="center">
          <v-col class="text-center">
            <template v-if="content === 'customerhome'">
              <CustomerHomeContent :customer="customer" />
            </template>
            <template v-else-if="content === 'ticketbooking'">
              <TicketBooking />
            </template>
            <template v-else-if="content === 'cancelticket'">
              <CancelTicket />
            </template>
          </v-col>
        </v-row>
      </v-container>
    </v-content>
    <v-footer color="indigo" app>
      <span class="white--text">&copy; 2019</span>
    </v-footer>
  </v-app>
</template>

<script>
import api from "../http-common";
import CustomerHomeContent from "./CustomerHomeContent";
import TicketBooking from "./TicketBooking";
import CancelTicket from "./CancelTicket";
export default {
  components: {
    CustomerHomeContent,
    TicketBooking,
    CancelTicket
  },
  mounted() {
    this.customer.id = this.$route.params.customerId;
    this.getCustomer();
  },
  props: {
    source: String
  },
  data: () => ({
    drawer: null,
    customer: {},
    content: "customerhome"
  }),
  methods: {
    logout() {
      if (confirm("Are you sure want to logout?")) {
        this.$router.push("/");
      } else {
        
      }
    },
    goTicketBooking() {
      // this.$router.push("/ticketbooking/"+this.customer.id);
      this.content = "ticketbooking";
    },
    goCancelTicket() {
      // this.$router.push("/ticketbooking/"+this.customer.id);
      this.content = "cancelticket";
    },
    goCustomerHome() {
      this.content = "customerhome";
    },
    getCustomer() {
      api
        .get("/customer/" + this.customer.id)
        .then(res => {
          this.customer = res.data;
        })
        .catch(e => {
          console.log(e);
        });
    }
  }
};
</script>