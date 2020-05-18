<template>
  <div>
    <div class="main">
      <div class="content">
        <div class="box">
          <div class="left">
            <span style=" color: red;">*&nbsp;</span>
            <span>手机号</span>
          </div>
          <div class="right">
            <el-select
              v-model="cusPhone"
              filterable
              @change="findMember"
              style="width:400px"
              placeholder="请选择或搜索手机号"
            >
              <el-option
                v-for="item in memberInfo"
                :key="item.memberId"
                :label="item.customer.cusPhone"
                :value="item.customer.cusPhone"
              ></el-option>
            </el-select>
          </div>
        </div>
        <div class="box">
          <div class="left">
            <span style=" color: red;">*&nbsp;</span>
            <span>会员号</span>
          </div>
          <div class="right">
            <el-input v-model="form.out_trade_no" v-bind:disabled="flag"></el-input>
          </div>
        </div>
        <div class="box">
          <div class="left">
            <span style=" color: red;">*&nbsp;</span>
            <span>会员类型</span>
          </div>
          <div class="right">
            <el-select
              v-model="form.typeId"
              placeholder="请选择会员类型"
              v-bind:disabled="flag1"
              style="width:400px"
              @change="selectMoney"
            >
              <el-option
                v-for="item in membertype"
                :key="item.typeId"
                :label="item.typeName"
                :value="item.typeId"
              ></el-option>
            </el-select>
          </div>
        </div>
        <div class="box">
          <div class="left">
            <span style=" color: red;">*&nbsp;</span>
            <span>会员余额</span>
          </div>
          <div class="right">
            <el-input v-model="form.balance" v-bind:disabled="flag"></el-input>
          </div>
        </div>
        <div class="box">
          <div class="left">
            <span style=" color: red;">*&nbsp;</span>
            <span>充值金额</span>
          </div>
          <div class="right">
            <el-input v-model="form.total_amount" v-bind:disabled="flag"></el-input>
          </div>
        </div>

        <div style=" margin-top: 20px; margin-left: 85px;">
          <el-button type="primary" @click="onSubmit">立即充值</el-button>
          <el-button type="warning" @click="changeType">更改会员类型</el-button>
          <el-button type="info" @click="cancelUp">取消</el-button>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  data() {
    return {
      form: {
        subject: "",
        total_amount: "",
        out_trade_no: "",
        balance: "",
        cusId: "",
        memberId: "",
        typeId: ""
      },
      cusPhone: "",
      flag: true,
      flag1: true,
      memberInfo: [],
      membertype: [],
      //参数对象
      paramter: {}
    };
  },
  methods: {
    //   立即充值
    onSubmit() {
      this.postRequest("/order/upMem", this.form).then(resp => {
        if (resp) {
          const divForm = document.getElementsByTagName("divform");
          if (divForm.length) {
            document.body.removeChild(divForm[0]);
          }
          const div = document.createElement("divform");
          div.innerHTML = resp; // data就是接口返回的form 表单字符串
          document.body.appendChild(div);
          document.forms[0].setAttribute("target", "_blank"); // 新开窗口跳转
          document.forms[0].submit();
          this.$router.push("/mem/info");
        }
      });
    },

    // 查询所有的会员顾客
    listMember() {
      this.getRequest("member/basic/listMember").then(resp => {
        if (resp) {
          this.memberInfo = resp.obj;
          //console.log(this.memberInfo);
        }
      });
    },
    // 会员类型
    listMemberType() {
      this.getRequest("/member/type/listMemberType").then(resp => {
        if (resp) {
          //console.log(resp);
          this.membertype = resp.obj;
        }
      });
    },
    // 根据手机号查询会员信息
    findMember() {
      this.getRequest(
        "member/basic/findMemberByPhone?phone=" + this.cusPhone
      ).then(resp => {
        if (resp) {
          console.log(resp.obj);
          this.form.out_trade_no = resp.obj.memberNum;
          this.form.subject = resp.obj.memberType.typeName;
          this.form.balance = resp.obj.balance;
          this.form.total_amount = resp.obj.memberType.rechargeAcount;
          this.form.cusId = resp.obj.customer.cusId;
          this.form.memberId = resp.obj.memberId;
          this.form.typeId = resp.obj.typeId;
        }
      });
    },
    // 更改会员类型
    changeType() {
      this.flag1 = false;
    },
    cancelUp() {
      this.$router.push("/mem/info");
    },
    // 查询该种会员充值的值
    selectMoney() {
      let typeId = this.form.typeId;
      if (typeId == 1) {
        this.form.total_amount = 0;
      } else if (typeId == 2) {
        this.form.total_amount = 100;
      } else if (typeId == 3) {
        this.form.total_amount = 200;
      } else if (typeId == 4) {
        this.form.total_amount = 300;
      } else if (typeId == 5) {
        this.form.total_amount = 500;
      } else if (typeId == 6) {
        this.form.total_amount = 1000;
      }
    }
  },
  created() {
    this.listMember();
    this.listMemberType();
    // 接受参数
    console.log(this.$route.query)
    this.paramter= this.$route.query;
    this.cusPhone = this.paramter.phone;
    this.form.typeId = this.paramter.typeId;
    this.form.total_amount = this.paramter.rechargeAcount;
    this.form.balance = this.paramter.balance;
    this.form.cusId = this.paramter.cusId;
    this.form.memberId = this.paramter.memberId;
    this.form.out_trade_no = this.paramter.memberNum

  }
};
</script>

<style lang="scss" scoped>
.main {
  .content {
    .box {
      width: 500px;
      display: flex;
      justify-content: flex-start;
      margin-top: 20px;
      .left {
        width: 85px;
        padding-top: 5px;
        font-size: 15px;
      }
      .right {
        width: 400px;
      }
    }
  }
}
</style>