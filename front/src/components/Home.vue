<template>
  <div>
    <v-row justify="center" align="center">
      <v-col cols="12" md="6">
          <h1>
            ระบบจองตั๋วการแสดง
          </h1>
          <h2>
            ระบบย่อย : ระบบจองตั๋วการแสดง
          </h2>
          <h3>
            B6000783 นายพรเทพ ทวีทรัพย์
          </h3>
      </v-col>
    </v-row>
    <v-row justify="center" align="center">
      <v-col cols="12" md="6">

      </v-col>
    </v-row>
  </div>
</template>

<script>
import api from "../http-common";

export default {
  data() {
    return {
      name: "PontepThaweesup",
      tests: [],
      select: undefined
    };
  },
  methods: {
    getAllTests() {
      api
        .get("/tests")
        .then(response => {
          this.tests = response.data;
          console.log("รับข้อมูล test จาก server ได้แบ้วนะ!");
          console.log(JSON.parse(JSON.stringify(response.data)));
        })
        .catch(e => {
          console.log(e);
        });
    }
  },
  mounted() {
    this.getAllTests();
  }
};
</script>