<template>
  <v-content>
    <v-container class="fill-height" fluid>
      <v-row align="center" justify="center">
        <v-col cols="12" sm="8" md="6">
          <v-card class="elevation-12">
            <v-toolbar color="primary" dark flat>
              <v-icon>mdi-ticket</v-icon>&nbsp;&nbsp;
              <v-toolbar-title>จองตั๋วการแสดง</v-toolbar-title>
              <div class="flex-grow-1"></div>
            </v-toolbar>
            <v-card-text>
              <v-select
                :items="customers"
                v-model="selectedCustomer"
                item-value="id"
                item-text="name"
                label="เลือกชื่อของตัวคุณเอง"
              ></v-select>
              <v-select
                :items="showSchedules"
                v-model="selectedShowSchedule"
                item-value="id"
                item-text="show.name"
                label="เลือกการแสดง"
              >
                <template
                  slot="selection"
                  slot-scope="data"
                >การแสดง {{ data.item.show.title }} รอบ {{ data.item.time.part }} วันที่ {{ data.item.showDate }}</template>
                <template
                  slot="item"
                  slot-scope="data"
                >การแสดง {{ data.item.show.title }} รอบ {{ data.item.time.part }} วันที่ {{ data.item.showDate }}</template>
              </v-select>
              <v-select
                v-model="selectedSeat"
                :items="seats"
                item-text="name"
                item-value="id"
                label="เลือกที่นั่ง"
              ></v-select>
            </v-card-text>
            <v-row align="center" justify="center">
              <v-card-actions>
                <div class="flex-grow-1"></div>
                <v-btn color="success" @click="bookATicket">จองตั๋วการแสดง</v-btn>
                <!-- <v-btn color="error" @click="back">Back</v-btn> -->
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
    this.getAllShowSchedules();
    this.getCustomers();
    this.getAllSeats();
  },
  props: {
    source: String,
    customer: {}
  },
  data: () => ({
    drawer: null,
    showSchedules: [],
    selectedShowSchedule: null,
    seats: [],
    selectedSeat: null,
    customers: [],
    selectedCustomer: null
  }),
  methods: {
    //   back(){
    //       this.$router.push("/customerhome/"+this.cus);
    //   },
    bookATicket() {
      if (
        !this.selectedShowSchedule ||
        !this.selectedCustomer ||
        !this.selectedSeat
      ) {
        alert("โปรดเลือกข้อมูลให้ครบทุกช่อง!");
      } else {
        api
          .post(
            "/ticketBooking/" +
              this.selectedCustomer +
              "/" +
              this.selectedShowSchedule +
              "/" +
              this.selectedSeat
          )
          .then(response => {
            console.log(JSON.parse(JSON.stringify(response.data)));
            alert("บันทึกข้อมูลการจองของคุณแล้ว!");
            this.selectedShowSchedule = null;
            this.selectedSeat = null;
            this.selectedCustomer = null;
          })
          .catch(e => {
            console.log(e);
          });
      }
    },
    getAllShowSchedules() {
      api
        .get("/showSchedules")
        .then(response => {
          this.showSchedules = response.data;
          console.log("Showschedules โหลดสำเร็จ!");
          console.log(JSON.parse(JSON.stringify(response.data)));
        })
        .catch(e => {
          console.log(e);
        });
    },
    getCustomers() {
      api
        .get("/customer/" + this.customer.id)
        .then(response => {
          this.customers = response.data;
          this.customer = this.customers;
          console.log("Customers โหลดสำเร็จ!");
          console.log(JSON.parse(JSON.stringify(response.data)));
        })
        .catch(e => {
          console.log(e);
        });
    },
    getAllSeats() {
      api
        .get("/seats")
        .then(response => {
          this.seats = response.data;
          console.log("Seats โหลดสำเร็จ!");
          console.log(JSON.parse(JSON.stringify(response.data)));
        })
        .catch(e => {
          console.log(e);
        });
    }
  }
};
</script>