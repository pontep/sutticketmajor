<template>
  <v-app id="keep">
    <v-navigation-drawer v-model="drawer" app temporary>
      <v-list dense>
        <v-list-item @click="goEmployeeHome">
          <v-list-item-action>
            <v-icon>mdi-home</v-icon>
          </v-list-item-action>
          <v-list-item-content>
            <v-list-item-title>Home</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
        <v-divider inset></v-divider>
        
        <v-list-item @click="goReceipt">
          <v-list-item-action>
            <v-icon light>mdi-paper-roll</v-icon>
          </v-list-item-action>
          <v-list-item-content>
            <v-list-item-title>พิมพ์ใบเสร็จ</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
        <v-divider inset></v-divider>
        <v-list-item @click="goShowManagement">
          <v-list-item-action>
            <v-icon light>mdi-wrench</v-icon>
          </v-list-item-action>
          <v-list-item-content>
            <v-list-item-title>จัดการการแสดง</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
        <v-list-item @click="goManageShowSchedule">
          <v-list-item-action>
            <v-icon light>mdi-wrench</v-icon>
          </v-list-item-action>
          <v-list-item-content>
            <v-list-item-title>จัดการรอบการแสดง</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
        
        <v-divider inset></v-divider>
        <v-list-item @click="goShowManagementData">
          <v-list-item-action>
            <v-icon light>mdi-eye</v-icon>
          </v-list-item-action>
          <v-list-item-content>
            <v-list-item-title>การแสดงทั้งหมด</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
        <v-list-item @click="goShowScheduleData">
          <v-list-item-action>
            <v-icon light>mdi-eye</v-icon>
          </v-list-item-action>
          <v-list-item-content>
            <v-list-item-title>รอบการแสดงทั้งหมด</v-list-item-title>
          </v-list-item-content>
        </v-list-item>

        <v-divider inset></v-divider>

        <v-list-item @click="logout">
          <v-list-item-action>
            <v-icon light>mdi-logout</v-icon>
          </v-list-item-action>
          <v-list-item-content>
            <v-list-item-title>ออกจากระบบ</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </v-list>
    </v-navigation-drawer>

    <v-app-bar app color="amber" light clipped-left>
      <v-app-bar-nav-icon @click.stop="drawer = !drawer"></v-app-bar-nav-icon>
      <v-toolbar-title>
        <v-icon light>mdi-account</v-icon>
        <span class="title ml-3 mr-5">
          Employee&nbsp;
          <span class="font-weight-light">: {{ employee.name }}</span>
        </span>
      </v-toolbar-title>
    </v-app-bar>

    <v-content>
      <v-container class="fill-height" fluid>
        <v-row align="center" justify="center">
          <v-col class="text-center">
            <template v-if="content === 'employeehome'">
              <EmployeeHomeContent :employee="employee" />
            </template>
            <template v-else-if="content === 'showManagement'">
              <ShowManangement :employee="employee" />
            </template>
            <template v-else-if="content === 'manageShowSchedule'">
              <ManageShowSchedule :employee="employee" />
            </template>
            <template v-else-if="content === 'receipt'">
              <Receipt :employee="employee" />
            </template>
            <template v-else-if="content === 'showManagementData'">
              <ShowManagementData :employee="employee" />
            </template>
            <template v-else-if="content === 'showScheduleData'">
              <ShowScheduleData :employee="employee" />
            </template>
          </v-col>
        </v-row>
      </v-container>
    </v-content>
    <v-footer color="amber" app>
      <span
        class="white--text"
      >523331 SYSTEM ANALYSIS AND DESIGN 1/2562 Sec3 Group 25 ระบบจองตั๋วการแสดง &copy; 2019</span>
    </v-footer>
  </v-app>
</template>

<script>
import api from "../http-common";
import EmployeeHomeContent from "./EmployeeHomeContent";
import ManageShowSchedule from "./ManageShowSchedule";
import ShowManangement from "./ShowManangement";
import ShowScheduleData from "./ShowScheduleData";
import ShowManagementData from "./ShowManagementData";
import Receipt from "./Receipt";

export default {
  components: {
    ShowScheduleData,
    ShowManagementData,
    Receipt,
    EmployeeHomeContent,
    ShowManangement,
    ManageShowSchedule
  },
  mounted() {
    this.employee.id = this.$route.params.employeeId;
    this.getEmployee();
  },
  props: {
    source: String
  },
  data: () => ({
    drawer: null,
    employee: {},
    content: "employeehome"
  }),
  methods: {
    goReceipt() {
      this.content = "receipt";
      this.drawer = false;
    },
    logout() {
      if (confirm("Are you sure want to logout?")) {
        this.$router.push("/");
      } else {
      }
    },
    goShowScheduleData() {
      this.content = "showScheduleData";
      this.drawer = false;
    },
    goShowManagement() {
      // this.$router.push("/ticketbooking/"+this.customer.id);
      this.content = "showManagement";
      this.drawer = false;
    },
    goShowManagementData() {
      // this.$router.push("/ticketbooking/"+this.customer.id);
      this.content = "showManagementData";
      this.drawer = false;
    },
    goManageShowSchedule() {
      // this.$router.push("/ticketbooking/"+this.customer.id);
      this.content = "manageShowSchedule";
      this.drawer = false;
    },
    goEmployeeHome() {
      this.content = "employeehome";
      this.drawer = false;
    },
    getEmployee() {
      api
        .get("/employee/" + this.employee.id)
        .then(res => {
          this.employee = res.data;
        })
        .catch(e => {
          console.log(e);
        });
    }
  }
};
</script>
