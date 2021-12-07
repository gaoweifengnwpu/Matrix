// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import router from './router'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import App from './App'
import './style/theme.css'
import './style/character.css'
import qs from 'qs'
import axios from "axios";
// 全局注册，使用方法为：this.$axios
Vue.prototype.$axios = axios

// axios 配置

axios.defaults.timeout = 5000;

// axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded;charset=UTF-8';
// 实例对象
let instance = axios.create({
  timeout: 6000,
  headers: {
    'Content-Type': 'application/x-www-form-urlencoded'
  }
})

// 请求拦截器
instance.interceptors.request.use(
  config => {
    config.data = qs.stringify(config.data) // 转为formdata数据格式
    return config
  },
  error => Promise.error(error)
)
//收不到数据
// axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';
// Vue.prototype.$axios = axios;
//收不到数据
// axios.defaults.headers.post['Content-Type'] = 'json';

// axios.defaults.baseURL = 'http://localhost:8080/项目名/';

// axios.defaults.baseURL = 'http://192.73.1.15:8080/';
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
