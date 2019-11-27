<template>
  <v-row align="center" justify="center">
    <v-col cols="12" sm="8" md="12">
      <v-card class="elevation-12">
        <v-toolbar color="primary" dark flat>
          <v-icon>mdi-basket</v-icon>&nbsp;&nbsp;
          <v-toolbar-title>ตระกร้าของฉัน</v-toolbar-title>
          <div class="flex-grow-1"></div>
        </v-toolbar>
        <v-data-table
          :headers="headers"
          :items="OKTicketBookings"
          :items-per-page="perPage"
          class="elevation-1"
        ></v-data-table>
      </v-card>
    </v-col>
  </v-row>
</template>

<script>
//พังอยู่ แสดงซ้ำกัน

import api from "../http-common";

export default {
  watch: {
    OKTicketBookings: function(val) {
      
    }
  },
  props: {
    customer: {}
  },
  data() {
    return {
      perPage: 5,
      OKTicketBookings: [],
      newTicketBookings: [],
      ticketbookings: [],
      count: 0,
      headers: [
        {
          text: "TicketBookingID",
          align: "left",
          sortable: true,
          value: "id"
        },
        { text: "BookDate", value: "bookdate" },
        { text: "CustomerName", value: "customer.name" },
        { text: "Show", value: "showSchedule.show.title" },
        { text: "ShowSchedule", value: "showSchedule.time.part" },
        { text: "ShowDate", value: "showSchedule.showDate" },
        { text: "Seat", value: "seat.name" },
        { text: "Status", value: "status" }
      ]
    };
  },
  methods: {
    test() {
      // var x = {};
      // x = this.newTicketBookings[0];
      // x.fuck = "ddd"
      // console.log(JSON.parse(JSON.stringify(x)))
      console.log("ตระกร้าของฉัน : ");
      console.log(JSON.parse(JSON.stringify(this.OKTicketBookings)));
    },
    checkPrinted(i) {
      console.log("checkPrinted : " + this.ticketbookings[i].id);
      api
        .get("/receipt/" + this.ticketbookings[i].id)
        .then(res => {
          if (!res.data) {
            console.log(
              "ตั๋ว id : " + this.ticketbookings[i].id + "ยังไม่ถูกพิมพ์ใบเสร็จ"
            );
            this.ticketbookings[i].status = "ยังไม่ชำระเงิน";
            this.OKTicketBookings.push(this.ticketbookings[i]);
          } else {
            console.log("ตั๋วถูกพิมพ์ใบเสร็จไปแล้ว");
            this.ticketbookings[i].status = "ชำระเงินแล้ว";
            this.OKTicketBookings.push(this.ticketbookings[i]);
          }
          console.log(JSON.parse(JSON.stringify(this.OKTicketBookings)));
          
        })
        .catch(e => {
          console.log(e);
        });
    },
    // checkTicketWherePrinted() {
    //   console.log("checkTicketWherePrinted");
    //   //   this.OKTicketBookings = [];
    //   console.log(JSON.parse(JSON.stringify(this.OKTicketBookings)));
    //   for (var i = 0; i < this.newTicketBookings.length; i++) {
    //     this.checkPrinted(i);
    //   }
    // },
    checkCancel(i) {
      api
        .get("/cancelticket/" + this.ticketbookings[i].id)
        .then(res => {
          if (!res.data) {
            console.log("ตั๋วยังไม่ถูกยกเลิก");
            // this.newTicketBookings.push(this.ticketbookings[i]);
            console.log(JSON.parse(JSON.stringify(this.ticketbookings[i])));
            this.checkPrinted(i);
          } else {
            console.log("ตั๋วถูกยกเลิกไปแล้ว");
            console.log(JSON.parse(JSON.stringify(res.data)));
          }
          console.log("newTicketBookings :");
          console.log(JSON.parse(JSON.stringify(this.newTicketBookings)));
        })
        .catch(e => {
          console.log(e);
        });
    },
    checkTicketWhereCanceled() {
      for (var i = 0; i < this.ticketbookings.length; i++) {
        this.checkCancel(i);
      }
    },
    getAllTicketBooking() {
      api
        .get("/ticketbooking/" + this.customer.id)
        .then(res => {
          this.ticketbookings = res.data;
          console.log("TicketBookings loaded!");
          console.log(JSON.parse(JSON.stringify(res.data)));
          this.checkTicketWhereCanceled();
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