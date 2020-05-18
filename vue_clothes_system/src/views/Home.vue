<template>
  <div>
    <el-container class="home_container">
      <el-header class="homeHeader">
        <div class="title">洁神洗衣店</div>
        <div>
          <el-button
            icon="el-icon-bell"
            type="text"
            style="margin-right: 8px;color: #fff;"
            size="normal"
            @click="goChat"
          >发信息</el-button>
          <el-button
            icon="el-icon-alarm-clock"
            type="text"
            style="margin-right: 8px;color: #fff;"
            size="normal"
            @click="goClockIn"
          >打卡</el-button>
          <el-dropdown class="userInfo" @command="commandHandler">
            <span class="el-dropdown-link">
              {{user.name}}
              <i>
                <img :src="user.userface" alt />
              </i>
            </span>
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item command="userinfo">个人中心</el-dropdown-item>
              <el-dropdown-item command="setting">设置</el-dropdown-item>
              <el-dropdown-item command="logout" divided>注销登录</el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>
        </div>
      </el-header>
      <el-container>
        <el-aside :width="isCollapse ? '64px':'200px'">
          <div class="toggle_button" @click="toggleCollapse">|||</div>
          <el-menu
            background-color="#333744"
            text-color="#fff"
            active-text-color="#007ACC"
            :unique-opened="true"
            :collapse-transition="false"
            :collapse="isCollapse"
            :router="true"
          >
            <el-submenu :index="index+''" v-for="(item,index) in routes" :key="index">
              <template slot="title">
                <i style="color: #409eff;margin-right: 5px" :class="item.iconCls"></i>
                <span>{{item.name}}</span>
              </template>
              <el-menu-item
                :index="child.path"
                v-for="(child,indexj) in item.children"
                :key="indexj"
              >
                <i style="color: #409eff;margin-right: 5px" :class="child.iconCls"></i>
                {{child.name}}
              </el-menu-item>
            </el-submenu>
          </el-menu>
        </el-aside>
        <el-main>
          <el-breadcrumb
            separator-class="el-icon-arrow-right"
            v-if="this.$router.currentRoute.path!='/home'"
          >
            <el-breadcrumb-item :to="{ path: '/home' }">首页</el-breadcrumb-item>
            <el-breadcrumb-item>{{this.$router.currentRoute.name}}</el-breadcrumb-item>
          </el-breadcrumb>
          <el-card class="box-card">
            <div class="homeWelcome" v-if="this.$router.currentRoute.path=='/home'">
              <div class="protitle">
                <p style="font-size:30px;backgrond:#f8c291">洗衣进度</p>
              </div>
             
              <div id="box">
                <div
                  id="con1"
                  ref="con1"
                  :class="{anim:animate==true}"
                  @mouseenter="mEnter"
                  @mouseleave="mLeave"
                >
                  <p
                    v-for="item in items"
                    :key="item.clothesId"
                  >{{item.cusName}}--{{item.clothesNum}}--{{item.typeName}}--{{item.progress}}</p>
                </div>
              </div>
            </div>
            <router-view class="homeRouterView" />
          </el-card>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>
<script>
export default {
  name: "Home",
  data() {
    return {
      // 控制菜单折叠还是全部显示.默认是false ，不折叠
      isCollapse: false,
      // user: JSON.parse(window.sessionStorage.getItem("user"))
      animate: false,
      items: [],
      count: 789,
      loading: false,
      msg: []
    };
  },
  computed: {
    routes() {
      return this.$store.state.routes;
    },
    user() {
      return this.$store.state.currentHr;
    }
  },
  methods: {
    goChat() {
      this.$router.push("/chat");
    },
    // 跳到 打卡页面
    goClockIn() {
      this.$router.push("/clock");
    },
    // 控制折叠的方法
    toggleCollapse() {
      this.isCollapse = !this.isCollapse;
    },
    commandHandler(cmd) {
      if (cmd == "logout") {
        this.$confirm("此操作将注销登录, 是否继续?", "提示", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        })
          .then(() => {
            this.getRequest("/logout");
            window.sessionStorage.removeItem("user");
            this.$store.commit("initRoutes", []);
            this.$router.replace("/");
          })
          .catch(() => {
            this.$message({
              type: "info",
              message: "已取消操作"
            });
          });
      } else if (cmd == "userinfo") {
        this.$router.push("/hrinfo");
      }
    },
    // 控制折叠的方法
    toggleCollapse() {
      this.isCollapse = !this.isCollapse;
    },
    scroll() {
      this.$nextTick(callback => {
        let con1 = this.$refs.con1;
        //console.log(con1)
        con1.style.marginTop = "-40px";
        this.animate = !this.animate;
        var that = this; // 在异步函数中会出现this的偏移问题，此处一定要先保存好this的指向
        setTimeout(function() {
          that.items.push(that.items[0]);
          that.items.shift();
          con1.style.marginTop = "0px";
          that.animate = !that.animate; // 这个地方如果不把animate 取反会出现消息回滚的现象，此时把ul 元素的过渡属性取消掉就可以完美实现无缝滚动的效果了
        }, 500);
      });
    },
    mEnter() {
      clearInterval(this.timer1);
    },
    mLeave() {
      this.timer1 = setInterval(this.scroll, 3000);
    },
    listClothes() {
      this.getRequest("/basic/clothes/listClothesPro").then(resp => {
        if (resp) {
          this.items = resp.obj;
          this.$nextTick(callback => {
            setInterval(this.scroll, 3000);
          });
        }
      });
    },
    load() {
      this.getRequest("/msg/basic/listMsg").then(resp => {
        if (resp) {
          this.msg = resp.obj;
          console.log(this.msg);
        }
      });
    }
  },
  created() {
    this.listClothes();
  }
};
</script>
<style lang="less" scoped>
.homeRouterView {
  margin-top: 10px;
}

.homeWelcome {
  text-align: center;
  font-size: 25px;
  font-family: 华文行楷;
  color: black;
  padding-top: 50px;
  position: relative;
}

.homeHeader {
  background-color: #373d41;
  display: flex;
  align-items: center;
  justify-content: space-between;
  padding: 0px 15px;
  box-sizing: border-box;
}

.homeHeader .title {
  font-size: 30px;
  font-family: 华文行楷;
  color: #ffffff;
}

.homeHeader .userInfo {
  cursor: pointer;
}

.el-dropdown-link img {
  width: 48px;
  height: 48px;
  border-radius: 24px;
  margin-left: 8px;
}

.el-dropdown-link {
  display: flex;
  align-items: center;
  color: #fff;
}
.home_container {
  height: 100vh;
}
.toggle_button {
  background-color: #373d41;
  font-size: 10px;
  line-height: 24px;
  color: #fff;
  letter-spacing: 0.2em;
  text-align: center;
  cursor: pointer;
}
.el-aside {
  background-color: #333744;
  border-right: none;
}
.el-main {
  background-color: #eaedf1;
}
.el-card {
  margin-top: 10px;
  height: 95%;
}
* {
  margin: 0;
  padding: 0;
}
#box {
  width: 700px;
  height: 500px;
  line-height: 40px;
  overflow: hidden;
  padding-left: 30px;
  transition: all 0.5s;
   margin-left: 230px;
}
.anim {
  transition: all 0.5s;
}
#con1 li {
  list-style: none;
  line-height: 30px;
  height: 30px;
}
.protitle {
  width: 700px;
  line-height: 50px;
  overflow: hidden;
  padding-left: 30px;
  margin-bottom: 30px;
  margin-left: 230px;
 
}

</style>