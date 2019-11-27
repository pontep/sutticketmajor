<template>
  <div>
    <v-row justify="center" align="center">
      <v-col cols="12" md="6">
        <h1>จองตั๋วการแสดง</h1>
        <h3> เลือกชื่อ {{ customer.name }} เพื่อเป็นการยืนยันตัวตน</h3>
        <v-select
          :items="customers"
          v-model="selectedCustomer"
          item-value="id"
          item-text="name"
          label="เลือกชื่อของตัวคุณเอง"
        >
        </v-select>
      </v-col>
    </v-row>
    <v-row justify="center" align="center">
      <v-col cols="12" md="6">
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
          <template slot="item" slot-scope="data">
            การแสดง {{ data.item.show.title }} รอบ {{ data.item.time.part }} วันที่ {{ data.item.showDate }}
          </template>
        </v-select>
      </v-col>
    </v-row>
    <v-row justify="center" align="center">
      <v-col cols="12" md="6">
        <v-select
          v-model="selectedSeat"
          :items="seats"
          item-text="name"
          item-value="id"
          label="เลือกที่นั่ง"
        ></v-select>
      </v-col>
    </v-row>
    <v-row justify="center" align="center">
      <v-col cols="12" md="6">
        <v-btn @click="bookATicket">จองตั๋วการแสดง!</v-btn>
      </v-col>
    </v-row>
    
  </div>
</template>

<script>
import api from "../http-common";

export default {
  mounted() {
    this.getAllShowSchedules();
    this.getCustomers();
    this.getAllSeats();
  },
  data() {
    return {
      showSchedules: [],
      selectedShowSchedule: null,
      seats: [],
      selectedSeat: null,
      customers: [],
      customer:{},
      selectedCustomer: null
    };
  },
  methods: {
    bookATicket(){
        if(!this.selectedShowSchedule||!this.selectedCustomer||!this.selectedSeat){
            alert("โปรดเลือกข้อมูลให้ครบทุกช่อง!");
        }else{
            api
            .post("/ticketBooking/" + this.selectedCustomer +"/" + this.selectedShowSchedule + "/" + this.selectedSeat)
            .then(response => {
                console.log(JSON.parse(JSON.stringify(response.data)));
                alert("บันทึกข้อมูลการจองของคุณแล้ว!");
            })
            .catch(e => {
                console.log(e);
            });
            this.$router.push("/viewticketbooking");
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
        .get("/customer/"+this.$route.params.customer_id)
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