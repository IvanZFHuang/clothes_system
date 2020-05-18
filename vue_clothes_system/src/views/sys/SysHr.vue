<template>
  <div>
    <div style="margin-top: 10px;display: flex;justify-content: center">
      <el-input
        v-model="keywords"
        placeholder="通过用户名搜索用户..."
        prefix-icon="el-icon-search"
        style="width: 400px;margin-right: 10px"
        @keydown.enter.native="doSearch"
      ></el-input>
      <el-button icon="el-icon-search" type="primary" @click="doSearch">搜索</el-button>
      <el-button icon="el-icon-circle-plus-outline" type="primary" @click="doadd">添加</el-button>
    </div>
    <div class="hr-container">
      <el-card class="hr-card" v-for="(hr,index) in hrs" :key="index">
        <div slot="header" class="clearfix">
          <span>{{hr.name}}</span>
          <el-button
            style="float: right; padding: 3px 0;color: #e30007;"
            type="text"
            icon="el-icon-delete"
            @click="deleteHr(hr)"
          ></el-button>
        </div>
        <div>
          <div class="img-container">
            <img :src="hr.userface" :alt="hr.name" :title="hr.name" class="userface-img" />
          </div>
          <div class="userinfo-container">
            <div>用户名：{{hr.name}}</div>
            <div>手机号码：{{hr.phone}}</div>
            <div>电话号码：{{hr.telephone}}</div>
            <div>地址：{{hr.address}}</div>
            <div>
              用户状态：
              <el-switch
                v-model="hr.enabled"
                active-text="启用"
                @change="enabledChange(hr)"
                active-color="#13ce66"
                inactive-color="#ff4949"
                inactive-text="禁用"
              ></el-switch>
            </div>
            <div>
              用户角色：
              <el-tag
                type="success"
                style="margin-right: 4px"
                v-for="(role,indexj) in hr.roles"
                :key="indexj"
              >{{role.nameZh}}</el-tag>
              <el-popover
                placement="right"
                title="角色列表"
                @show="showPop(hr)"
                @hide="hidePop(hr)"
                width="200"
                trigger="click"
              >
                <el-select v-model="selectedRoles" multiple placeholder="请选择">
                  <el-option
                    v-for="(r,indexk) in allroles"
                    :key="indexk"
                    :label="r.nameZh"
                    :value="r.id"
                  ></el-option>
                </el-select>
                <el-button slot="reference" icon="el-icon-more" type="text"></el-button>
              </el-popover>
            </div>
            <div>备注：{{hr.remark}}</div>
          </div>
        </div>
      </el-card>
    </div>
    <!-- 添加用户的模态框 -->
    <el-dialog title="添加用户" :visible.sync="dialogVisible" width="50%">
      <el-form ref="hrForm" :model="hrForm" label-width="80px" :rules="rules">
        <el-form-item label="用户名" prop="name">
          <el-input v-model="hrForm.name" style="width:400px"></el-input>
        </el-form-item>
        <el-form-item label="账号" prop="username">
          <el-input v-model="hrForm.username" style="width:400px"></el-input>
        </el-form-item>
        <el-form-item label="手机号" prop="phone">
          <el-input v-model="hrForm.phone" style="width:400px"></el-input>
        </el-form-item>
        <el-form-item label="分店电话" prop="telephone">
          <el-input v-model="hrForm.telephone" style="width:400px"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="password">
          <el-input type="password" v-model="hrForm.password" style="width:400px"></el-input>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="cancelAdd">取 消</el-button>
        <el-button type="primary" @click="submitAddForm">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
export default {
  data() {
    return {
      keywords: "",
      hrs: [],
      selectedRoles: [],
      allroles: [],
      dialogVisible: false,
      // 添加用户的表单
      hrForm: {
        name: "",
        username: "",
        phone: "",
        telephone: "",
        password: ""
      },
      rules: {
        name: [{ required: true, message: "请输入姓名", trigger: "blur" }],
        username: [
          { required: true, message: "请输入用户名", trigger: "blur" }
        ],
        phone: [{ required: true, message: "请输入手机号", trigger: "blur" }],
        telephone: [
          { required: true, message: "请输入分店电话", trigger: "blur" }
        ],
        password: [{ required: true, message: "请输入密码", trigger: "blur" }]
      }
    };
  },
  mounted() {
    this.initHrs();
  },
  methods: {
    deleteHr(hr) {
      this.$confirm("此操作将永久删除【" + hr.name + "】, 是否继续?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      })
        .then(() => {
          this.deleteRequest("/system/hr/" + hr.id).then(resp => {
            if (resp) {
              this.initHrs();
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
    doSearch() {
      this.initHrs();
    },
    hidePop(hr) {
      let roles = [];
      Object.assign(roles, hr.roles);
      let flag = false;
      if (roles.length != this.selectedRoles.length) {
        flag = true;
      } else {
        for (let i = 0; i < roles.length; i++) {
          let role = roles[i];
          for (let j = 0; j < this.selectedRoles.length; j++) {
            let sr = this.selectedRoles[j];
            if (role.id == sr) {
              roles.splice(i, 1);
              i--;
              break;
            }
          }
        }
        if (roles.length != 0) {
          flag = true;
        }
      }
      if (flag) {
        let url = "/system/hr/role?hrid=" + hr.id;
        this.selectedRoles.forEach(sr => {
          url += "&rids=" + sr;
        });
        this.putRequest(url).then(resp => {
          if (resp) {
            this.initHrs();
          }
        });
      }
    },
    showPop(hr) {
      this.initAllRoles();
      let roles = hr.roles;
      this.selectedRoles = [];
      roles.forEach(r => {
        this.selectedRoles.push(r.id);
      });
    },
    enabledChange(hr) {
      delete hr.roles;
      this.putRequest("/system/hr/", hr).then(resp => {
        if (resp) {
          this.initHrs();
        }
      });
    },
    initAllRoles() {
      this.getRequest("/system/hr/roles").then(resp => {
        if (resp) {
          this.allroles = resp;
        }
      });
    },
    initHrs() {
      this.getRequest("/system/hr/?keywords=" + this.keywords).then(resp => {
        if (resp) {
          this.hrs = resp;
        }
      });
    },
    // 添加登录用户
    doadd() {
      this.dialogVisible = true;
    },
    // 取消添加用户
    cancelAdd() {
      this.dialogVisible = false;
      this.initHrs();
      this.$refs["hrForm"].resetFields();
    },
    // 提交添加用户的表单
    submitAddForm() {
      this.$refs["hrForm"].validate(valid => {
        if (valid) {
          this.postRequest("/hr/insertHr", this.hrForm).then(resp => {
            if (resp) {
              this.dialogVisible = false;
              this.$refs["hrForm"].resetFields();
              this.initHrs();
            }
          });
        } else {
          this.$message.error("请输入信息");

          return false;
        }
      });
    }
  }
};
</script>

<style>
.userinfo-container div {
  font-size: 12px;
  color: #409eff;
}

.userinfo-container {
  margin-top: 20px;
}

.img-container {
  width: 100%;
  display: flex;
  justify-content: center;
}

.userface-img {
  width: 72px;
  height: 72px;
  border-radius: 72px;
}

.hr-container {
  margin-top: 10px;
  display: flex;
  flex-wrap: wrap;
  justify-content: space-around;
}

.hr-card {
  width: 350px;
  margin-bottom: 20px;
}
</style>