<template>
  <div>
      <el-form
        autocomplete="on"
        :model="loginForm"
        ref="loginForm"
        label-position="left"
      >
        <h2 class="login-title color-main">test</h2>
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
        username: 'admin1111',
        password: '123456657567'
      },
      loading: false,
      pwdType: 'password'
    }
  },
  methods: {
    handleLogin() {
      var username = '1'
      var password = '2'
      this.$axios.post('/user/loginUser', {
        username: username,
        password: password
      }).then((response) => {
        var userMsg = response.data
        switch (userMsg.backInfo) {
          case '1':
            alert('登录成功')
            window.sessionStorage.userMsg = JSON.stringify(userMsg)
            this.$router.push({name: 'ShopIndex'})
            break
          case '2':
            alert('登录失败')
            break
        }
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
