<template>
  <div id="gwf">
    <h1>{{ msg }}</h1>
    <el-radio v-model="radio" label="1">备选项1</el-radio>
    <el-radio v-model="radio" label="2">备选项2</el-radio>
    <el-input v-model="input" placeholder="请输入内容"></el-input>
    <el-select v-model="value" placeholder="请选择">
      <el-option
        v-for="item in options"
        :key="item.value"
        :label="item.label"
        :value="item.value">
      </el-option>
    </el-select>
    <el-time-picker
      v-model="value1"
      :picker-options="{
      selectableRange: '18:30:00 - 20:30:00'
    }"
      placeholder="任意时间点">
    </el-time-picker>
    <el-time-picker
      arrow-control
      v-model="value2"
      :picker-options="{
      selectableRange: '18:30:00 - 20:30:00'
    }"
      placeholder="任意时间点">
    </el-time-picker>
  </div>
</template>

<script>
export default {
  data() {
    return {
      msg: 'https://element.eleme.cn/#/zh-CN/component/table',
      radio: '1',
      input: '',
      options: [{
        value: '选项1',
        label: '黄金糕'
      }, {
        value: '选项2',
        label: '双皮奶'
      }, {
        value: '选项3',
        label: '蚵仔煎'
      }, {
        value: '选项4',
        label: '龙须面'
      }, {
        value: '选项5',
        label: '北京烤鸭'
      }],
      value: '',
      value1: new Date(2016, 9, 10, 18, 40),
      value2: new Date(2016, 9, 10, 18, 40)
    }
  }
}
</script>
<style>
  #gwf {
    height: 800px;
    width: 900px;
    background: antiquewhite;
  }
</style>
