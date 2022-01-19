<template>
  <div>
    <el-table
      stripe
      border
      :height="Height"
      :cell-style="{ textAlign: 'center',fontFamily:'Arial',fontSize:'20px'}"
      :data="tableData"
      style="width: 100%"
      :header-cell-style="{
    background: '#56ef1f',
    textAlign: 'center',
    fontFamily:'Arial',
    fontSize:'20px'}"
    >
      <el-table-column
        prop="id"
        label="id">
      </el-table-column>
      <el-table-column
        prop="name"
        label="用户名"
      >
      </el-table-column>
      <el-table-column
        prop="password"
        label="密码"
      >
      </el-table-column>
    </el-table>
    <div>
      <el-pagination
        background
        layout="prev, pager, next"
        :total="1000">
      </el-pagination>
    </div>
  </div>
</template>
<script>
export default {
  data() {
    return {
      tableData: []
    }
  },
  created: function () {
    this.getTableData()
  },
  methods: {
    getTableData: function () {
      var _this = this
      this.$axios.get(this.$api +
        '/findUsers').then(response => {
        // json对象转化成json字符串
        var jsonData = JSON.stringify(response.data)
        // json字符串转成JSON对象
        var obj = JSON.parse(jsonData)
        _this.tableData = obj
        //
        console.log(obj)
        // let arr1 = []
        // for (let i in obj) {
        //   arr1.push(obj[i])
        // }
        // this.tableData = response.data
        // console.log(arr1)
        // json对象转化成json数组对象
      })
    }
    // stateFormat(row, column) {
    //   if (row.state === true) {
    //     return '正确'
    //   } else {
    //     return '错误'
    //   }
    // }
  }
}
</script>
<!--get和post请求方式-->
<!--https://segmentfault.com/a/1190000016653561?utm_source=tag-newest-->
<!--<style lang="scss" scoped>-->
<!--  /deep/ {-->
<!--    //修改表头的背景颜色横向渐变色-->
<!--    .el-table {-->
<!--      thead {-->
<!--        color: #fff;-->
<!--        font-weight: 500;-->
<!--        background: linear-gradient(to right, #6fa3fe, #4cdafe) !important;-->
<!--        & th {-->
<!--          //inherit：规定应该从父元素继承 background-color 属性的设置。-->
<!--          //transparent：默认。背景颜色为透明。-->
<!--          // background-color: inherit !important;-->
<!--          background-color: transparent;-->
<!--        }-->
<!--        & tr {-->
<!--          // background-color: inherit !important;-->
<!--          background-color: transparent;-->
<!--        }-->
<!--      }-->
<!--    }-->
<!--  }-->
<!--</style>-->
