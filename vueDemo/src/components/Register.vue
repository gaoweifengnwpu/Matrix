<template>
  <div>
      <el-form
        autocomplete="on"
        :model="registerForm"
        ref="registerForm"
        label-position="left"
      >
        <h2 class="login-title color-main">Register</h2>
        <el-form-item prop="username">
          <el-input
            name="username"
            type="text"
            v-model="registerForm.username"
            autocomplete="on"
            placeholder="请输入用户名"
          >
            <span slot="prefix">
              <svg-icon icon-class="user" class="color-main"></svg-icon>
            </span>
          </el-input>
        </el-form-item>
        <el-form-item prop="password">
          <el-input
            name="password"
            type="text"
            v-model="registerForm.password"
            autocomplete="on"
            placeholder="请输入密码"
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
            @click.native.prevent="handleRegister"
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
      registerForm: {
        username: '输入账号',
        password: '输入密码'
      },
      loading: false,
      pwdType: 'password'
    }
  },
  methods: {
    handleRegister() {
      var username = this.registerForm.username
      var password = this.registerForm.password
      // alert(password)
      var dt = { username:username,password:password }
      this.$axios.post(
        this.$api+'/register', this.qs.stringify(dt)).then((response) => {
        var userMsg = response.data
        alert(userMsg)
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
