<template>
  <v-form ref="form">
    <v-container class="grey lighten-5">
      <v-row no-gutters align="center" justify="center">
        <v-col cols="12" md="6">
          <v-card class="pa-2" outlined tile>
            
            <h1 class="text-center pink--text">Show Management</h1>

            <v-select
              v-model="selectedEmployee"
              :items="employees"
              item-text="employee_name"
              item-value="id"
              label="เลือกชื่อผู้จัดการ"
              :rules="[(v) => !!v || 'กรุณาเลือกชื่อผู้จัดการ']"
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
             v-model="selectedTypeShow"
              :items="types"
              item-text="type"
              item-value="id"
              label="เลือกประเภทการแสดง"
              :rules="[(v) => !!v || 'กรุณาเลือกประเภทการแสดง']"
              required
            ></v-select>

            <v-select
              v-model="selectedRatingShow"
              :items="ratings"
              item-text="rate"
              item-value="id"
              label="เลือกเรทของการแสดง"
              :rules="[(v) => !!v || 'กรุณาเลือกเรทของการแสดง']"
              required
            ></v-select>

            <div class="text-center">
              <v-btn color="warning" class="mr-3" @click="Saveshow">บันทึก</v-btn>
              <v-btn color="warning" class="mr-3" @click="Resetshow">ยกเลิก</v-btn>
            </div>
          </v-card>
        </v-col>
      </v-row>
    </v-container>
  </v-form>
</template>



  <script>
import api from "../api.js";
export default {
  data() {
    return {
      insertShowName: undefined,
      selectedEmployee: null,
      selectedTypeShow: null,
      selectedRatingShow: null,
      titles: [],
      employees: [],
      types: [],
      ratings: [],
    };
  },
  mounted() {
    //ประกาศฟังก์ชันที่ต้องการดึงข้อมูลจากหลังบ้านมาแสดงใน combobox แต่ละตัว
    this.getAllEmployees();
    this.getAllTypeShows();
    this.getAllRatingShows();
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
        !this.selectedTypeShow ||
        !this.selectedRatingShow
      ) {
        alert("กรุณากรอกข้อมูลให้ครบ!");
      } else {
        this.SaveShowManagement();
      }
    },

    SaveShowManagement() {
      const bag ={
        title: this.insertShowName
      }
      api
        .post(
          "/show/" +
            this.selectedEmployee +
            "/" +
            this.selectedTypeShow+
            "/" +
            this.selectedRatingShow,bag
        )
        .then(response => {
          alert("บันทึกข้อมูลสำเร็จ!");
          console.log(JSON.parse(JSON.stringify(response.data)));
          this.$refs.form.reset();
          this.$router.push("/view");
        })
        .catch(e => {
          console.log(e);
        });
    },

    getAllEmployees() {
      api
        .get("/Employees")
        .then(response => {
          this.employees = response.data;
          console.log("ดึงข้อมู Customer");
          console.log(JSON.parse(JSON.stringify(response.data)));
        })
        .catch(e => {
          console.log(e);
        });
    },

    getAllTypeShows() {
      api
        .get("/typeShows")
        .then(response => {
          this.types = response.data;
          console.log("เพิ่มข้อมูล Type แล้ว");
          console.log(JSON.parse(JSON.stringify(response.data)));
        })
        .catch(e => {
          console.log(e);
        });
    },

    getAllRatingShows() {
      api
        .get("/ratingShows")
        .then(response => {
          this.ratings = response.data;
          console.log("ดึงข้อมูล Rating สำเร็จ");
          console.log(JSON.parse(JSON.stringify(response.data)));
        })
        .catch(e => {
          console.log(e);
        });
    }
  },

};
</script>