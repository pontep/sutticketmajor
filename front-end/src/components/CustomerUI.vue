<template>
  <v-form ref="form">
    <v-container class="grey lighten-5">
      <v-row no-gutters align="center" justify="center">
        <v-col cols="10">
        <v-card class="pa-2" outlined tile>
          <h1 class="text-center green--text">Register</h1>
          <v-img	
              src="http://www.laserproductions.ro/wp-content/uploads/2017/03/March-3_2017.jpg"
              aspect-ratio="2"
              class="grey lighten-2"
              max-width="1000"
              max-height="400"
            ></v-img>
          

          <v-text-field
            v-model="EnterName"
            :items="name"
            item-text="name"
            item-value="id"
            label="Fill out the name"
          ></v-text-field>

          <v-text-field
            v-model="EnterUsename"
            :items="username"
            item-text="username"
            item-value="id"
            label="Fill out the Usename"
          ></v-text-field>

          <v-text-field
            v-model="EnterPassword"
            :items="password"
            :rules="[rules.required, rules.min]"
            item-text="password"
            item-value="id"
            label="Fill out the Password"
          ></v-text-field>

          <v-select
            v-model="selectedsex"
            :items="Sex"
            item-text="sexString"
            item-value="id"
            label="Select Sex"
          ></v-select>

          <v-select
            v-model="selectedRangeAge"
            :items="RangeAge"
            item-text="rangeagesString"
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

          <div class="text-center">
            <v-btn @click="Save">Save</v-btn>

            <v-btn @click="Cancel">Cancel</v-btn>
          </div>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
  </v-form>
</template>



  <script>
import api from "../api";

export default {
  mounted() {
    this.getAllSex();
    this.getAllRangeAge();
    this.getAllCarrer();
  },
  data() {
    return {
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
          console.log("ok");
          console.log(JSON.parse(JSON.stringify(res.data)));
        })
        .catch(e => {
          console.log(e);
        });
    },
    getAllRangeAge() {
      api
        .get("/rangeage")
        .then(res => {
          this.RangeAge = res.data;
          console.log("ok");
          console.log(JSON.parse(JSON.stringify(res.data)));
        })
        .catch(e => {
          console.log(e);
        });
    },
    getAllCarrer() {
      api
        .get("/carrer")
        .then(res => {
          this.Carrer = res.data;
          console.log("ok");
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
        alert("Please fill out all information !");
      } else {
        this.SaveRegister();
      }
    },
    SaveRegister() {
      const box = {
        name: this.EnterName,
        username: this.EnterUsename,
        password: this.EnterPassword
      };
      api
        .post(
          "/Customer" +
            "/" +
            this.selectedsex +
            "/" +
            this.selectedRangeAge +
            "/" +
            this.selectedCarrer,
          box
        )
        .then(res => {
          alert("Success");
          console.log(JSON.parse(JSON.stringify(res.data)));
          this.$refs.form.reset();
        })
        .catch(e => {
          console.log(e);
        });
    },
    Cancel() {
      this.$refs.form.reset();
    }
  }
};
</script>