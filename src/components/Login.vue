<template>
  <div>
    <el-input v-model="userName" type="text"  placeholder="用户名" ></el-input>
    <h2>{{userName}}</h2>
    <el-input v-model="password" type="text"  placeholder="密码"></el-input>
      <h2>{{password}}</h2>
    <el-row>
    <el-button type="primary">login</el-button>
    </el-row>
  </div>
</template>

<script>

export default {
  data() {
    return {
      userName: '',
      password: ''
    }
  }
}
</script>
<style>
</style>
