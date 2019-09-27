import Vue from 'vue'
import Router from 'vue-router';
import ShowManagementData from '../components/ShowManagementData';
import ShowManangement from '../components/ShowManangement';
Vue.use(Router)

export default new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      component: ShowManangement
    },
    {
      path: '/view',
      component: ShowManagementData
      
    }
  ]
});
