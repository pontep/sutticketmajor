<template>
  <v-container class="grey lighten-5">
    <v-row no-gutters align="center" justify="center">
      <v-col cols="10">
        <v-card class="pa-2" outlined tile>
          <h1 class="text-center red--text">Receipt</h1>
          <v-form ref="form">

            <v-select
              v-model="selectedEmployee"
              :items="employee"
              item-text="name"
              item-value="id"
              label="เลือกชื่อพนักงาน"
            ></v-select>

            <v-select
              v-model="selectedCustomer"
              :items="customer"
              item-text="name"
              item-value="id"
              label="เลือกชื่อของลูกค้า"
            ></v-select>
            
            <v-select
              v-model="selectedTicketBooking"
              :items="ticketbooking"
              item-text="showSchedule"
              item-value="id"
              label="เลือกตั๋วการแสดงที่ลูกค้าได้จองไว้"
            ></v-select>

            <v-select
              v-model="selectedPaymentType"
              :items="paymenttype"
              item-text="payment"
              item-value="id"
              label="่ช่องทางการชำระเงิน"
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
    this.getAllCustomers();
  },
  data() {
    return {
      employee: [],
      selectedEmployee: null,

      ticketbooking: [],
      selectedTicketBooking: null,

      customer:[],
      selectedCustomer: null,

      selectedPaymentType: [],
      paymenttype: null

      
    };
  },
  methods: {
    getAllCustomers(){
      api
        .get("/customers")
        .then(response =>{
          this.customer =response.data;
          console.log(JSON.parse(JSON.stringify(response.data)));
        })
        .catch(e =>{
          console.log(e);
        })
    },
    
    Print() {
      if (!this.selectedEmployee || !this.selectedPaymentType || !this.selectedTicketBooking || !this.selectedCustomer){
          alert("Please select again");
          this.$refs.form.reset();
      } else{
        
        this.SavaData();
      }
    },

    back() {
      this.$refs.form.reset();
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

    SavaData(){
      api
        .post("/receipts/"+this.selectedEmployee+"/"+this.selectedPaymentType+"/"+this.selectedTicketBooking)
        .then(din => {
          alert("SUCCESS!!!!");
        })
        .catch(e =>{
          console.log(e);
        })
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