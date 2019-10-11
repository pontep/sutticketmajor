<template>
  <v-app id="inspire">
    <v-content>
      <v-container class="fill-height" fluid>
        <v-row align="center" justify="center">
          <v-col cols="12" sm="8" md="4">
            <v-card class="elevation-12">
              <v-toolbar color="primary" dark flat>
                <v-icon>mdi-account-plus</v-icon>&nbsp;&nbsp;
                <v-toolbar-title>สมัครสมาชิก</v-toolbar-title>
                <div class="flex-grow-1"></div>
              </v-toolbar>
              <v-card-text>
                <v-text-field
                  v-model="EnterUsename"
                  label="Username"
                  name="login"
                  prepend-icon="person"
                  type="text"
                ></v-text-field>
                <v-text-field
                  v-model="EnterPassword"
                  id="password"
                  label="Password"
                  name="password"
                  prepend-icon="lock"
                  type="password"
                ></v-text-field>
                <v-text-field
                  v-model="EnterName"
                  :items="name"
                  item-text="name"
                  item-value="id"
                  label="Fill out the name"
                ></v-text-field>
                <v-select
                  v-model="selectedsex"
                  :items="Sex"
                  item-text="sex"
                  item-value="id"
                  label="Select Sex"
                ></v-select>

                <v-select
                  v-model="selectedRangeAge"
                  :items="RangeAge"
                  item-text="rangeages"
                  item-value="id"
                  label="Select Range Age"
                ></v-select>

                <v-select
                  v-model="selectedCarrer"
                  :items="Carrer"
                  item-text="name"
                  item-value="id"
                  label="select Carrer"
                ></v-select>
              </v-card-text>
              <v-card-actions>
                <div class="flex-grow-1"></div>

                <v-btn color="success" @click="Save">สมัครสมาชิก</v-btn>
                <v-btn color="secondary" router-link to="/">กลับ</v-btn>
              </v-card-actions>
            </v-card>
          </v-col>
        </v-row>
      </v-container>
    </v-content>
  </v-app>
</template>
<script>
import api from "../http-common";

export default {
  props: {
    source: String
  },
  mounted() {
    this.getAllSex();
    this.getAllRangeAge();
    this.getAllCarrer();
  },
  data() {
    return {
      drawer: null,
      rules: {
        required: value => !!value || "Required.",
        min: v => v.length >= 6 || "Min 6 characters",
        emailMatch: () => "The email and password you entered don't match"
      },
      EnterName: null,
      EnterUsename: null,
      EnterPassword: null,
      selectedRangeAge: null,
      selectedsex: null,
      selectedCarrer: null,
      name: [],
      username: [],
      password: [],
      Sex: [],
      RangeAge: [],
      Carrer: []
    };
  },
  methods: {
    getAllSex() {
      api
        .get("/sex")
        .then(res => {
          this.Sex = res.data;
          console.log("loading sexs");
          console.log(JSON.parse(JSON.stringify(res.data)));
        })
        .catch(e => {
          console.log(e);
        });
    },
    getAllRangeAge() {
      api
        .get("/rangeAges")
        .then(res => {
          this.RangeAge = res.data;
          console.log("loading rangeAges");
          console.log(JSON.parse(JSON.stringify(res.data)));
        })
        .catch(e => {
          console.log(e);
        });
    },
    getAllCarrer() {
      api
        .get("/careers")
        .then(res => {
          this.Carrer = res.data;
          console.log("loading careers");
          console.log(JSON.parse(JSON.stringify(res.data)));
        })
        .catch(e => {
          console.log(e);
        });
    },
    Save() {
      if (
        !this.EnterName ||
        !this.EnterUsename ||
        !this.EnterPassword ||
        !this.selectedRangeAge ||
        !this.selectedsex ||
        !this.selectedCarrer
      ) {
        alert("กรุณากรอกข้อมูลให้ครบถ้วน!");
      } else {
        this.checkUsername();
      }
    },

    checkUsername() {
      api
        .get("/customer/check/" + this.EnterUsename)
        .then(res => {
          if (!res.data) {
            this.registered();
          } else {
            alert("Username ถูกใช้แล้ว!");
          }
        })
        .catch(e => {
          console.log(e);
        });
    },
    registered() {
      api
        .post(
          "/customer" +
            "/" +
            this.selectedsex +
            "/" +
            this.selectedRangeAge +
            "/" +
            this.selectedCarrer +
            "/" +
            this.EnterName +
            "/" +
            this.EnterUsename +
            "/" +
            this.EnterPassword
        )
        .then(res => {
          alert("Success");
          console.log(JSON.parse(JSON.stringify(res.data)));
          this.$router.push("/");
        })
        .catch(e => {
          console.log(e);
        });
    },
    Back() {
      //back
    }
  }
};
</script>