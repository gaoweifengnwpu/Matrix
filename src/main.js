// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import router from './router'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import App from './App'
import './style/theme.css'
import './style/character.css'
import axios from 'axios'
import QS from 'qs'
// 注册element-ui
Vue.use(ElementUI)
// 引入axios，并加到原型链中
Vue.prototype.$axios = axios
Vue.prototype.qs = QS
Vue.config.productionTip = false
// eslint-disable-next-line no-new
new Vue({
  el: '#app1',
  router,
  components: { App },
  template: '<App/>'
})
