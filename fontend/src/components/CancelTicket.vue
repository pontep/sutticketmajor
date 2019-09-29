<template>
  <v-form ref="form">
    <v-container class="grey lighten-5">
      <v-row no-gutters align="center" justify="center">
        <v-col cols="5">
          <v-card class="pa-2" outlined tile>
            <h1 class="text-center red--text">Cancel Ticket</h1>

            <v-select
              v-model="selectedCustomer"
              :items="customers"
              item-text="username"
              item-value="id"
              label="เลือกชื่อ User"
            ></v-select>

            <v-select
              v-model="selectedTicketBooking"
              :items="ticketbookings"
              item-text="id"
              item-value="id"
              label="เลือกตั๋วการแสดงที่ลูกค้าได้จองไว้"
              ><template slot="item" slot-scope="data">
                {{data.item.showSchedule.show.name}} - {{data.item.showSchedule.schedule}}
                - {{data.item.seat.name}}
              </template>
              ><template
                slot="selection"
                slot-scope="data">
                  {{data.item.showSchedule.show.name}} - {{data.item.showSchedule.schedule}}
                - {{data.item.seat.name}}
              </template>
            ></v-select>

            <v-select
              v-model="selectedReason"
              :items="reasons"
              item-text="sentence"
              item-value="id"
              label="เหตุผลในการยกเลิก"
            ></v-select>

            <div class="text-center">
              <v-btn @click="save">Confirm</v-btn>
              <v-btn @click="cancle">Back</v-btn>

            </div>
          </v-card>
        </v-col>
      </v-row>
    </v-container>
  </v-form>
</template>

  <script>
import api from "../http-common";

export default {
  watch: {
    selectedCustomer: function (val) {
      this.getAllTicketBookings();
    }
  },
  mounted() {
    this.getAllCustomers();
   // this.getAllTicketBookings();
    this.getAllReasons();
  },
  data() {
    return {
      selectedCustomer: null,
      selectedTicketBooking: null,
      selectedReason: null,
      customers: [],
      ticketbookings: [],
      reasons: []
    };
  },
   methods: {
    getAllCustomers() {
      api
        .get("/cm")
        .then(response => {
          this.customers = response.data;
          console.log("Customers data have bean loaded.");
          console.log(JSON.parse(JSON.stringify(response.data)));
        })
        .catch(e => {
          console.log("Error in getAllCustomer() : " + e);
        });
    },
    getAllTicketBookings() {
      api
        .get("/tb/"+this.selectedCustomer)
        .then(response => {
          this.ticketbookings = response.data;
          console.log("Ticket Booking data have bean loaded.");
          console.log(JSON.parse(JSON.stringify(response.data)));
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
        this.checkdelete();
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
          alert("Add data successfully..");
          console.log(JSON.parse(JSON.stringify(response.data)));
          this.$refs.form.reset(); 
        
        })
        .catch(e => {
          console.log(e);
        });
    },
    checkdelete(){
      api
        .delete(
          "/tb/"+this.selectedTicketBooking
        )
        .then(response => {
          alert("Delete data successfully..");
          console.log(JSON.parse(JSON.stringify(response.data)));
          this.$refs.form.reset(); 
        
        })
        .catch(e => {
          console.log(e);
        });
    }

  }
};
</script>