<template>
  <v-content>
    <v-container class="fill-height" fluid>
      <v-row align="center" justify="center">
        <v-col cols="12" sm="8" md="6">
          <v-card class="elevation-12">
            <v-toolbar color="amber" light flat>
              <v-icon>mdi-wrench</v-icon>&nbsp;&nbsp;
              <v-toolbar-title>จัดรอบการแสดง</v-toolbar-title>
              <div class="flex-grow-1"></div>
            </v-toolbar>

            <v-card-text>
              <v-select
                v-model="S_show"
                :items="shows"
                item-text="title"
                item-value="id"
                label="เลือกชื่อการแสดง"
                :rules="[(v) => !!v || 'กรุณาเลือกชื่อการแสดง']"
                required
              ></v-select>

              <v-select
                v-model="S_time"
                :items="times"
                item-text="part"
                item-value="id"
                label="เลือกเวลาทำการแสดง"
                :rules="[(v) => !!v || 'กรุณาเลือกเวลาทำการแสดง']"
                required
              ></v-select>

              <v-select
                v-model="S_location"
                :items="locations"
                item-text="location"
                item-value="id"
                label="เลือกสถานที่ทำการแสดง"
                :rules="[(v) => !!v || 'กรุณาเลือกสถานที่ทำการแสดง']"
                required
              ></v-select>

              <v-dialog
                ref="dialog"
                v-model="menu"
                :return-value.sync="pickDate"
                persistent
                width="290px"
              >
                <template v-slot:activator="{ on }">
                  <v-text-field v-model="pickDate" label="เลือกวันที่ทำการแสดง" readonly v-on="on"></v-text-field>
                </template>

                <v-date-picker color="black" v-model="pickDate" scrollable>
                  <div class="flex-grow-1"></div>
                  <v-btn text color="primary" @click="menu = false">Cancel</v-btn>
                  <v-btn text color="primary" @click="$refs.dialog.save(pickDate)">OK</v-btn>
                </v-date-picker>
              </v-dialog>

              <div class="text-center">
                <v-btn v-model="valid" :color="valid === true ? 'success' : 'error'" @click="saveShowSchedule">save</v-btn>
                <v-btn @click="checkDate" color="warning" >check</v-btn>
              </div>
            </v-card-text>
          </v-card>
        </v-col>
      </v-row>
    </v-container>
  </v-content>
</template>

<script>
import http from "../http-common";

export default {
  props: {
    employee: {}
  },
  data() {
    return {
      S_show: undefined,
      S_time: undefined,
      S_seat: undefined,
      S_location: undefined,
      shows: [],
      seats: [],
      times: [],
      locations: [],
      dates: [],
      pickDate: undefined,
      menu: false,
      valid: false
    };
  },

  mounted() {
    this.showList();
    this.showTimeList();
    this.showLocationList();
    this.getShowDate();
  },

  methods: {
    showList() {
      http
        .get("/Shows")
        .then(response => {
          this.shows = response.data;
          console.log(JSON.parse(JSON.stringify(response.data)));
          // console.log(response.data);
        })
        .catch(e => {
          console.log("Error in showList() :" + e);
        });
    },
    showTimeList() {
      http
        .get("/showtimes")
        .then(response => {
          this.times = response.data;
          console.log(JSON.parse(JSON.stringify(response.data)));
        })
        .catch(e => {
          console.log("Error in showTimeList() :" + e);
        });
    },
    showLocationList() {
      http
        .get("/showlocations")
        .then(response => {
          this.locations = response.data;
          console.log(JSON.parse(JSON.stringify(response.data)));
        })
        .catch(e => {
          console.log("Error in showLocationList() :" + e);
        });
    },
    getShowDate() {
      http
        .get("/showSchedules")
        .then(response => {
          this.dates = response.data;
          console.log(JSON.parse(JSON.stringify(response.data)));
        })
        .catch(e => {
          console.log("Error in getShowDate() :" + e);
        });
    },
    saveShowSchedule() {
      if (this.valid) {
        http
          .post(
            "/showSchedule/" +
              this.S_show +
              "/" +
              this.S_time +
              "/" +
              this.S_location +
              "/" +
              this.pickDate
          )
          .then(response => {
            console.log(response.data);
            location.reload();
            alert("SAVED");
          })
          .catch(e => {
            console.log(e);
          });
      }
    },
    checkDate: function() {
      var count_1 = 0;
      for (var i = 0; i < this.dates.length; i++) {
        if (this.pickDate == this.dates[i].showDate) count_1++;
      }
      if (count_1 > 0) {
        count_1 = 0;
        this.valid = false;
        return alert("Please choose a new day.");
      } else {
        this.valid = true;
        return alert("You can use the date you selected.");
      }
    }
  }
};
</script>
