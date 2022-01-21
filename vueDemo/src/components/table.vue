<template>
  <div>
    <!--    <h2 class="login-title">用户列表</h2>-->
    <!--    分页实现方式-->
    <!--    https://blog.csdn.net/HH18700418030/article/details/99311018-->

    <el-table
      v-loading="loading"
      element-loading-text="拼命加载中"
      element-loading-spinner="el-icon-loading"
      element-loading-background="rgba(0, 0, 0, 0.8)"
      :height="Height"
      stripe
      border
      :cell-style="{ textAlign: 'center',fontFamily:'Arial',fontSize:'20px'}"
      :data="tableData"
      style="width: 100%"
      :header-cell-style="{
    background: '#edeaee',
    textAlign: 'center',
    fontFamily:'Arial',
    fontSize:'20px'
      }"
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
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page="currentPage"
        :page-sizes="[2, 4, 6, 8]"
        :page-size="size"
        layout="total, sizes, prev, pager, next, jumper"
        :total="total"
        @prev-click="pre"
        @next-click="next">
      </el-pagination>
    </div>
    <!--      layout，表示需要显示的内容，用逗号分隔，布局元素会依次显示。-->
    <!--      prev表示上一页，next为下一页，pager表示页码列表。-->
    <!--      特殊的布局符号->：->后的元素会靠右显示。-->
    <!--      jumper表示跳页元素。-->
    <!--      total表示显示页码总数，size用于设置每页显示的页码数量。-->
  </div>

</template>
<script>
export default {
  data() {
    return {
      tableData: [],
      // 总条数
      total: 0,
      // 默认每页数据量
      size: 2,
      // 默认显示第一页
      currentPage: 1
    }
  },
  created: function () {
    this.getTableData()
  },
  methods: {
    getTableData: function () {
      var _this = this
      this.$axios.get(this.$api +
        '/findPage', {
        params: {
          pageSize: this.size,
          pageNum: this.currentPage
        }
      }).then(response => {
        // json对象转化成json字符串
        // var jsonData = JSON.stringify(response.data, ['pageNum'])
        console.log(JSON.stringify(response.data))
        var jsonData = JSON.stringify(response.data.content)
        // 获取总页数
        this.total = response.data.totalSize
        // alert(this.total)
        // json字符串转成JSON对象
        var obj = JSON.parse(jsonData)
        _this.tableData = obj
        console.log(obj)
      })
    },
    handleSizeChange(val) {
      this.size = val //改变每页显示的条数
      this.currentPage = 1//改变size时,页码跳到第一页
      this.getTableData()//重新请求数据
      console.log('每页${val}条')
    },
    handleCurrentChange(val) {
      this.currentPage = val       //改变默认的页数
      this.getTableData() //重新请求数据
      console.log('当前${val}页')
    },
    pre(cpage) {
      console.log(cpage)
      // this.currentPage = cpage
      // this.getTableData() //重新请求数据
    },
    next(cpage) {
      console.log(cpage)
      // this.currentPage = cpage
      // this.getTableData() //重新请求数据
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

<style scoped>
  .login-title {
    text-align: center;
  }
</style>
