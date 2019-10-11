<template>
  <v-row align="center" justify="center">
    <v-col cols="12" sm="8" md="9">
      <v-card class="elevation-12">
        <v-toolbar color="primary" dark flat>
          <v-icon>mdi-basket</v-icon>&nbsp;&nbsp;
          <v-toolbar-title>ตระกร้าของฉัน</v-toolbar-title>
          <div class="flex-grow-1"></div>
        </v-toolbar>
        <v-data-table
          :headers="headers"
          :items="ticketbookings"
          :items-per-page="10"
          class="elevation-1"
        ></v-data-table>
      </v-card>
    </v-col>
  </v-row>
</template>

<script>
import api from "../http-common";

export default {
  props: {
    customer: {}
  },
  data() {
    return {
      ticketbookings: [],
      headers: [
        {
          //   text: "Dessert (100g serving)",
          //   align: "left",
          //   sortable: false,
          //   value: "name"
        },
        { text: "TicketBookingID", value: "id" },
        { text: "BookDate", value: "bookdate" },
        { text: "CustomerName", value: "customer.name" },
        { text: "Show", value: "showSchedule.show.title" },
        { text: "ShowSchedule", value: "showSchedule.time.part" },
        { text: "ShowDate", value: "showSchedule.showDate" },

        { text: "SeatID", value: "seat.id" }
      ]
    };
  },
  methods: {
    getAllTicketBooking() {
      api
        .get("/ticketbooking/" + this.customer.id)
        .then(res => {
          this.ticketbookings = res.data;
          console.log("ticketbooking loaded!");
          console.log(JSON.parse(JSON.stringify(res.data)));
        })
        .catch(e => {
          console.log(e);
        });
    }
  },
  mounted() {
    this.getAllTicketBooking();
  }
};
</script>