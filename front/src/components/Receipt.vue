<template>
  <v-content>
    <v-container class="fill-height" fluid>
      <v-row align="center" justify="center">
        <v-col cols="12" sm="8" md="6">
          <v-card class="elevation-12">
            <v-toolbar color="amber" light flat>
              <v-icon>mdi-paper-roll</v-icon>&nbsp;&nbsp;
              <v-toolbar-title>พิมพ์ใบเสร็จ</v-toolbar-title>
              <div class="flex-grow-1"></div>
            </v-toolbar>
            <v-card-text>
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
                :items="OKTicketBookings"
                item-text="bookdate"
                item-value="id"
                label="เลือกตั๋วการแสดงที่ลูกค้าได้จองไว้"
              >
                <!-- <template
                slot="selection"
                slot-scope="data"
                >{{ data.item.show.name }} - {{ data.item.schedule }} - {{ data.item.seat.name }}</template>-->
                <template slot="item" slot-scope="data">
                  {{ data.item.showSchedule.show.title }} - {{ data.item.showSchedule.time.part }}
                  - {{ data.item.seat.name }}
                </template>

                <template slot="selection" slot-scope="data">
                  {{ data.item.showSchedule.show.title }} - {{ data.item.showSchedule.time.part }}
                  - {{ data.item.seat.name }}
                </template>
              </v-select>

              <v-select
                v-model="selectedPaymentType"
                :items="paymenttype"
                item-text="payment"
                item-value="id"
                label="่ช่องทางการชำระเงิน"
              ></v-select>

              <div class="text-Right">
                <v-btn color="warning" @click="Print">Print</v-btn>
              </div>
            </v-card-text>
          </v-card>
        </v-col>
      </v-row>
    </v-container>
  </v-content>
</template>



  <script>
import api from "../http-common";
export default {
  props: {
    employee: {}
  },
  watch: {
    selectedCustomer: function(val) {
      this.getAllticketbooking();
    },
    newTicketBookings: function(val) {
      this.checkTicketWherePrinted();
    }
  },
  mounted() {
    this.getAllemployee();
    this.getAllpaymenttype();
    this.getAllCustomers();
  },
  data() {
    return {
      employee: [],
      selectedEmployee: null,

      ticketbookings: [],
      newTicketBookings: [],
      OKTicketBookings: [],
      selectedTicketBooking: null,

      customer: [],
      selectedCustomer: null,

      selectedPaymentType: [],
      paymenttype: null
    };
  },
  methods: {
    getAllCustomers() {
      api
        .get("/customers")
        .then(response => {
          this.customer = response.data;
          console.log(JSON.parse(JSON.stringify(response.data)));
        })
        .catch(e => {
          console.log(e);
        });
    },

    Print() {
      if (
        !this.selectedEmployee ||
        !this.selectedPaymentType ||
        !this.selectedTicketBooking ||
        !this.selectedCustomer
      ) {
        alert("กรุณาเลือกข้อมูลให้ครบ!");
      } else {
        this.SavaData();
      }
    },

    getAllemployee() {
      api
        .get("/employee" + this.employee.id)
        .then(response => {
          this.employee = response.data;

          console.log("show data yet");
          console.log(JSON.parse(JSON.stringify(response.data)));
        })
        .catch(e => {
          console.log(e);
        });
    },

    SavaData() {
      api
        .post(
          "/receipts/" +
            this.selectedEmployee +
            "/" +
            this.selectedPaymentType +
            "/" +
            this.selectedTicketBooking
        )
        .then(din => {
          alert("บันทึกใบเสร็จสำเร็จ!");
          this.selectedCustomer = null;
          this.selectedEmployee = null;
          this.selectedTicketBooking = null;
          this.selectedPaymentType = null;
        })
        .catch(e => {
          console.log(e);
        });
    },
    //Axios ต้องรอ!
    checkPrinted(i) {
      console.log("checkPrinted");

      api
        .get("/receipt/" + this.newTicketBookings[i].id)
        .then(res => {
          if (!res.data) {
            console.log("ตั๋วยังไม่ถูกพิมพ์ใบเสร็จ");
            this.OKTicketBookings.push(this.newTicketBookings[i]);
            console.log(this.newTicketBookings[i]);
          } else {
            console.log("ตั๋วถูกพิมพ์ใบเสร็จไปแล้ว");
            console.log(res.data);
          }
        })
        .catch(e => {
          console.log(e);
        });
    },
    checkTicketWherePrinted() {
      console.log("checkTicketWherePrinted");
      this.OKTicketBookings = [];
      for (var i = 0; i < this.newTicketBookings.length; i++) {
        this.checkPrinted(i);
      }
    },
    checkCancel(i) {
      api
        .get("/cancelticket/" + this.ticketbookings[i].id)
        .then(res => {
          if (!res.data) {
            console.log("ตั๋วยังไม่ถูกยกเลิก");
            this.newTicketBookings.push(this.ticketbookings[i]);
            console.log(this.ticketbookings[i]);
          } else {
            console.log("ตั๋วถูกยกเลิกไปแล้ว");
            console.log(res.data);
          }
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
    getAllticketbooking() {
      api
        .get("/ticketbooking/" + this.selectedCustomer)
        .then(response => {
          this.ticketbookings = response.data;
          console.log("get ticetBookings where customer = this.customer");
          console.log(JSON.parse(JSON.stringify(response.data)));
          this.checkTicketWhereCanceled();
        })
        .catch(e => {
          console.log(e);
        });
    },

    getAllpaymenttype() {
      api
        .get("/payments")
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