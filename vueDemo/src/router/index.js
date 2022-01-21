import Vue from 'vue'
import Router from 'vue-router'
import Login from '../components/Login'
import HelloWorld from '../components/HelloWorld'
import Register from '../components/Register'
import FileUpload from '../components/FileUpload'
import Index from '../components/Index'
import table from '../components/table'
import a from '../components/a'
import b from '../components/b'
import c from '../components/c'

let commonUrl = 'http://192.168.2.3:8082'
Vue.prototype.$api = commonUrl
// Vue全局使用Router
Vue.use(Router)
// http://192.168.2.2:8080/#/login
export default new Router({
  routes: [
    {
      path: '/',
      name: 'login',
      components: {

        default: Login
      }
    },
    {
      path: '/user',
      name: 'table',
      components: {
        default: table
      }
    },
    {
      path: '/register',
      name: 'register',
      components: {
        default: Register
      }
    },
    {
      path: '/FileUpload',
      name: 'FileUpload',
      components: {
        default: FileUpload
      }
    },
    {
      path: '/c',
      name: 'c',
      components: {
        default: table
      }
    },
    {
      path: '/index',
      name: 'index',
      components: {
        default: Index
      },
      children:
        [
          {
            path: 'a',
            name: 'a',
            component: table
          },
          {
            path: 'b',
            name: 'b',
            component: FileUpload
          }
        ]
    }
  ]
})
// mode: 'history', //路由模式，取值为history与hash
//   base: '/', //打包路径，默认为/，可以修改
//   routes: [
//   {
//     path: string, //路径
//     ccomponent: Component; //页面组件
//     name: string; // 命名路由-路由名称
//     components: { [name: string]: Component }; // 命名视图组件
// redirect: string | Location | Function; // 重定向
// props: boolean | string | Function; // 路由组件传递参数
// alias: string | Array<string>; // 路由别名
// children: Array<RouteConfig>; // 嵌套子路由
// beforeEnter?: (to: Route, from: Route, next: Function) => void; // 路由单独钩子
// meta: any; // 自定义标签属性，比如：是否需要登录
// icon: any; // 图标
// // 2.6.0+
// caseSensitive: boolean; // 匹配规则是否大小写敏感？(默认值：false)
// pathToRegexpOptions: Object; // 编译正则的选项
// }
// ]
