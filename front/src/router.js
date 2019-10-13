import Vue from 'vue'
import Router from 'vue-router'
import CustomerLogin from './components/CustomerLogin'
import Register from './components/Register'
import CustomerHome from './components/CustomerHome'
import TicketBooking from './components/TicketBooking'
import EmployeeLogin from './components/EmployeeLogin'
import EmployeeHome from './components/EmployeeHome'
Vue.use(Router)

export default new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'CustomerLogin',
      component: CustomerLogin
    },
    {
      path: '/employeelogin',
      name: 'EmployeeLogin',
      component: EmployeeLogin
    },
    {
      path: '/employeehome/:employeeId',
      name: 'EmployeeHome',
      component: EmployeeHome
    },
    {
      path: '/register',
      name: 'register',
      component: Register
    },
    {
      path: '/customerhome/:customerId',
      name: 'CustomerHome',
      component: CustomerHome
    },
    {
      path: '/ticketbooking',
      name: 'TicketBooking',
      component: TicketBooking
    }
  ]
})
