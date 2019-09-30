<template>
  <div>
    <v-row justify="center" align="center">
      <v-col cols="12" md="6">
        <h1>จองตั๋วการแสดง</h1>
        {{ selectedCustomer }}
        {{ selectedShowSchedule }}
        {{ selectedSeat }}
         (รูปภาพสมมติ)
        <img src="https://github.com/dincracker/sutticketmajor/blob/ticketbooking/1500seat.png?raw=true" />
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
          :items="showschedules"
          v-model="selectedShowSchedule"
          item-value="id"
          item-text="show.name"
          label="เลือกการแสดง"
        >
          <template
            slot="selection"
            slot-scope="data"
          >{{ data.item.show.name }} - {{ data.item.schedule }}</template>
          <template slot="item" slot-scope="data">
            {{ data.item.show.name }} - {{ data.item.schedule }}
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
    this.getAllCustomers();
    this.getAllSeats();
  },
  data() {
    return {
      tests:[
        "din","jay","big"
      ],
      showschedules: [],
      selectedShowSchedule: undefined,
      seats: [],
      selectedSeat: undefined,
      customers: [],
      selectedCustomer: undefined
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
        .get("/ShowSchedules")
        .then(response => {
          this.showschedules = response.data;
          console.log("Showschedules โหลดสำเร็จ!");
          console.log(JSON.parse(JSON.stringify(response.data)));
        })
        .catch(e => {
          console.log(e);
        });
    },
    getAllCustomers() {
      api
        .get("/customers")
        .then(response => {
          this.customers = response.data;
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

    // getAllShow() {
    //   api
    //     .get("/shows")
    //     .then(response => {
    //       this.shows = response.data;
    //       console.log("Shows data have been loaded.");
    //       console.log(JSON.parse(JSON.stringify(response.data)));
    //     })
    //     .catch(e => {
    //       console.log("Error in getAllShow() :" + e);
    //     });
    // },
    // testPost() {
    //   const data = {
    //     pickDate: this.picker
    //   };
    //   api
    //     .post("/test", data)
    //     .then(response => {
    //       console.log(response.data);
    //     })
    //     .catch(e => {
    //       console.log(e);
    //     });
    // }
  }
};
</script>