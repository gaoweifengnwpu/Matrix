<template>
  <div>
    <el-input v-model="username" type="text"  placeholder="用户名" ></el-input>
    <h2>{{username}}</h2>
    <el-input v-model="password" type="text"  placeholder="密码"></el-input>
    <h2>{{password}}</h2>
    <el-row>
    <el-button type="primary" @click="requetLogin">login</el-button>
    </el-row>
  </div>
</template>

<script>
import { mapActions } from 'vuex'
export default {
  data() {
    return {
      username: 'username',
      password: '123456'
    }
  },
  methods: {
    ...mapActions([
      'handleLogin',
      'getUserInfo'
    ]),
    login() {
      this.handleLogin(this.data).then(res => {
        this.getUserInfo().then(res => {
          // eslint-disable-next-line standard/object-curly-even-spacing
          this.$router.push({ name: 'Home'})
        })
        // eslint-disable-next-line handle-callback-err
      }).catch(error => {
        console.log(2222)
      })
    }
  }
}
</script>

<style>
</style>
