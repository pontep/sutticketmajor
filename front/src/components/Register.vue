<template>
  <v-app id="inspire">
    <v-content>
      <v-container class="fill-height" fluid>
        <v-row align="center" justify="center">
          <v-col cols="12" sm="8" md="4">
            <v-card class="elevation-12">
              <v-toolbar color="primary" dark flat>
                <v-toolbar-title>Register form</v-toolbar-title>
                <div class="flex-grow-1"></div>
              </v-toolbar>
              <v-card-text>
                <v-text-field
                prepend-icon="arrow_right_alt"
                  v-model="EnterName"
                  :items="name"
                  item-text="name"
                  item-value="id"
                  label="Fill out the name"
                ></v-text-field>
                <v-text-field label="Username" name="login" prepend-icon="person" type="text"></v-text-field>
                <v-text-field
                  id="password"
                  label="Password"
                  name="password"
                  prepend-icon="lock"
                  type="password"
                ></v-text-field>
                <v-select
                prepend-icon="arrow_right_alt"
                  v-model="selectedsex"
                  :items="Sex"
                  item-text="sex"
                  item-value="id"
                  label="Select Sex"
                ></v-select>

                <v-select
                  prepend-icon="arrow_right_alt"
                  v-model="selectedRangeAge"
                  :items="RangeAge"
                  item-text="rangeages"
                  item-value="id"
                  label="Select Range Age"
                ></v-select>

                <v-select
                prepend-icon="arrow_right_alt"
                  v-model="selectedCarrer"
                  :items="Carrer"
                  item-text="name"
                  item-value="id"
                  label="select Carrer"
                ></v-select>
              </v-card-text>
              <v-card-actions>
                <div class="flex-grow-1"></div>

                <v-btn color="success" router-link to="/register">Register</v-btn>
                <v-btn color="secondary" router-link to="/">Back</v-btn>
              </v-card-actions>
            </v-card>
          </v-col>
        </v-row>
      </v-container>
    </v-content>
  </v-app>
</template>

<script>
export default {
  props: {
    source: String
  },
  data: () => ({
    drawer: null
  })
};
</script>