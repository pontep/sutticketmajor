<template>
  <v-content>
    <v-container class="grey lighten-5">
      <v-row align="center" justify="center">
        <v-col cols="12" sm="8" md="6">
          <v-card class="elevation-12" tile>
            <v-toolbar color="primary" dark flat>
              <v-icon>mdi-close-circle</v-icon>&nbsp;&nbsp;
              <v-toolbar-title>ยกเลิกตั๋วการแสดง</v-toolbar-title>
              <div class="flex-grow-1"></div>
            </v-toolbar>
            <v-card-text>
              <v-select
                v-model="selectedCustomer"
                :items="customers"
                item-text="name"
                item-value="id"
                label="เลือกชื่อของตัวคุณเอง"
              ></v-select>

              <v-select
                v-model="selectedTicketBooking"
                :items="newTicketBookings"
                item-text="id"
                item-value="id"
                label="เลือกตั๋วการแสดงที่ต้องการยกเลิก"
              >
                <template
                  slot="selection"
                  slot-scope="data"
                >การแสดง {{ data.item.showSchedule.show.title }} รอบ {{ data.item.showSchedule.time.part }} วันที่ {{ data.item.showSchedule.showDate }}</template>
                <template
                  slot="item"
                  slot-scope="data"
                >การแสดง {{ data.item.showSchedule.show.title }} รอบ {{ data.item.showSchedule.time.part }} วันที่ {{ data.item.showSchedule.showDate }}</template>
                >
              </v-select>

              <v-select
                v-model="selectedReason"
                :items="reasons"
                item-text="sentence"
                item-value="id"
                label="เหตุผลในการยกเลิก"
              ></v-select>
            </v-card-text>
            <v-row align="center" justify="center">
              <v-card-actions>
                <div class="text-center">
                  <v-btn color="error" @click="save">Confirm</v-btn>
                  <!-- <v-btn color="error" @click="test">Test</v-btn> -->
                  
                </div>
              </v-card-actions>
            </v-row>
          </v-card>
        </v-col>
      </v-row>
    </v-container>
  </v-content>
</template>

  <script>
import api from "../http-common";

export default {
  mounted() {
    this.getAllCustomers();
    this.getAllReasons();
    this.getAllTicketBookings();
  },
  props: {
    customer: {}
  },
  data() {
    return {
      selectedCustomer: null,
      selectedTicketBooking: null,
      selectedReason: null,
      selectedCancelTicket: null,
      customers: [],
      ticketbookings: [],
      newTicketBookings: [],
      reasons: [],
      
    };
  },
  methods: {
    getAllCustomers() {
      api
        .get("/customer/" + this.customer.id)
        .then(response => {
          this.customers = response.data;
          this.customer = response.data;
          console.log("Customers data have bean loaded.");
          console.log(JSON.parse(JSON.stringify(response.data)));
        })
        .catch(e => {
          console.log("Error in getAllCustomer() : " + e);
        });
    },
    test(){
      console.log(this.newTicketBookings);    
    },
    checkCancel(i){
      api
        .get("/cancelticket/"+this.ticketbookings[i].id)
        .then(res =>{
          if(!res.data){
            console.log("ตั๋วยังไม่ถูกยกเลิก");
            this.newTicketBookings.push(this.ticketbookings[i]);
            console.log(this.ticketbookings[i]);
          }else{
            console.log("ตั๋วถูกยกเลิกไปแล้ว");
            console.log(res.data);
          }
        })
        .catch(e=>{
          console.log(e);
        })

    },
    checkTicketWhereCanceled(){
      for(var i = 0 ; i < this.ticketbookings.length ; i++){
        this.checkCancel(i);
      }
    }
    ,
    getAllTicketBookings() {
      api
        .get("/ticketbooking/" + this.customer.id)
        .then(response => {
          this.ticketbookings = response.data;
          console.log("Ticket Booking data have bean loaded.");
          console.log(JSON.parse(JSON.stringify(response.data)));
          this.checkTicketWhereCanceled();
        })
        .catch(e => {
          console.log(e);
        });
        
    },
    getAllReasons() {
      api
        .get("/rs")
        .then(response => {
          this.reasons = response.data;
          console.log("Reasons data have bean loaded.");
          console.log(JSON.parse(JSON.stringify(response.data)));
        })
        .catch(e => {
          console.log("Error in getAllReason() : " + e);
        });
    },
    cancle() {
      this.$refs.form.reset();
    },
    save() {
      if (
        !this.selectedCustomer ||
        !this.selectedTicketBooking ||
        !this.selectedReason
      ) {
        alert("Please select all field!");
      } else {
        this.checksave();
      }
    },
    checksave() {
      api
        .post(
          "/ct/" +
            this.selectedCustomer +
            "/" +
            this.selectedTicketBooking +
            "/" +
            this.selectedReason
        )
        .then(response => {
          alert("successfully..");
          console.log(JSON.parse(JSON.stringify(response.data)));
          this.selectedCustomer = null;
          this.selectedTicketBooking = null;
          this.selectedReason = null;
        })
        .catch(e => {
          console.log(e);
        });
    }
  }
};
</script>