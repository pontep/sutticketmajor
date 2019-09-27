import Vue from 'vue'
import Router from 'vue-router';
import ShowScheduleManagement from '../components/ShowScheduleManagement';
//import HelloWorld from '../components/HelloWorld';

Vue.use(Router);

export default new Router({
    mode: 'history',
    base: process.env.BASE_URL,
    routes: [{
            path: '/showschedule',
            name: 'showschedule',
            component: ShowScheduleManagement
        }
    ]
});