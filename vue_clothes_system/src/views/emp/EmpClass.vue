<template>
  <div>
    <div>
      <div style="display: flex;justify-content: space-between">
        <div class="block">
          <span class="demonstration">根据日期查看：</span>
          <el-date-picker
            v-model="currentDate"
            type="date"
            placeholder="选择日期"
            format="yyyy-MM-dd"
            value-format="yyyy-MM-dd"
            @change="listChanges"
          ></el-date-picker>
        </div>
        <div>
          <el-button type="primary" icon="el-icon-plus" @click="showAddChangeView">添加交接信息</el-button>
        </div>
      </div>
    </div>
    <div class="tableWrap">
      <el-table :data="tableData" width="100%">
        <el-table-column prop="date" label="交接" align="center">
          <el-table-column prop="oparatorName" label="姓名" width="100px"></el-table-column>
          <el-table-column prop="oparatorWorkid" label="工号" width="100px"></el-table-column>
          <el-table-column prop="overDate" label="交接时间" width="180px"></el-table-column>
          <el-table-column prop="overRemark" label="交接信息"></el-table-column>
        </el-table-column>
        <el-table-column label="对接" align="center">
          <el-table-column prop="overName" label="姓名" width="100px"></el-table-column>
          <el-table-column prop="overWorkid" label="工号" width="100px"></el-table-column>
        </el-table-column>
        <el-table-column label="对接情况" align="center" width="200px">
          <template slot-scope="scope">
            <el-switch
              :active-value="1"
              :inactive-value="0"
              style="display: block"
              v-model="scope.row.isOver"
              active-color="#13ce66"
              inactive-color="#ff4949"
              active-text="已对接"
              inactive-text="未对接"
              @change="showStatus(scope.row)"
            ></el-switch>
          </template>
        </el-table-column>
      </el-table>
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
    <!-- 显示添加交接信息的模态框 -->
    <el-dialog title="添加交接信息" :visible.sync="dialogVisible" width="50%">
      <el-form ref="form" :model="form" label-width="120px" :rules="rules">
        <el-form-item label="交接人姓名">
          <el-select
            v-model="form.oparatorWorkid"
            filterable
            placeholder="请选择或搜索"
            :clearable="true"
            style="width:300px"
          >
            <el-option
              v-for="item in allName"
              :key="item.id"
              :label="item.name"
              :value="item.workID"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="交接人工号" prop="oparatorWorkid">
          <el-input v-model="form.oparatorWorkid" style="width:300px"></el-input>
        </el-form-item>
        <el-form-item label="对接人姓名">
          <el-select
            v-model="form.overWorkid"
            filterable
            placeholder="请选择或搜索"
            :clearable="true"
            style="width:300px"
          >
            <el-option
              v-for="item in allName"
              :key="item.id"
              :label="item.name"
              :value="item.workID"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="对接人工号" prop="overWorkid">
          <el-input v-model="form.overWorkid" style="width:300px"></el-input>
        </el-form-item>
        <el-form-item label="交接信息" prop="overRemark">
          <el-input type="textarea" v-model="form.overRemark"></el-input>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="closeAddView">取 消</el-button>
        <el-button type="primary" @click="addChange">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>
<script>
export default {
  data() {
    return {
      // 存放详细信息
      tableData: [],
      total: 0,
      pageNum: 0,
      pageSize: 10,
      // 当天日期
      currentDate: "",
      dialogVisible: false,
      form: {
        oparatorName: "",
        oparatorWorkid: "",
        overName: "",
        overWorkid: "",
        overRemark: ""
      },
      // 接受路由上的参数
      routerParam: "",
      // 所有的员工姓名
      allName: [],
      rules: {
        oparatorWorkid: [
          { required: true, message: "请输入交接人工号", trigger: "change" }
        ],

        overWorkid: [
          { required: true, message: "请输入对接人工号", trigger: "change" }
        ],
        overRemark: [
          {
            required: true,
            message: "请输入交接信息",
            trigger: "change"
          }
        ]
      }
    };
  },
  methods: {
    listChanges() {
      let url =
        "/changed/basic/listChanges?pageNum=" +
        this.pageNum +
        "&pageSize=" +
        this.pageSize;
      if (this.currentDate != "" && this.currentDate!=null) {
        this.getRequest(url + "&currentDate=" + this.currentDate).then(resp => {
          if (resp) {
            this.tableData = resp.obj;
            this.total = resp.obj1;
          }
        });
      } else if (this.routerParam != "" && this.routerParam!=undefined) {
        //console.log("zhixingl")
        this.getRequest(url + "&workId=" + this.routerParam).then(resp => {
          if (resp) {
            this.tableData = resp.obj;
            this.total = resp.obj1;
            // 将参数值设置为空
            this.routerParam = "";
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
    // 修改交接状态
    showStatus(row) {
      let isOver = row.isOver;
      let changeId = row.changeId;
      //修改状态
      this.putRequest("/changed/basic/updateIsOver", {
        isOver: isOver,
        changeId: changeId
      }).then(resp => {
        if (resp) {
          this.listChanges();
        }
      });
    },
    // 控制当前页的数量
    handleSizeChange() {
      this.pageSize = newSize;
      this.listChanges();
    },
    // 控制页数的变化
    handleCurrentChange() {
      this.pageSize = pageNum;
      this.listChanges();
    },
    // 展示添加的模态框
    showAddChangeView() {
      this.dialogVisible = true;
      this.getRequest("/system/hr/listInfo").then(resp => {
        if (resp) {
          // console.log(resp);
          this.allName = resp.obj;
        }
      });
    },
    //添加交接信息
    addChange() {
      this.postRequest("/changed/basic/addChange", this.form).then(resp => {
        if (resp) {
          this.dialogVisible = false;
          this.listChanges();
          this.$refs.form.resetFields();
        }
      });
    },
    //关闭添加的模态框
    closeAddView() {
      this.dialogVisible = false;
      this.$refs.form.resetFields();
    }
  },
  created() {
    this.routerParam = this.$route.query.empWorkID;
    this.listChanges();
  }
};
</script>
<style>
.block {
  margin-bottom: 20px;
}
</style>