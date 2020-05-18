<template>
  <div style="display: flex;flex-direction: row;flex-wrap:wrap;justify-content: flex-start">
    <div style="margin-left:20px;margin-bottom:20px" v-for="item in membertype" :key="item.id">
      <el-card class="box-card">
        <div slot="header" class="clearfix">
          <svg class="icon" aria-hidden="true">
            <use xlink:href="#icon-huiyuan-" />
          </svg>
          <span class="memName">{{item.typeName}}</span>
        </div>
        <div>
          <div
            style="display:flex; flex-direction: row;flex-wrap: wrap;justify-content:space-between"
          >
            <span class="min">
              最低充值金额&nbsp;&nbsp;
              <span class="money">￥&nbsp;{{item.rechargeAcount}}</span>
            </span>
            <span class="total">{{item.total}}</span>
          </div>
          <div style="margin-top:20px">
            <i class="iconfont icon-tequanhuiyuan"></i>
            <ol>
                <li v-for="(value,index) in item.remarks" :key="index">
                    {{value}}
                </li>
            </ol>
          </div>
        </div>
      </el-card>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      //存放所有的会员类型
      membertype: [],
      //   特权信息
      remark: []
    };
  },
  methods: {
    // 获取所有的会员信息
    listMemberType() {
      this.getRequest("/member/type/listMemberType").then(resp => {
        if (resp) {
          console.log(resp);
          this.membertype = resp.obj;
        }
      });
    }
  },
  created() {
    this.listMemberType();
  }
};
</script>

<style scoped>
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

.box-card {
  width: 380px;
  height: 320px;
}
.icon {
  width: 4em;
  height: 4em;
  vertical-align: -0.15em;
  fill: currentColor;
  overflow: hidden;
}
.memName {
  font-size: 2em;
  color: #0fb9b1;
}
.money {
  color: #eb3b5a;
  font-size: 20px;
}
.total {
  color: #0fb9b1;
  font-size: 20px;
}
.iconfont {
  font-size: 1.5em;
  color: #1e272e;
}
li{
    list-style-type:demical;
    color: #636e72;
    font-size: 17px;

}
.min{
    color: #636e72;
}
</style>