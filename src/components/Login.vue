<template>
  <div>
    <el-input v-model="username" type="text"  placeholder="用户名" ></el-input>
    <h2>{{username}}</h2>
    <el-input v-model="password" type="text"  placeholder="密码"></el-input>
    <h2>{{password}}</h2>
    <el-row>
    <el-button type="primary"  onclick="say('hi')">login</el-button>
    </el-row>
  </div>
</template>

<script>
export default {
  data() {
    return {
      username: '',
      password: ''
    }
  }
}
</script>
<style>
</style>
