<template>
  <div class="main">
    <!-- 非会员支付宝支付 -->
    <div class="content" v-if="ismem==1">
      <div class="box">
        <div class="left">
          <span style=" color: red;">*&nbsp;</span>
          <span>订单号</span>
        </div>
        <div class="right">
          <el-input v-model="payInfo.out_trade_no" size="small" placeholder="订单号..." />
        </div>
      </div>
      <div class="box">
        <div class="left">
          <span style=" color: red;">*&nbsp;</span>
          <span>订单名称</span>
        </div>
        <div class="right">
          <el-input v-model="payInfo.subject" size="small" placeholder="商品名称..." />
        </div>
      </div>
      <div class="box">
        <div class="left">
          <span style=" color: red;">*&nbsp;</span>
          <span>付款金额</span>
        </div>
        <div class="right">
          <el-input v-model="payInfo.total_amount" size="small" placeholder="付款金额..." />
        </div>
      </div>
      <div class="box">
        <div class="left">
          <span style=" color: red;">*&nbsp;</span>
          <span>订单描述</span>
        </div>
        <div class="right">
          <el-input
            v-model="payInfo.body"
            type="textarea"
            :autosize="{ minRows: 4, maxRows: 4}"
            placeholder="请输入内容"
            maxlength="200"
            show-word-limit
          />
        </div>
      </div>
      <div style=" margin-top: 20px; margin-left: 85px;">
        <el-button type="primary" @click="submit">去支付</el-button>
         <el-button  type="info" @click="cancel">取消</el-button>
      </div>
    </div>

    <!-- 会员直接扣会员的里的余额 -->
    <div class="content" v-if="ismem==2">
      <div class="box">
        <div class="left">
          <span style=" color: red;">*&nbsp;</span>
          <span>顾客姓名</span>
        </div>
        <div class="right">
          <el-input v-model="memPay.cusName" size="small" placeholder="订单号..." />
        </div>
      </div>
      <div class="box">
        <div class="left">
          <span style=" color: red;">*&nbsp;</span>
          <span>衣服类型</span>
        </div>
        <div class="right">
          <el-input v-model="memPay.clothesTypeName" size="small" placeholder="商品名称..." />
        </div>
      </div>
      <div class="box">
        <div class="left">
          <span style=" color: red;">*&nbsp;</span>
          <span>会员类型</span>
        </div>
        <div class="right">
          <el-input v-model="memPay.memTypeName" size="small" placeholder="付款金额..." />
        </div>
      </div>
      <div class="box">
        <div class="left">
          <span style=" color: red;">*&nbsp;</span>
          <span>会员余额</span>
        </div>
        <div class="right">
          <el-input v-model="memPay.balance" size="small" placeholder="付款金额..." />
        </div>
      </div>
      <div class="box">
        <div class="left">
          <span style=" color: red;">*&nbsp;</span>
          <span>付款金额</span>
        </div>
        <div class="right">
          <el-input v-model="memPay.realPrice" size="small" placeholder="付款金额..." />
        </div>
      </div>
      <div style=" margin-top: 20px; margin-left: 85px;">
        <el-button type="primary" @click="memSubmit">去支付</el-button>
        <el-button  type="info" @click="cancel">取消</el-button>
        <el-button  type="success" @click="bbs">会员充值</el-button>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  data() {
    return {
      //支付表单
      payInfo: {
        out_trade_no: "", //订单号
        subject: "", //订单名称
        total_amount: "", //付款金额
        body: "", //描述
        cusId: "",
        clothesId: ""
      },
      // 是否是会员
      ismem: 1,
      // 接受参数
      paramater: {},
      memPay: {
        cusName: "",
        clothesTypeName: "",
        memTypeName: "",
        balance: "",
        realPrice: "",
        cusId: "",
        clothesId: ""
      },
      memberId: ""
    };
  },
  methods: {
    submit() {
      // 添加之前先删除一下，如果单页面，页面不刷新，添加进去的内容会一直保留在页面中，二次调用form表单会出错
      this.postRequest("/order/alipay", this.payInfo).then(resp => {
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
        }
        this.payInfo = {};
      });
    },
    // 会员用户付款
    memSubmit() {
      if (this.memPay.balance < this.memPay.realPrice) {
        this.$message.error("余额不足，请充值");
      } else {
        this.postRequest("/basic/clothes/updateClothes", {
          clothesId: this.memPay.clothesId,
          realPrice: this.memPay.realPrice,
          memberId: this.memberId,
          cusId: this.memPay.cusId,
          clothesTypeName: this.memPay.clothesTypeName,
          balance:this.memPay.balance
        }).then(resp => {
          if (resp) {
            this.$router.push("/serve/wash");
          }
        });
      }
    },
    cancel(){
      this.$router.push("/serve/wash");
    },
    //会员充值
    bbs(){
     this.$router.push("/mem/up");
    }
  },
  mounted() {
    console.log(this.$route.query);
    if (this.$route.query.ismem == 1) {
      this.paramater = this.$route.query;
      this.payInfo.out_trade_no = this.paramater.clothesNum;
      this.payInfo.subject = this.paramater.typeName;
      this.payInfo.total_amount = this.paramater.realPrice;
      this.ismem = this.paramater.ismem;
      this.payInfo.cusId = this.paramater.cusId;
      this.payInfo.clothesId = this.paramater.clothesId;
    } else {
      this.paramater = this.$route.query;
      this.memPay.cusName = this.paramater.cusName;
      this.memPay.clothesTypeName = this.paramater.typeName;
      this.memPay.memTypeName = this.paramater.memberType;
      this.memPay.balance = this.paramater.balance;
      this.memPay.realPrice = this.paramater.realPrice;
      this.ismem = this.paramater.ismem;
      this.memberId = this.paramater.memberId;
      this.memPay.cusId = this.paramater.cusId;
      this.memPay.clothesId = this.paramater.clothesId;
    }
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
