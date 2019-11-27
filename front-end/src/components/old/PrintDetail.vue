<template>
  <v-container class="grey lighten-5">
    <v-row no-gutters align="center" justify="center">
      <v-col cols="10">
        <v-card class="pa-2" outlined tile>
          
          <h1 class="text-center red--text">Receipt</h1>
        <v-form  ref="form" >
          <v-select
            v-model="selectedEmployee"
            :items="employee"
            item-text="name"
            item-value="id"
            label="Employee"
          ></v-select>

          <v-select
            v-model="selectedTicketBooking"
            :items="ticketbooking"
            item-text="showschedule_id"
            item-value="id"
            label="ChooseShow"
          ></v-select>

          <v-select
            v-model="selectedPaymentType"
            :items="paymenttype"
            item-text="payment"
            item-value="id"
            label="Payment"
          ></v-select>
        
          <div class="text-Right">
            <v-btn @click="Print">Prirnt</v-btn>

            <v-btn @click="back">Back</v-btn>
          </div>
          </v-form>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>



  <script>
import api from "../http-common";
export default {
  mounted() {
    this.getAllemployee();
    this.getAllticketbooking();
    this.getAllpaymenttype();
  },
  data() {
    return {
      
      employee: [],
      selectedEmployee: null,

      ticketbooking: [],
      selectedTicketBooking: null,

      selectedPaymentType: [],
      paymenttype: null
    };
  },
  methods: {
    Print(){
      alert("success");
    },
    back(){
      this.$refs.form.reset()
    },
    getAllemployee() {
      api
        .get("/employee")
        .then(response => {
          this.employee = response.data;

          console.log("show data yet");
          console.log(JSON.parse(JSON.stringify(response.data)));
        })
        .catch(e => {
          console.log(e);
        });
    },

    getAllticketbooking() {
      api
        .get("/ticket")
        .then(response => {
          this.ticketbooking = response.data;
          console.log("show data yet");
          console.log(JSON.parse(JSON.stringify(response.data)));
        })
        .catch(e => {
          console.log(e);
        });
    },

    getAllpaymenttype() {
      api
        .get("/payment")
        .then(response => {
          this.paymenttype = response.data;
          console.log("show data yet");
          console.log(JSON.parse(JSON.stringify(response.data)));
        })
        .catch(e => {
          console.log(e);
        });
    }
  }
};
</script>