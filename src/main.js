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
Vue.config.productionTip = false
Axios.defaults.baseURL = 'http://www.wwtliu.com'
// Axios.defaults.headers.common['Authorization'] = AUTH_TOKEN
Axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded'
// 添加请求拦截器
Axios.interceptors.request.use(function (config) {
  // 在发送请求之前做些什么
  // console.log('request', config)
  if (config.method === 'post') {
    config.data = qs.stringify(config.data)
  }
  return config
}, function (error) {
  // 对请求错误做些什么
  return Promise.reject(error)
})

// 添加响应拦截器
Axios.interceptors.response.use(function (response) {
  // 对响应数据做点什么
  // console.log('response', response)
  return response
}, function (error) {
  // 对响应错误做点什么
  return Promise.reject(error)
})
// eslint-disable-next-line no-new
new Vue({
  el: '#app1',
  router,
  components: { App },
  template: '<App/>'
})
