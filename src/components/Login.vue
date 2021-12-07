<template>
  <div>
      <el-form
        autocomplete="on"
        :model="loginForm"
        ref="loginForm"
        label-position="left"
      >
        <h2 class="login-title color-main">login</h2>
        <el-form-item prop="username">
          <el-input
            name="username"
            type="text"
            v-model="loginForm.username"
            autocomplete="on"
            placeholder="请输入用户名"
          >
            <span slot="prefix">
              <svg-icon icon-class="user" class="color-main"></svg-icon>
            </span>
          </el-input>
        </el-form-item>
        <el-form-item style="margin-bottom: 60px">
          <el-button
            style="width: 100%"
            type="primary"
            :loading="loading"
            @click.native.prevent="handleLogin"
          >登录</el-button>
        </el-form-item>
      </el-form>
  </div>
</template>

<script>
export default {
  name: 'login',
  data() {
    return {
      loginForm: {
        username: '1',
        password: '1'
      },
      loading: false,
      pwdType: 'password'
    }
  },
  methods: {
    handleLogin() {
      var username = '1'
      var password = '1'
      this.$axios.post('http://192.73.1.15:8082/loginIn', {
         username:username,
         password:password,
        headers: {
          "Content-Type": "application/x-www-form-urlencoded"
        }
      }).then((response) => {
        var userMsg = response.data
        // alert(userMsg)
      })
    }
  }
}
</script>

<style scoped>
  .login-form-layout {
    position: absolute;
    left: 0;
    right: 0;
    width: 360px;
    margin: 140px auto;
    border-top: 10px solid #409eff;
  }

  .login-title {
    text-align: center;
  }

  .login-center-layout {
    background: #409eff;
    width: auto;
    height: auto;
    max-width: 100%;
    max-height: 100%;
    margin-top: 200px;
  }
</style>
