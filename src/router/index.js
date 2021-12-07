import Vue from 'vue'
import Router from 'vue-router'
import Login from '../components/Login'
import error from '../components/error'
import success from '../components/success'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/1',
      name: 'success',
      component: success
    },
    {
      path: '/',
      name: 'login',
      component: Login
    },
    {
      path: '/2',
      name: 'error',
      component: error
    }
  ]
})
