<template>
  <v-row align="center" justify="center">
    <v-col cols="12" sm="8" md="10">
      <v-card class="elevation-12">
        <v-toolbar color="amber" light flat>
          <v-icon>mdi-eye</v-icon>&nbsp;&nbsp;
          <v-toolbar-title>รอบการแสดงทั้งหมด</v-toolbar-title>
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
  name: "ShowScheduleData",
  data() {
    return {
      headers: [
        {
          text: "ShowSchedule_ID",
          align: "left",
          sortable: false,
          value: "id"
        },
        { text: "Show", value: "show.title" },
        { text: "Date", value: "showDate" },
        { text: "Time", value: "time.part" },
        { text: "Location", value: "location_at.location" }
      ],
      items: []
    };
  },

  methods: {
    getAllShows() {
      api
        .get("/showSchedules")
        .then(response => {
          this.items = response.data;
          console.log(JSON.parse(JSON.stringify(response.data)));
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