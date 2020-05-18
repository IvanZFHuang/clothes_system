<template>
  <div class="wrap" style="display: flex;justify-content: flex-start">
    <div>
      <el-card class="box-card clock">
        <div slot="header" class="clearfix">
          <span>打卡操作</span>
        </div>
        <div>
          <el-form ref="form" :model="form" label-width="80px">
            <el-avatar :size="70" :src="circleUrl"></el-avatar>
            <el-form-item label="姓名">
              <el-select
                v-model="form.empWorkID"
                filterable
                placeholder="请选择或搜索"
                @input="selectIsClock"
                :clearable="true"
                style="width:300px"
              >
                <el-option
                  v-for="item in employee"
                  :key="item.id"
                  :label="item.name"
                  :value="item.workID"
                ></el-option>
              </el-select>
            </el-form-item>
            <el-form-item label="工号">
              <el-input v-model="form.empWorkID" style="width:300px"></el-input>
            </el-form-item>
            <el-form-item label="时间">
              <el-input v-model="form.clockDate" style="width:300px"></el-input>
            </el-form-item>
            <el-row>
              <el-col :span="6">
                <el-form-item label="上班">
                  <el-switch
                    style="display: block"
                    v-model="form.startWork"
                    active-color="#13ce66"
                    inactive-color="#ff4949"
                    :active-value="1"
                    :inactive-value="0"
                    @change="doClock"
                  ></el-switch>
                </el-form-item>
              </el-col>
              <el-col :span="6">
                <el-form-item label="下班">
                  <el-switch
                    style="display: block"
                    v-model="form.endWork"
                    active-color="#13ce66"
                    inactive-color="#ff4949"
                    :active-value="1"
                    :inactive-value="0"
                    @change="doEndClock"
                  ></el-switch>
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <div style="margin-left:45px">
                  <el-button type="text" size="medium" @click="skipChange">
                    查看交接信息
                    <i class="el-icon-view el-icon--right"></i>
                  </el-button>
                </div>
              </el-col>
            </el-row>
          </el-form>
        </div>
      </el-card>
    </div>
    <!-- <div >
      <el-card class="box-card clock">
        <div slot="header" class="clearfix">
          <span>打卡操作</span>
        </div>
        <div>
          <el-form ref="form" :model="form" label-width="80px">
            <el-avatar :size="70" :src="circleUrl"></el-avatar>
            <el-form-item label="姓名">
              <el-select
                v-model="form.empWorkID"
                filterable
                placeholder="请选择或搜索"
                @input="selectIsClock"
                :clearable="true"
                style="width:300px"
              >
                <el-option
                  v-for="item in employee"
                  :key="item.id"
                  :label="item.name"
                  :value="item.workID"
                ></el-option>
              </el-select>
            </el-form-item>
            <el-form-item label="工号">
              <el-input v-model="form.empWorkID" style="width:300px"></el-input>
            </el-form-item>
            <el-form-item label="时间">
              <el-input v-model="form.clockDate" style="width:300px"></el-input>
            </el-form-item>
            <el-row>
              <el-col :span="6">
                <el-form-item label="上班">
                  <el-switch
                    style="display: block"
                    v-model="form.startWork"
                    active-color="#13ce66"
                    inactive-color="#ff4949"
                    :active-value="1"
                    :inactive-value="0"
                    @change="doClock"
                  ></el-switch>
                </el-form-item>
              </el-col>
              <el-col :span="6">
                <el-form-item label="下班">
                  <el-switch
                    style="display: block"
                    v-model="form.endWork"
                    active-color="#13ce66"
                    inactive-color="#ff4949"
                    :active-value="1"
                    :inactive-value="0"
                    @change="doEndClock"
                  ></el-switch>
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <div style="margin-left:45px">
                  <el-button type="text" size="medium" @click="skipChange">
                    查看交接信息
                    <i class="el-icon-view el-icon--right"></i>
                  </el-button>
                </div>
              </el-col>
            </el-row>
          </el-form>
        </div>
      </el-card>
    </div> -->
  </div>
</template>
<script>
export default {
  data() {
    return {
      employee: [],
      form: {
        empWorkID: "",
        clockDate: "",
        startWork: 0,
        endWork: 0
      },
      // 控制添加模态框的显示与隐藏
      dialogVisible: false,
      // 交接信息说明
      overRemark: "",
      circleUrl:
        "https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png"
    };
  },
  methods: {
    //提价交接信息
    onSubmit() {},
    //获取信息
    listInfo() {
      this.getRequest("/system/hr/listInfo").then(resp => {
        if (resp) {
          this.employee = resp.obj;
          this.form.clockDate = resp.obj1;
        }
      });
    },
    // 上班操作
    doClock(event) {
      this.postRequest("/employee/basic/insertClock", this.form).then(resp => {
        this.selectIsClock();
      });
    },
    // 下班的操作
    doEndClock() {
      this.putRequest("/employee/basic/updateClock", {
        empWorkid: this.form.empWorkID,
        clockDate: this.form.clockDate
      }).then(resp => {
        if (resp) {
          this.selectIsClock();
        }
      });
    },
    // 根据工号查询是够上班
    selectIsClock() {
      //console.log("zhixing le ");
      this.getRequest(
        "/employee/basic/selectClock?workID=" +
          this.form.empWorkID +
          "&clockDate=" +
          this.form.clockDate
      ).then(resp => {
        if (resp) {
          //console.log(resp);
          this.form.startWork = resp.obj.startWork;
          this.form.endWork = resp.obj.endWork;
        }
      });
    },
    // 跳转到交接任务页面
    skipChange() {
      if (this.form.empWorkID != "") {
        // this.$router.push({path:"/emp/class?empWorkID="+this.form.empWorkID});
        this.$router.push({
          path: "/emp/class",
          query: { empWorkID: this.form.empWorkID }
        });
      } else {
        this.$message.error("请先打卡或者输入姓名和工号");
      }
    }
  },
  created() {
    this.listInfo();
  }
};
</script>
<style>
.text {
  font-size: 14px;
}

.item {
  margin-bottom: 18px;
}

.clearfix:before,
.clearfix:after {
  display: table;
  content: "";
}
.clearfix:after {
  clear: both;
}

.wrap {
  margin: 200px auto;
}
.el-avatar {
  margin: 20px;
  margin-left: 40%;
}
</style>