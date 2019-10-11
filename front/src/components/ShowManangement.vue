<template>
  <v-content>
    <v-container class="fill-height" fluid>
      <v-row align="center" justify="center">
        <v-col cols="12" sm="8" md="9">
          <v-card class="elevation-12">
            <v-toolbar color="amber" light flat>
              <v-icon>mdi-wrench</v-icon>&nbsp;&nbsp;
              <v-toolbar-title>จัดการการแสดง</v-toolbar-title>
              <div class="flex-grow-1"></div>
            </v-toolbar>
            <v-card-text>
              <v-select
                v-model="selectedEmployee"
                :items="employees"
                item-text="name"
                item-value="id"
                label="เลือกชื่อพนักงาน"
                :rules="[(v) => !!v || 'กรุณาเลือกชื่อพนักงาน']"
                required
              ></v-select>

              <v-text-field
                v-model="insertShowName"
                :items="titles"
                item-text="name"
                item-value="id"
                label="กรอกชื่อการแสดง"
                :rules="[(v) => !!v || 'กรุณากรอกชื่อการแสดง']"
                required
              ></v-text-field>
              <v-select
                v-model="selectedShowType"
                :items="types"
                item-text="type"
                item-value="id"
                label="เลือกประเภทการแสดง"
                :rules="[(v) => !!v || 'กรุณาเลือกประเภทการแสดง']"
                required
              ></v-select>

              <v-select
                v-model="selectedShowRating"
                :items="ratings"
                item-text="rate"
                item-value="id"
                label="เลือกเรทของการแสดง"
                :rules="[(v) => !!v || 'กรุณาเลือกเรทของการแสดง']"
                required
              ></v-select>

              <div class="text-center">
                <v-btn class="mr-3" color="warning" @click="Saveshow">บันทึก</v-btn>
              </div>
            </v-card-text>
          </v-card>
        </v-col>
      </v-row>
    </v-container>
  </v-content>
</template>



  <script>
import api from "../http-common.js";
export default {
  props: {
    employee: {}
  },
  data() {
    return {
      insertShowName: undefined,
      selectedEmployee: null,
      selectedShowType: null,
      selectedShowRating: null,
      titles: [],
      employees: [],
      types: [],
      ratings: []
    };
  },
  mounted() {
    //ประกาศฟังก์ชันที่ต้องการดึงข้อมูลจากหลังบ้านมาแสดงใน combobox แต่ละตัว
    this.getAllEmployees();
    this.getAllShowTypes();
    this.getAllShowRatings();
  },
  methods: {
    Resetshow() {
      this.$refs.form.reset();
    },
    Saveshow() {
      //เมือกดปุ่มบันทึก ขณะที่ยังกรอกข้อมูลไม่ครบ ระบบจะแจ้งเตื่อน "กรุณากรอรกข้อมูลให้ครบ"
      if (
        !this.insertShowName ||
        !this.selectedEmployee ||
        !this.selectedShowType ||
        !this.selectedShowRating
      ) {
        alert("กรุณากรอกข้อมูลให้ครบ!");
      } else {
        this.SaveShowManagement();
      }
    },

    SaveShowManagement() {
      // const bag ={
      //   title: this.insertShowName
      // }
      api
        .post(
          "/show2/" +
            this.selectedEmployee +
            "/" +
            this.selectedShowType +
            "/" +
            this.selectedShowRating +
            "/" +
            this.insertShowName
        )
        .then(response => {
          alert("บันทึกข้อมูลสำเร็จ!");
          console.log(JSON.parse(JSON.stringify(response.data)));
          this.$refs.form.reset();
          // this.$router.push("/view");
        })
        .catch(e => {
          console.log(e);
        });
    },

    getAllEmployees() {
      api
        .get("/employee/" + this.employee.id)
        .then(response => {
          this.employees = response.data;
          console.log("ดึงข้อมูล Employee สำเร็จ");
          console.log(JSON.parse(JSON.stringify(response.data)));
        })
        .catch(e => {
          console.log(e);
        });
    },

    getAllShowTypes() {
      api
        .get("/Showtypes")
        .then(response => {
          this.types = response.data;
          console.log("เพิ่มข้อมูล Type แล้ว");
          console.log(JSON.parse(JSON.stringify(response.data)));
        })
        .catch(e => {
          console.log(e);
        });
    },

    getAllShowRatings() {
      api
        .get("/Showratings")
        .then(response => {
          this.ratings = response.data;
          console.log("ดึงข้อมูล Rating สำเร็จ");
          console.log(JSON.parse(JSON.stringify(response.data)));
        })
        .catch(e => {
          console.log(e);
        });
    }
  }
};
</script>