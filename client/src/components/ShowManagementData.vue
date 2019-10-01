<template>
  <v-container>
    <v-layout text-center wrap>
      <v-flex mb-4>
        <br />
        <h1 class="display-2 font-weight-bold mb-3">ShowManagement Information</h1>
      </v-flex>
    </v-layout>

    <v-row justify="center">
      <v-col cols="8">
        <v-data-table :headers="headers" :items="items" :items-per-page="5" class="elevation-1"></v-data-table>
      </v-col>
    </v-row>

    <div class="text-center">
      <v-btn color="warning" class="mr-3" @click="back">หน้าหลัก</v-btn>
    </div>
  </v-container>
</template>

<script>
import api from "../api.js";
export default {
  name: "ShowManagementData",
  data() {
    return {
      headers: [
        {
          text: "Show_ID",
          align: "left",
          sortable: false,
          value: "id"
        },
        { text: "Employee", value: "createBy.employee_name" },
        { text: "Title", value: "title" },
        { text: "Type", value: "type.type" },
        { text: "Rating", value: "rating.rate" }
      ],
      items: []
    };
  },

  methods: {
    back() {
      this.$router.push("/");
    },
    getAllShows() {
      api
        .get("/Shows")
        .then(response => {
          this.items = response.data;
          console.log(this.items);
        })
        .catch(e => {
          console.log(e);
        });
    }
  },

  mounted() {
    this.getAllShows();
  }
};
</script>