<template>
  <div>
    <div style="display: flex;justify-content: space-between">
      <div>
        <el-input
          placeholder="根据顾客-名或会员号或手机号搜索，可以直接回车搜索..."
          prefix-icon="el-icon-search"
          :clearable="true"
          style="width: 350px;margin-right: 10px"
          @clear="listTopUp"
          v-model="keyWord"
          @keydown.enter.native="listTopUp"
         
        ></el-input>
        <el-button icon="el-icon-search" type="primary" @click="fuzzyQuery">搜索</el-button>
      </div>
    </div>
    <div style="margin-top:10px">
      <el-table
        :data="tableData"
        element-loading-text="正在加载..."
        element-loading-spinner="el-icon-loading"
        element-loading-background="rgba(0, 0, 0, 0.8)"
        style="width: 100%"
        border
        highlight-current-row:true
      >
        <el-table-column prop="customer.cusName" label="顾客姓名" width="100px"></el-table-column>
        <el-table-column prop="customer.cusPhone" label="顾客电话" width="100px"></el-table-column>
        <el-table-column prop="member.memberNum" label="会员号" width="100px"></el-table-column>
        <el-table-column prop="topupTime" label="充值时间" width="180px"></el-table-column>
        <el-table-column prop="topupMoney" label="充值金额" width="100px"></el-table-column>
      </el-table>
    </div>
    <!-- 分页的组件 -->
    <div style="display: flex;justify-content: flex-end;margin-top:20px">
      <el-pagination
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :background="true"
        :page-sizes="[10, 20, 30, 40]"
        :page-size="pageSize"
        layout="total, sizes, prev, pager, next, jumper"
        :total="total"
      ></el-pagination>
    </div>
  </div>
</template>

<script>
export default {
  name: "SalSearch",
  data() {
    return {
      // 接受后台返回的工资集合
      tableData: [],
      //总条数
      total: 0,
      //每页的条数
      pageSize: 10,
      //默认当前页
      pageNum: 1,
      // 搜索时的关键字
      keyWord: "",
     
    };
  },
  methods: {
    // 获取所有的会员信息
    listTopUp() {
      //console.log(this.keyword);
      let url =
        "/record/basic/listTopUp?pageNum=" +
        this.pageNum +
        "&pageSize=" +
        this.pageSize;
      if (this.keyWord != "" && this.keyWord != null) {
        url += "&keyWord=" + this.keyWord;
      }
      this.getRequest(url).then(resp => {
        if (resp) {
          console.log(resp);
          this.tableData = resp.obj1;
          this.total = resp.obj;
        }
      });
    },
    //pageSize改变是触发
    handleSizeChange(newSize) {
      // console.log(newSize);
      this.pageSize = newSize;
      this.listTopUp();
    },
    //pageNum  改变时触发
    handleCurrentChange(newNum) {
      // console.log(newNum);
      this.pageNum = newNum;
      this.listTopUp();
    },
    //模糊查询
    fuzzyQuery() {
      this.listTopUp();
    }
  },
  mounted() {
    this.listTopUp();
  }
};
</script>

<style scoped>
</style>