// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import router from './router'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import App from './App'
import './style/theme.css'
import './style/character.css'
import Axios from 'axios'
import qs from 'qs'
// 全局注册，使用方法为：this.$axios
Vue.prototype.$axios = Axios
// 全局注册，使用方法为：this.qs
Vue.prototype.qs = qs
// 注册element-ui
Vue.use(ElementUI)

new Vue({
  el: '#app1',
  router,
  components: { App },
  template: '<App/>'
})
