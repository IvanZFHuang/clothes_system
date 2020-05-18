<template>
  <div>
    <div style="display: flex;justify-content: flex-start">
      <div class="block">
        <el-date-picker
          style="width: 350px"
          v-model="currentDate"
          type="date"
          placeholder="根据日期查询"
          format="yyyy-MM-dd"
          value-format="yyyy-MM-dd"
          @change="listClock"
        ></el-date-picker>
      </div>
      <div style="margin-left:20px">
        <el-input
          placeholder="请输入员工名进行搜索，可以直接回车搜索..."
          prefix-icon="el-icon-search"
          :clearable="true"
          style="width: 350px;margin-right: 10px"
          @clear="listClock"
          v-model="keyword"
          @keydown.enter.native="listClock"
        ></el-input>
        <el-button
            icon="el-icon-circle-close"
            type="warning"
            @click="resetValue"
          >重&nbsp;&nbsp;置</el-button>
      </div>
    </div>
    <div style="margin-top:10px">
      <template>
        <el-table :data="tableData" border style="width: 100%">
          <el-table-column prop="name" label="姓名" width="180"></el-table-column>
          <el-table-column prop="empWorkID" label="工号" width="120"></el-table-column>
          <el-table-column label="打卡上班" width="100">
            <template slot-scope="scope">
              <el-switch
                :active-value="1"
                :inactive-value="0"
                style="display: block"
                v-model="scope.row.startWork"
                active-color="#13ce66"
                disabled
              ></el-switch>
            </template>
          </el-table-column>
          <el-table-column prop="clockDate" label="打卡时间" width="180"></el-table-column>
          <el-table-column label="打卡下班" width="100">
            <template slot-scope="scope">
              <el-switch
                :active-value="1"
                :inactive-value="0"
                style="display: block"
                v-model="scope.row.endWork"
                active-color="#13ce66"
                disabled
              ></el-switch>
            </template>
          </el-table-column>
          <el-table-column prop="endClockDate" label="打卡时间" width="180"></el-table-column>
          <el-table-column label="是否请假" width="100">
            <template slot-scope="scope">
              <el-switch
                :active-value="1"
                :inactive-value="0"
                style="display: block"
                v-model="scope.row.isLeave"
                active-color="#13ce66"
                disabled
              ></el-switch>
            </template>
          </el-table-column>
          <el-table-column prop="remark" label="备注"></el-table-column>
        </el-table>
      </template>
    </div>
    <div class="block" style="display: flex;justify-content: flex-end;margin-top:20px">
      <el-pagination
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page="pageNum"
        :page-sizes="[10, 20, 30, 40]"
        :page-size="pageSize"
        layout="total, sizes, prev, pager, next, jumper"
        :total="total"
        :background="true"
      ></el-pagination>
    </div>
  </div>
</template> 


<script>
export default {
  data() {
    return {
      tableData: [],
      total: 0,
      pageNum: 0,
      pageSize: 10,
      currentDate: "",
      keyword: ""
    };
  },
  methods: {
    listClock() {
      let url =
        "/clock/basic/listClock?pageNum=" +
        this.pageNum +
        "&pageSize=" +
        this.pageSize;
      if (this.currentDate != "" && this.keyword === "") {
        this.getRequest(url + "&currentDate=" + this.currentDate).then(resp => {
          if (resp) {
            this.tableData = resp.obj;
            this.total = resp.obj1;
          }
        });
      } else if (this.currentDate === "" && this.keyword != "") {
        this.getRequest(url + "&keyword=" + this.keyword).then(resp => {
          if (resp) {
            this.tableData = resp.obj;
            this.total = resp.obj1;
          }
        });
      } else if (this.currentDate != "" && this.keyword != "") {
        this.getRequest(
          url + "&keyword=" + this.keyword + "&currentDate=" + this.currentDate
        ).then(resp => {
          if (resp) {
            this.tableData = resp.obj;
            this.total = resp.obj1;
          }
        });
      } else {
        this.getRequest(url).then(resp => {
          if (resp) {
            this.tableData = resp.obj;
            this.total = resp.obj1;
          }
        });
      }
    },
    // 控制当前页的数量
    handleSizeChange() {
      this.pageSize = newSize;
      this.listClock();
    },
    // 控制页数的变化
    handleCurrentChange() {
      this.pageSize = pageNum;
      this.listClock();
    },
    // 重置按钮
    resetValue(){
      this.currentDate = "";
      this.keyword="";
      this.listClock();
    }
  },
  created() {
    this.listClock();
  }
};
</script>

<style scoped>
</style>