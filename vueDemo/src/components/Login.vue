<template>
  <div class="login-wrap">
    <el-form
      autocomplete="on"
      :model="loginForm"
      ref="loginForm"
      label-position="left"
      :rules="rules"
    >
      <h2 class="login-title">login</h2>
      <el-form-item prop="username">
        <el-input
          name="username"
          type="text"
          v-model="loginForm.username"
          autocomplete="on"
          placeholder="请输入用户名"
          maxlength="10"
          show-word-limit
          clearable
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
          v-model="loginForm.password"
          autocomplete="on"
          placeholder="请输入密码"
          show-password
          maxlength="10"
          show-word-limit
          clearable
        >
            <span slot="prefix">
              <svg-icon icon-class="user" class="color-main"></svg-icon>
            </span>
        </el-input>
      </el-form-item>
      <el-form-item style="margin-bottom: 10px">
        <el-button
          style="width: 100%"
          type="primary"
          :loading="loading"
          @click.native.prevent="handleLogin"
        >登录
        </el-button>
      </el-form-item>
      <el-form-item>
        <el-button
          style="width: 100%"
          type="primary"
          :loading="loading"
          @click.native.prevent="goTo"
        >注册
        </el-button>
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
        username: '',
        password: ''
      },
      loading: false,
      pwdType: 'password',
      rules: {
        username: [
          {required: true, message: '请输入用户名', trigger: 'blur'}
        ],
        password: [{required: true, message: '请输入密码', trigger: 'blur'}]
      }
    }
  },
  methods: {
    handleLogin() {
      var username = this.loginForm.username
      var password = this.loginForm.password
      // alert(password)
      var dt = {username: username, password: password}
      this.$axios.post(this.$api +
        '/loginIn', this.qs.stringify(dt)).then((response) => {
        var userMsg = response.data
        if (response.data == 'login success') {
          this.$router.push('/index')
        } else {
          this.open4()
        }
      })
    },
    goTo() {
      this.$router.push('/register')
    },
    open4() {
      this.$notify.error({
        title: '错误',
        position: 'top-left',
        message: '用户名或密码错误'
      })
    }
  }
}
</script>

<style scoped>
  .login-wrap {
    position: relative;
    background-attachment: fixed;
    background-position: center;
    background-size: cover;
    width: 100%;
    height: 100%;
    background: #f1e3e9;
  }

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
    background: #cd1d69;
    width: auto;
    height: auto;
    max-width: 100%;
    max-height: 100%;
    margin-top: 200px;
  }
</style>
<!--<template>-->
<!--  <div id='test'>-->
<!--    <button @click='goTo()'>点击跳转4</button>-->
<!--  </div>-->
<!--</template>-->
<!--<script>-->
<!--export default {-->
<!--  name: 'test',-->
<!--  methods: {-->
<!--    goTo() {-->
<!--      //直接跳转-->
<!--      this.$router.push('/testDemo')-->

<!--      //带参数跳转-->
<!--      this.$router.push({path: '/testDemo', query: {setid: 123456}})-->
<!--      this.$router.push({name: 'testDemo', params: {setid: 111222}})-->
<!--    }-->
<!--  }-->
<!--}-->
<!--</script>-->
