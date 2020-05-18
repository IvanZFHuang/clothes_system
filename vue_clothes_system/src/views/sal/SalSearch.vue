<template>
  <div>
    <div style="display: flex;justify-content: space-between">
      <div>
        <el-input
          placeholder="请输入员工名进行搜索，可以直接回车搜索..."
          prefix-icon="el-icon-search"
          :clearable="true"
          style="width: 350px;margin-right: 10px"
          @clear="listSalary"
          v-model="keyword"
          @keydown.enter.native="listSalary"
          :disabled="showAdvanceSearchView"
        ></el-input>
        <el-button icon="el-icon-search" type="primary" @click="fuzzyQuery">搜索</el-button>
      </div>
      <div>
        <el-button type="primary" icon="el-icon-plus" @click="showAddDialog">添加工资条</el-button>
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
        <el-table-column prop="employee.id" label="员工id" v-if="showid"></el-table-column>
        <el-table-column prop="employee.name" label="员工姓名"></el-table-column>
        <el-table-column prop="employee.workID" label="员工工号"></el-table-column>
        <el-table-column prop="basicSalary" label="基本工资"></el-table-column>
        <el-table-column prop="bonus" label="奖金"></el-table-column>
        <el-table-column prop="lunchSalary" label="餐补"></el-table-column>
        <el-table-column prop="trafficSalary" label="交通补助"></el-table-column>
        <el-table-column prop="allSalary" label="实发工资"></el-table-column>
        <el-table-column prop="pensionBase" label="养老金基数"></el-table-column>
        <el-table-column prop="pensionPer" label="养老金比率"></el-table-column>
        <el-table-column prop="medicalBase" label="医疗保险基数"></el-table-column>
        <el-table-column prop="medicalPer" label="医疗保险比率"></el-table-column>
        <el-table-column label="操作">
          <template slot-scope="scope">
            
            <el-button
              size="mini"
              type="primary"
              @click="handleEdit(scope.row)"
              style="padding: 3px"
            >编辑</el-button>
            <el-button
              size="mini"
              type="danger"
              @click="handleDelete(scope.row)"
              style="padding: 3px"
            >删除</el-button>
          </template>
        </el-table-column>
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
    <!-- 添加工资条的模态框 -->
    <div>
      <el-dialog title="添加工资条" :visible.sync="dialogVisible" width="60%">
        <el-form ref="salaryForm" :model="salaryForm" label-width="100px" :rules="rules">
          <el-row>
            <el-col :span="8">
              <div class="grid-content bg-purple">
                <el-form-item label="员工姓名">
                  <el-select v-model="salaryForm.workID" placeholder="请选择员工姓名" :clearable="true">
                    <el-option
                      v-for="item in employee"
                      :key="item.workID"
                      :value="item.workID"
                      :label="item.name"
                    ></el-option>
                  </el-select>
                </el-form-item>
              </div>
            </el-col>
            <el-col :span="8">
              <div class="grid-content bg-purple-light">
                <el-form-item label="员工工号" prop="workID">
                  <el-input v-model="salaryForm.workID" :disabled="true"></el-input>
                </el-form-item>
              </div>
            </el-col>
            <el-col :span="8">
              <div class="grid-content bg-purple">
                <el-form-item label="基本工资" prop="basicSalary">
                  <el-input v-model="salaryForm.basicSalary" @input="assignMent"></el-input>
                </el-form-item>
              </div>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="8">
              <div class="grid-content bg-purple">
                <el-form-item label="奖金" prop="bonus">
                  <el-input v-model="salaryForm.bonus" @input="assignMent"></el-input>
                </el-form-item>
              </div>
            </el-col>
            <el-col :span="8">
              <div class="grid-content bg-purple-light">
                <el-form-item label="餐补" prop="lunchSalary">
                  <el-input v-model="salaryForm.lunchSalary" @input="assignMent"></el-input>
                </el-form-item>
              </div>
            </el-col>
            <el-col :span="8">
              <div class="grid-content bg-purple">
                <el-form-item label="交通补助" prop="trafficSalary">
                  <el-input v-model="salaryForm.trafficSalary" @input="assignMent"></el-input>
                </el-form-item>
              </div>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="8">
              <div class="grid-content bg-purple">
                <el-form-item label="实发工资">
                  <el-input v-model="salaryForm.allSalary" :disabled="true"></el-input>
                </el-form-item>
              </div>
            </el-col>
            <el-col :span="8">
              <div class="grid-content bg-purple-light">
                <el-form-item label="养老金基数">
                  <el-input v-model="salaryForm.pensionBase" :disabled="true"></el-input>
                </el-form-item>
              </div>
            </el-col>
            <el-col :span="8">
              <div class="grid-content bg-purple">
                <el-form-item label="养老金比率">
                  <el-input v-model="salaryForm.pensionPer" :disabled="true"></el-input>
                </el-form-item>
              </div>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="8">
              <div class="grid-content bg-purple">
                <el-form-item label="医疗保险基数">
                  <el-input v-model="salaryForm.medicalBase" :disabled="true"></el-input>
                </el-form-item>
              </div>
            </el-col>
            <el-col :span="8">
              <div class="grid-content bg-purple-light">
                <el-form-item label="医疗保险比率">
                  <el-input v-model="salaryForm.medicalPer" :disabled="true"></el-input>
                </el-form-item>
              </div>
            </el-col>
            <el-col :span="8">
              <div class="grid-content bg-purple"></div>
            </el-col>
          </el-row>
        </el-form>
        <span slot="footer" class="dialog-footer">
          <el-button @click="closeAddDialog">取 消</el-button>
          <el-button type="primary" @click="addSalaryInfo">确 定</el-button>
        </span>
      </el-dialog>
    </div>
    <!-- 修改模态框 -->
    <div>
      <el-dialog title="修改工资条" :visible.sync="updateDialogVisible" width="60%">
        <el-form
          ref="updateSalaryForm"
          :model="updateSalaryForm"
          label-width="100px"
          :rules="rules"
        >
          <el-row>
            <el-col :span="8">
              <div class="grid-content bg-purple">
                <el-form-item label="员工姓名">
                  <el-input v-model="updateSalaryForm.name" :disabled="true"></el-input>
                </el-form-item>
              </div>
            </el-col>
            <el-col :span="8">
              <div class="grid-content bg-purple">
                <el-form-item label="基本工资" prop="basicSalary">
                  <el-input v-model="updateSalaryForm.basicSalary" @input="updateAssignMent"></el-input>
                </el-form-item>
              </div>
            </el-col>
            <el-col :span="8">
              <div class="grid-content bg-purple">
                <el-form-item label="奖金" prop="bonus">
                  <el-input v-model="updateSalaryForm.bonus" @input="updateAssignMent"></el-input>
                </el-form-item>
              </div>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="8">
              <div class="grid-content bg-purple-light">
                <el-form-item label="餐补" prop="lunchSalary">
                  <el-input v-model="updateSalaryForm.lunchSalary" @input="updateAssignMent"></el-input>
                </el-form-item>
              </div>
            </el-col>
            <el-col :span="8">
              <div class="grid-content bg-purple">
                <el-form-item label="交通补助" prop="trafficSalary">
                  <el-input v-model="updateSalaryForm.trafficSalary" @input="updateAssignMent"></el-input>
                </el-form-item>
              </div>
            </el-col>
            <el-col :span="8">
              <div class="grid-content bg-purple">
                <el-form-item label="实发工资">
                  <el-input v-model="updateSalaryForm.allSalary" :disabled="true"></el-input>
                </el-form-item>
              </div>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="8">
              <div class="grid-content bg-purple-light">
                <el-form-item label="养老金基数">
                  <el-input v-model="updateSalaryForm.pensionBase" :disabled="true"></el-input>
                </el-form-item>
              </div>
            </el-col>
            <el-col :span="8">
              <div class="grid-content bg-purple">
                <el-form-item label="养老金比率">
                  <el-input v-model="updateSalaryForm.pensionPer" :disabled="true"></el-input>
                </el-form-item>
              </div>
            </el-col>
            <el-col :span="8">
              <div class="grid-content bg-purple">
                <el-form-item label="医疗保险基数">
                  <el-input v-model="updateSalaryForm.medicalBase" :disabled="true"></el-input>
                </el-form-item>
              </div>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="8">
              <div class="grid-content bg-purple-light">
                <el-form-item label="医疗保险比率">
                  <el-input v-model="updateSalaryForm.medicalPer" :disabled="true"></el-input>
                </el-form-item>
              </div>
            </el-col>
            <el-col :span="8">
              <div class="grid-content bg-purple"></div>
            </el-col>
          </el-row>
        </el-form>
        <span slot="footer" class="dialog-footer">
          <el-button @click="closeUpdateDialog">取 消</el-button>
          <el-button type="primary" @click="commitUpdateForm">确 定</el-button>
        </span>
      </el-dialog>
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
      showAdvanceSearchView: false,
      // 搜索时的关键字
      keyword: "",
      //控制对话框的显示与隐藏
      dialogVisible: false,

      // 添加工资条实例
      salaryForm: {
        basicSalary: "",
        bonus: "",
        lunchSalary: "",
        trafficSalary: "",
        allSalary: 0,
        pensionBase: 2000,
        pensionPer: 0.07,
        medicalBase: 2000,
        medicalPer: 0.07,
        workID: ""
      },
      updateSalaryForm: {
        id: "",
        basicSalary: "",
        bonus: "",
        lunchSalary: "",
        trafficSalary: "",
        allSalary: 0,
        pensionBase: 2000,
        pensionPer: 0.07,
        medicalBase: 2000,
        medicalPer: 0.07,
        name: ""
      },
      //隐藏id列
      showid: false,

      updateDialogVisible: false,
      //接受刚入职的员工
      employee: [],
      rules: {
        basicSalary: [
          { required: true, message: "请输入基本工资", trigger: "change" },
          {
            validator(rule, value, callback) {
              if (Number.isInteger(Number(value)) && Number(value) > 0) {
                callback();
              } else {
                callback(new Error("请输入有效数字"));
              }
            },
            trigger: "blur"
          }
        ],
        bonus: [
          { required: true, message: "请输入奖金", trigger: "change" },
          {
            validator(rule, value, callback) {
              if (Number.isInteger(Number(value)) && Number(value) > 0) {
                callback();
              } else {
                callback(new Error("请输入有效数字"));
              }
            },
            trigger: "blur"
          }
        ],
        lunchSalary: [
          { required: true, message: "请输入餐补", trigger: "change" },
          {
            validator(rule, value, callback) {
              if (Number.isInteger(Number(value)) && Number(value) > 0) {
                callback();
              } else {
                callback(new Error("请输入有效数字"));
              }
            },
            trigger: "blur"
          }
        ],
        trafficSalary: [
          { required: true, message: "请输入交通补助", trigger: "change" },
          {
            validator(rule, value, callback) {
              if (Number.isInteger(Number(value)) && Number(value) > 0) {
                callback();
              } else {
                callback(new Error("请输入有效数字"));
              }
            },
            trigger: "blur"
          }
        ]
      }
    };
  },
  methods: {
    // 获取所有的工资
    listSalary() {
      console.log(this.keyword);
      let url =
        "/salary/sob/listSalary?pageNum=" +
        this.pageNum +
        "&pageSize=" +
        this.pageSize;
      if (this.keyword != "" && this.keyword != null) {
        url += "&keyword=" + this.keyword;
      }
      this.getRequest(
        url
        // params: {
        //   pageNum: this.pageNum,
        //   pageSize: this.pageSize
        // }
      ).then(resp => {
        if (resp) {
          //console.log(resp);
          this.tableData = resp.obj;
          this.total = resp.obj1;
        }
      });
    },
    //删除
    handleDelete(row) {
      this.$confirm("此操作将永久删除【" + row.name + "】, 是否继续?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      })
        .then(() => {
          this.deleteRequest("/salary/sob/delete/" + row.id).then(resp => {
            if (resp) {
              this.listSalary();
            }
          });
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "已取消删除"
          });
        });
    },
    //编辑
    handleEdit(row) {
      console.log(row);
      this.updateDialogVisible = true;
      this.getRequest("/salary/sob/selectSalaryById?id=" + row.id).then(
        resp => {
          if (resp) {
            this.updateSalaryForm = resp.obj;
          }
        }
      );
    },
    //pageSize改变是触发
    handleSizeChange(newSize) {
      // console.log(newSize);
      this.pageSize = newSize;
      this.listSalary();
    },
    //pageNum  改变时触发
    handleCurrentChange(newNum) {
      // console.log(newNum);
      this.pageNum = newNum;
      this.listSalary();
    },
    //模糊查询
    fuzzyQuery() {
      this.listSalary();
    },
    //查询刚入职的还没有添加工资条的员工
    listIsEntry() {
      this.getRequest("/employee/basic/selectIsEntry").then(resp => {
        if (resp) {
          this.employee = resp.obj;
        }
      });
    },
    //给实发工资赋值
    assignMent() {
      this.salaryForm.allSalary =
        Number(this.salaryForm.basicSalary) +
        Number(this.salaryForm.bonus) +
        Number(this.salaryForm.lunchSalary) +
        Number(this.salaryForm.trafficSalary);
    },
    updateAssignMent() {
      this.updateSalaryForm.allSalary =
        Number(this.updateSalaryForm.basicSalary) +
        Number(this.updateSalaryForm.bonus) +
        Number(this.updateSalaryForm.lunchSalary) +
        Number(this.updateSalaryForm.trafficSalary);
    },
    //显示添加的模态框
    showAddDialog() {
      this.dialogVisible = true;
      this.listIsEntry();
    },
    //添加工资信息
    addSalaryInfo() {
      this.$refs.salaryForm.validate(valid => {
        if (valid) {
          this.postRequest("/salary/sob/addSalaryInfo", this.salaryForm).then(
            resp => {
              if (resp) {
                this.$refs.salaryForm.resetFields();
                this.dialogVisible = false;
                setTimeout(this.listSalary(), 2000);
              }
            }
          );
        }
      });
    },
    closeAddDialog() {
      this.$refs.salaryForm.resetFields();
      this.dialogVisible = false;
    },
    //关闭修改模态框
    closeUpdateDialog() {
      this.updateDialogVisible = false;
    },
    //提交修改信息
    commitUpdateForm() {
      this.$refs.updateSalaryForm.validate(valid => {
        if (valid) {
          this.putRequest("/salary/sob/update", this.updateSalaryForm).then(
            resp => {
              if (resp) {
                this.updateDialogVisible = false;
                this.listSalary();
              }
            }
          );
        }
      });
    }
  },
  mounted() {
    this.listSalary();
  }
};
</script>

<style scoped>
</style>