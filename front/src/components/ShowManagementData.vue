<template>
  <v-row align="center" justify="center">
    <v-col cols="12" sm="8" md="10">
      <v-card class="elevation-12">
        <v-toolbar color="amber" light flat>
          <v-icon>mdi-eye</v-icon>&nbsp;&nbsp;
          <v-toolbar-title>การแสดงทั้งหมด</v-toolbar-title>
          <div class="flex-grow-1"></div>
        </v-toolbar>
        <v-data-table
          :headers="headers"
          :items="items"
          :items-per-page="10"
          class="elevation-1"
        ></v-data-table>
      </v-card>
    </v-col>
  </v-row>
</template>

<script>
import api from "../http-common";
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
        { text: "Employee", value: "createBy.name" },
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