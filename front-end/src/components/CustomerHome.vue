<template>
  <v-app id="inspire">
    <v-navigation-drawer v-model="drawer" app temporary>
      <v-list dense>
        <v-list-item @click="goCustomerHome">
          <v-list-item-action>
            <v-icon>mdi-home</v-icon>
          </v-list-item-action>
          <v-list-item-content>
            <v-list-item-title>Home</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
        <v-divider inset></v-divider>

        <v-list-item @click="goTicketBooking">
          <v-list-item-action>
            <v-icon>mdi-ticket</v-icon>
          </v-list-item-action>
          <v-list-item-content>
            <v-list-item-title>จองตั๋วการแสดง</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
        <v-list-item @click="goCancelTicket">
          <v-list-item-action>
            <v-icon>mdi-close-circle</v-icon>
          </v-list-item-action>
          <v-list-item-content>
            <v-list-item-title>ยกเลิกการจอง</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
        <!-- <v-list-item @click="goBasket">
          <v-list-item-action>
            <v-icon>mdi-basket</v-icon>
          </v-list-item-action>
          <v-list-item-content>
            <v-list-item-title>ตระกร้าของฉัน</v-list-item-title>
          </v-list-item-content>
        </v-list-item> -->
        <v-divider inset></v-divider>
      </v-list>
      <template v-slot:append>
        <v-list-item @click="logout">
          <v-list-item-action>
            <v-icon>mdi-logout</v-icon>
          </v-list-item-action>
          <v-list-item-content>
            <v-list-item-title>ออกจากระบบ</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </template>
    </v-navigation-drawer>

    <v-app-bar app color="blue darken-3" dark clipped-left>
      <v-app-bar-nav-icon @click.stop="drawer = !drawer"></v-app-bar-nav-icon>

      <v-toolbar-title>
        <v-icon dark>mdi-account</v-icon>
        <span class="title ml-3 mr-5">
          Customer&nbsp;
          <span class="font-weight-light">: {{ customer.name }}</span>
        </span>
      </v-toolbar-title>
    </v-app-bar>

    <v-content>
      <v-container class="fill-height" fluid>
        <v-row align="center" justify="center">
          <v-col class="text-center">
            <template v-if="content === 'customerhome'">
              <CustomerHomeContent :customer="customer" />
            </template>
            <template v-else-if="content === 'ticketbooking'">
              <TicketBooking :customer="customer" />
            </template>
            <template v-else-if="content === 'cancelticket'">
              <CancelTicket :customer="customer" />
            </template>
            <template v-else-if="content === 'basket'">
              <Basket :customer="customer" />
            </template>
          </v-col>
        </v-row>
      </v-container>
    </v-content>
    <v-footer color="blue darken-3" app>
      <span class="white--text">523331 SYSTEM ANALYSIS AND DESIGN 1/2562 Sec3 Group 25 ระบบจองตั๋วการแสดง &copy; 2019 </span>
    </v-footer>
  </v-app>
</template>

<script>
import api from "../http-common";
import CustomerHomeContent from "./CustomerHomeContent";
import TicketBooking from "./TicketBooking";
import CancelTicket from "./CancelTicket";
import Basket from "./Basket";
export default {
  // created() {
  //   this.$vuetify.theme.dark = true;
  // },
  components: {
    CustomerHomeContent,
    TicketBooking,
    CancelTicket,
    Basket
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
      if (confirm("แน่ใจหรือไม่ว่าต้องการออกจากระบบ?")) {
        this.$router.push("/");
      } else {
      }
    },
    goTicketBooking() {
      // this.$router.push("/ticketbooking/"+this.customer.id);
      this.content = "ticketbooking";
      this.drawer = false;
    },
    goCancelTicket() {
      // this.$router.push("/ticketbooking/"+this.customer.id);
      this.content = "cancelticket";
      this.drawer = false;
    },
    goCustomerHome() {
      this.content = "customerhome";
      this.drawer = false;
    },
    goBasket() {
      this.content = "basket";
      this.drawer = false;
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