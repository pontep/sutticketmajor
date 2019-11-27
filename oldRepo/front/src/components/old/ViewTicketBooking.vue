<template>
    <v-row justify="center" align="center">
      <v-col cols="12" md="10">
        <h1>ดูประวัติการจองตั๋วการแสดง</h1>
        <v-data-table :headers="headers" :items="ticketbookings" :items-per-page="10" class="elevation-1"></v-data-table>
      </v-col>
    </v-row>
</template>

<script>
import api from "../http-common";

export default {
  data() {
    return {
        ticketbookings:[],
      headers: [
        {
        //   text: "Dessert (100g serving)",
        //   align: "left",
        //   sortable: false,
        //   value: "name"
        },
          { text: 'TicketBookingID', value: 'id' },
          { text: 'BookDate', value: 'bookdate' },
          { text: 'CustomerName', value: 'customer.name' },
          { text: 'Show', value: 'showSchedule.show.title' },
          { text: 'ShowSchedule', value: 'showSchedule.time.part' },
          { text: 'ShowDate', value: 'showSchedule.showDate' },
          
          { text: 'SeatID', value: 'seat.id' }
      ]
      
    };
  },
  methods: {
      getAllTicketBooking(){
          api
          .get("/ticketBookings")
          .then(res =>{
              this.ticketbookings = res.data;
              console.log("ticketbooking loaded!");
              console.log(JSON.parse(JSON.stringify(res.data)))
          })
          .catch(e =>{
              console.log(e);
          })
      }
  },
  mounted(){
      this.getAllTicketBooking();
  }
};
</script>