<template>
  <v-app id="keep">
    <v-navigation-drawer v-model="drawer" app>
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
        <v-list-item @click="goShowManagement">
          <v-list-item-action>
            <v-icon light>mdi-wrench</v-icon>
          </v-list-item-action>
          <v-list-item-content>
            <v-list-item-title>จัดการการแสดง</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
        <v-list-item @click="goShowScheduleManagement">
          <v-list-item-action>
            <v-icon light>mdi-wrench</v-icon>
          </v-list-item-action>
          <v-list-item-content>
            <v-list-item-title>จัดการรอบการแสดง</v-list-item-title>
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

    <v-app-bar app color="amber" light>
      <v-app-bar-nav-icon @click.stop="drawer = !drawer"></v-app-bar-nav-icon>
      <v-toolbar-title>
        <v-icon light>mdi-account</v-icon>
        <span class="title ml-3 mr-5">Employee&nbsp;<span class="font-weight-light">: {{ employee.name }}</span></span>
        
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
            <template v-else-if="content === 'showScheduleManagement'">
              <ShowScheduleManagement :employee="employee" />
            </template>
          </v-col>
        </v-row>
      </v-container>
    </v-content>
    <v-footer color="amber" app>
      <span class="white--text">&copy; 2019</span>
    </v-footer>
  </v-app>
</template>

<script>
import api from "../http-common";
import EmployeeHomeContent from "./EmployeeHomeContent";
import ShowScheduleManagement from "./ShowScheduleManagement";
import ShowManangement from "./ShowManangement";
export default {
  components: {
    EmployeeHomeContent,
    ShowManangement,
    ShowScheduleManagement
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
    logout() {
      if (confirm("Are you sure want to logout?")) {
        this.$router.push("/");
      } else {
      }
    },
    goShowManagement() {
      // this.$router.push("/ticketbooking/"+this.customer.id);
      this.content = "showManagement";
      this.drawer = false;
    },
    goShowScheduleManagement() {
      // this.$router.push("/ticketbooking/"+this.customer.id);
      this.content = "showScheduleManagement";
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