<template>
  <div>
    <div style="display: flex;justify-content: space-between">
      <div>
        <el-input
          placeholder="根据顾客-名或会员号或手机号搜索，可以直接回车搜索..."
          prefix-icon="el-icon-search"
          :clearable="true"
          style="width: 350px;margin-right: 10px"
          @clear="listMembers"
          v-model="keyWord"
          @keydown.enter.native="listMembers"
          :disabled="showAdvanceSearchView"
        ></el-input>
        <el-button icon="el-icon-search" type="primary" @click="fuzzyQuery">搜索</el-button>
      </div>
      <div>
        <el-button type="primary" icon="el-icon-plus" @click="showAddDialog">添加</el-button>
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
        <el-table-column prop="customer.cusName" label="顾客姓名"></el-table-column>
        <el-table-column prop="memberType.typeName" label="会员类型"></el-table-column>
        <el-table-column prop="memberNum" label="会员号"></el-table-column>
        <el-table-column prop="createTime" label="会员开通时间" width="180px"></el-table-column>
        <el-table-column prop="balance" label="会员余额"></el-table-column>
        <el-table-column prop="memberType.discount" label="会员优惠"></el-table-column>
        <el-table-column prop="memberType.total" label="会员面值" width="100"></el-table-column>
        <el-table-column prop="customer.cusEmail" label="顾客邮箱" width="180px"></el-table-column>
        <el-table-column prop="customer.cusPhone" label="顾客电话" width="120px"></el-table-column>
        <el-table-column label="锁定/解锁会员" width="100px">
          <template slot-scope="scope">
            <el-switch
              :active-value="1"
              :inactive-value="0"
              style="display: block"
              v-model="scope.row.isLogout"
              @change="showStatus(scope.row)"
            ></el-switch>
          </template>
        </el-table-column>
        <el-table-column label="操作" width="120">
          <template slot-scope="scope">
            <el-button
              size="mini"
              type="primary"
              @click="handleEdit(scope.row)"
              style="padding: 3px"
            >编辑</el-button>
             <el-button
              size="mini"
              type="primary"
              @click="upMem(scope.row)"
              style="padding: 3px"
            >会员充值</el-button>
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
    <!-- 添加的模态框 -->
    <div>
      <el-dialog title="添加会员" :visible.sync="dialogVisible" width="60%">
        <el-steps :active="active" finish-status="success">
          <el-step title="添加顾客信息"></el-step>
          <el-step title="添加会员信息"></el-step>
          <el-step title="添加完成"></el-step>
        </el-steps>
        <el-form
          ref="form"
          :model="form"
          label-width="120px"
          v-show="active==0"
          style="margin-top:30px"
          :rules="rules1"
        >
          <el-form-item label="姓名" prop="cusName">
            <el-input v-model="form.cusName" style="width:300px"></el-input>
          </el-form-item>
          <el-form-item label="手机号" prop="cusPhone">
            <el-input v-model="form.cusPhone" style="width:300px"></el-input>
          </el-form-item>
          <el-form-item label="邮箱" prop="cusEmail">
            <el-input v-model="form.cusEmail" style="width:300px"></el-input>
          </el-form-item>
          <el-form-item show-message prop="commit">
            <el-radio-group v-model="commit">
              <el-radio label="1">我同意遵守洁神洗衣店的条款与条件,请认真查看精品课程相关规定!</el-radio>
            </el-radio-group>
          </el-form-item>
          <el-row style="margin-top: 50px">
            <el-button
              type="primary"
              icon="el-icon-arrow-right el-icon--right"
              style="float: right"
              @click="stepNext()"
            >
              <i>下一步</i>
            </el-button>
          </el-row>
        </el-form>
        <el-form
          ref="form1"
          :model="form1"
          label-width="120px"
          v-show="active==1"
          style="margin-top:30px"
          :rules="rules2"
        >
          <el-form-item label="会员号" prop>
            <el-input v-model="form1.memberNum" style="width:300px" :disabled="true"></el-input>
          </el-form-item>
          <el-form-item label="会员类型" prop="typeId">
            <el-select
              v-model="form1.typeId"
              filterable
              placeholder="请选择会员类型"
              :clearable="true"
              style="width:300px"
              @change="selecttotal"
            >
              <el-option
                v-for="item in allType"
                :key="item.typeId"
                :label="item.typeName"
                :value="item.typeId"
              ></el-option>
            </el-select>
            <el-link type="info" :underline="false" href="/#/mem/type">
              查看会员类型
              <i class="el-icon-view el-icon--right"></i>
            </el-link>
          </el-form-item>
          <el-form-item label="会员说明" prop>
            <el-input v-model="totalMoney" style="width:300px" :disabled="true"></el-input>
          </el-form-item>
          <el-row style="margin-top: 50px">
            <el-button
              type="primary"
              icon="el-icon-arrow-right el-icon--right"
              style="float: right"
              @click="stepNext()"
            >
              <i>下一步</i>
            </el-button>
            <el-button
              type="primary"
              icon="el-icon-arrow-left el-icon--left"
              style="float: right;margin-right:10px"
              @click="stepLast()"
            >
              <i>上一步</i>
            </el-button>
          </el-row>
        </el-form>

        <el-row
          type="flex"
          :gutter="20"
          style="margin-top: 100px;margin-left: 20%;margin-right: 30%;"
          v-show="active==2"
        >
          <el-col :span="10"></el-col>
          <el-col :span="10">
            <el-button type="primary" plain @click="lookInfo">查看信息</el-button>
          </el-col>
          <el-col :span="10">
            <el-button type="success" plain>关于我</el-button>
          </el-col>
        </el-row>
      </el-dialog>
    </div>

    <!-- 修改模态框 -->
    <div>
      <el-dialog title="修改工资条" :visible.sync="updateDialogVisible" width="50%">
        <el-form
          ref="memberInfo"
          :model="memberInfo"
          label-width="120px"
          v-show="active==0"
          style="margin-top:30px"
          :rules="rules3"
        >
          <el-form-item label="姓名" prop="cusName">
            <el-input v-model="memberInfo.cusName" style="width:300px"></el-input>
          </el-form-item>
          <el-form-item label="手机号" prop="cusPhone">
            <el-input v-model="memberInfo.cusPhone" style="width:300px"></el-input>
          </el-form-item>
          <el-form-item label="邮箱" prop="cusEmail">
            <el-input v-model="memberInfo.cusEmail" style="width:300px"></el-input>
          </el-form-item>
          <el-form-item label="会员号">
            <el-input v-model="memberInfo.memberNum" style="width:300px" :disabled="true"></el-input>
          </el-form-item>
          <el-form-item label="会员说明" prop>
            <el-input v-model="memberInfo.total" style="width:300px" :disabled="true"></el-input>
          </el-form-item>
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
  data() {
    //手机号码验证
    const checkTel = (rule, value, callback) => {
      if (value === "") {
        return callback(new Error("请输入手机号码"));
      } else {
        const reg1 = /^[0-9]{1,20}$/;
        if (!reg1.test(value)) {
          return callback(new Error("请输入数字值"));
        } else {
          //截止2019/1/1 已开通的号段
          const reg2 = /^[1](([3][0-9])|([4][5-9])|([5][0-3,5-9])|([6][5,6])|([7][0-8])|([8][0-9])|([9][1,8,9]))[0-9]{8}$/;
          if (!reg2.test(value)) {
            console.log(1);
            return callback(new Error("请输入正确的手机号码"));
          }
          //验证是否已存在
          this.getRequest(
            "/customer/basic/getCountByPhone?phone=" + value
          ).then(result => {
            if (result.obj > 0) return callback(new Error("该手机号已注册"));
            else return callback();
          });
        }
      }
    };
    const checkChName = (rule, value, callback) => {
      if (value === "") {
        return callback(new Error("请输入姓名"));
      } else {
        const reg = /^[\u4E00-\u9FA5]{1,5}$/;
        if (!reg.test(value)) {
          return callback(new Error("请输入中文"));
        } else {
          return callback();
        }
      }
    };

    const checkType = (rule, value, callback) => {
      // console.log('value1 ==' + value);
      if (value === "") {
        return callback(new Error("请选择会员类型"));
      } else {
        return callback();
      }
    };
    const checkRadio = (rule, value, callback) => {
      // console.log('value2 ==' + this.commit);
      if (this.commit != 1) {
        return callback(new Error("请选择"));
      } else {
        return callback();
      }
    };

    const checkPhone = (rule, value, callback) => {
      if (value === "") {
        return callback(new Error("请输入手机号码"));
      } else {
        const reg1 = /^[0-9]{1,20}$/;
        if (!reg1.test(value)) {
          return callback(new Error("请输入数字值"));
        } else {
          //截止2019/1/1 已开通的号段
          const reg2 = /^[1](([3][0-9])|([4][5-9])|([5][0-3,5-9])|([6][5,6])|([7][0-8])|([8][0-9])|([9][1,8,9]))[0-9]{8}$/;
          if (!reg2.test(value)) {
            console.log(1);
            return callback(new Error("请输入正确的手机号码"));
          }else{
            return callback();
          }
          
        }
      }
    };

    // 自定义邮箱验证规则
    var checkEmail = (rule, value, callback) => {
      var reg = /^[a-zA-Z0-9]+([-_.][a-zA-Z0-9]+)*@[a-zA-Z0-9]+([-_.][a-zA-Z0-9]+)*\.[a-z]{2,}$/;
      if (value === "") {
        callback(new Error("请输入邮箱"));
      } else {
        if (reg.test(value)) {
          callback();
        } else {
          callback(new Error("请输入正确的邮箱"));
        }
      }
    };
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
      keyWord: "",
      //控制对话框的显示与隐藏
      dialogVisible: false,
      // 控制进度条
      active: 0,
      commit: 0,
      // 添加顾客信息
      form: {
        cusName: "",
        cusPhone: "",
        cusEmail: ""
      },
      // 添加会员信息
      form1: {
        memberNum: "",
        typeId: "",
        customId: 0,
        balance: ""
      },
      totalMoney: "",
      //隐藏id列
      showid: false,
      updateDialogVisible: false,
      // 会员信息
      memberInfo: {
        memberId: "",
        memberNum: "",
        cusName: "",
        cusEmail: "",
        cusPhone: "",
        total: "",
        cusId:""
      },
      //接受刚入职的员工
      employee: [],
      allType: [],
      //自定义+默认校验规则
      rules1: {
        cusName: [{ validator: checkChName, trigger: "blur" }],
        cusPhone: [
          { required: true, message: "请输入手机号码", trigger: "blur" },
          { validator: checkTel, trigger: "blur" }
        ],
        cusEmail: [{ required: true, validator: checkEmail, trigger: "blur" }],

        commit: [{ validator: checkRadio, trigger: "blur" }]
      }, 

      rules3: {
        cusName: [{ validator: checkChName, trigger: "blur" }],
        cusPhone: [
          { required: true, message: "请输入手机号码", trigger: "blur" },
          { validator: checkPhone, trigger: "blur" }
        ],
        cusEmail: [{ required: true, validator: checkEmail, trigger: "blur" }],
      },
      rules2: {
        typeId: [{ validator: checkType, trigger: "blur" }]
      }
    };
  },
  methods: {
    // 获取所有的会员信息
    listMembers() {
      //console.log(this.keyword);
      let url =
        "member/basic/listMembers?pageNum=" +
        this.pageNum +
        "&pageSize=" +
        this.pageSize;
      if (this.keyWord != "" && this.keyWord != null) {
        url += "&keyWord=" + this.keyWord;
      }
      this.getRequest(url).then(resp => {
        if (resp) {
          //console.log(resp);
          this.tableData = resp.obj;
          this.total = resp.obj1;
        }
      });
    },

    //编辑
    handleEdit(row) {
      console.log(row);
      this.updateDialogVisible = true;
      this.getRequest(
        "/member/basic/selectMemberById?id=" + row.memberId
      ).then(resp => {
        if (resp) {
          this.memberInfo = resp.obj;
          //console.log(this.memberInfo);
        }
      });
    },
    //pageSize改变是触发
    handleSizeChange(newSize) {
      // console.log(newSize);
      this.pageSize = newSize;
      this.listMembers();
    },
    //pageNum  改变时触发
    handleCurrentChange(newNum) {
      // console.log(newNum);
      this.pageNum = newNum;
      this.listMembers();
    },
    //模糊查询
    fuzzyQuery() {
      this.listMembers();
    },

    //显示添加的模态框
    showAddDialog() {
      this.dialogVisible = true;
    },

    closeAddDialog() {
      this.dialogVisible = false;
    },
    stepNext() {
      //处理两个表单
      if (this.active == 0) {
        this.$refs.form.validate(valid => {
          /*通过表单验证*/
          console.log(valid);
          if (!valid) {
            //弹出错误信息提示框
            this.$emit(
              "user",
              this.$message({
                message: "输入信息有误！",
                type: "warning",
                duration: 3000
              })
            );
          } else {
            //console.log("wajkhefwuiah");
            if (this.active++ > 2) this.active = 0;
            this.listMemberType();
            this.setMemberNum();
          }
        });
      } else if (this.active == 1) {
        this.$refs.form1.validate(valid => {
          /*通过表单验证*/
          if (!valid) {
            //弹出错误信息提示框
            this.$emit(
              "user",
              this.$message({
                message: "输入信息有误！",
                type: "warning",
                duration: 3000
              })
            );
          } else {
            this.addCustomer();
            this.active = 2;
          }
        });
      }
    },
    // 返回到上一层
    stepLast() {
      this.active = 0;
    },
    // 查询会员类型
    listMemberType() {
      this.getRequest("/member/type/listMember").then(resp => {
        if (resp) {
          this.allType = resp.obj;
        }
      });
    },
    lookInfo() {
      this.dialogVisible = false;
      this.listMembers();
    },
    // 设置会员号
    setMemberNum() {
      this.getRequest("/member/basic/getMemberNum").then(resp => {
        if (resp) {
          this.form1.memberNum = resp.obj;
        }
      });
    },
    // 添加顾客信息
    addCustomer() {
      this.postRequest("/customer/basic/insertCus", this.form).then(resp => {
        if (resp) {
          this.form1.customId = resp.obj;
          this.addMember();
        }
      });
    },
    // 添加会员信息
    addMember() {
      this.postRequest("/member/basic/insertMember", this.form1);
    },
    selecttotal() {
      this.getRequest(
        "/member/type/selectTotal?typeId=" + this.form1.typeId
      ).then(resp => {
        if (resp) {
          this.totalMoney = resp.obj.total;
          this.form1.balance = resp.obj.totalMoney;
        }
      });
    },
    showStatus(row) {
      let id = row.memberId;
      let isLogout = row.isLogout;

      this.putRequest("/member/basic/logout", {
        id: id,
        isLogout: isLogout
      }).then(resp => {
        if (resp) {
          this.listMembers();
        }
      });
    },
    closeUpdateDialog() {
     this.updateDialogVisible = false;
    },

    //提交修改信息
    commitUpdateForm() {
      this.$refs.memberInfo.validate(valid => {
        if (valid) {
          this.putRequest("/member/basic/update", this.memberInfo).then(
            resp => {
              if (resp) {
                this.updateDialogVisible = false;
                this.listMembers();
              }
            }
          );
        }
      });
    },
    // 会员充值
    upMem(data){
      this.$router.push({
          path: "/mem/up",
          query: {
            typeId: data.typeId,
            cusId: data.customer.cusId,
            memberId: data.memberId,
            phone:data.customer.cusPhone,
            rechargeAcount:data.memberType.rechargeAcount,
            balance:data.balance,
            memberNum:data.memberNum
          }
        });
    }
  },
  mounted() {
    this.listMembers();
  }
};
</script>

<style scoped>
</style>