<template>
  <div style="display:flex;flex-direction: row;flex-wrap:wrap; justify-content:space-between">
    <div id="myChart" :style="{width: '50%', height: '300px'}"></div>
    <div id="myChart2" :style="{width: '50%', height: '300px'}"></div>
    <div id="myChart3" :style="{width: '50%', height: '300px'}"></div>
    <div id="myChart4" :style="{width: '50%', height: '300px'}"></div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      listData: [],
      //用于存储展示的数组
      takeClothes: [],
      // 营业额
      turnover: [],
      first: [],
      second: [],
      third: [],
      fourth: []
    };
  },

  methods: {
    // 收衣统计
    drawLine() {
      let url = "/basic/washedcloth/listClothes";
      this.getRequest(url).then(resp => {
        if (resp) {
          this.listData = resp;
          this.setchartsoption("myChart", this.listData.length);
        }
      });
    },
    listtakeCount() {
      this.getRequest("/basic/washedcloth/listTcCount").then(resp => {
        if (resp) {
          this.takeClothes = resp;
          //console.log(this.takeClothes)
          this.setchartsoption1("myChart2", this.takeClothes.length);
        }
      });
    },
    // 营业额
    listTurnover() {
      this.getRequest("/basic/washedcloth/listTurnover").then(resp => {
        if (resp) {
          this.turnover = resp;
          this.setchartsoption2("myChart3", this.turnover.length);
        }
      });
    },
    // 营业额对比图
    listIntervalTurn() {
      this.getRequest("/basic/washedcloth/listServicefall").then(resp => {
        if (resp) {
          this.first = resp.first;
          this.second = resp.second;
          this.third = resp.third;
          this.fourth = resp.fourth;
          this.setchartsoption3("myChart4");
        }
      });
    },
    // 收衣echarts 的定义
    setchartsoption(id, length) {
      var echarts = require("echarts");
      var myChart = echarts.init(document.getElementById(id));
      var data = this.getseries(id, length, this.listData);
      var data1 = this.getxAxis(id, length, this.listData);
      myChart.setOption({
        title: {
          text: "收衣日统计"
        },
        tooltip: {
          trigger: "axis",
          axisPointer: {
            type: "shadow",
            label: {
              backgroundColor: "#4bcffa"
            }
          }
        },
        xAxis: {
          name: "日期",
          data: data1.xAxisData,
          axisTick: {
            show: false
          },
          splitLine: {
            show: false
          },
          axisLabel: {
            interval: 0,
            rotate: 30
          },
          boundaryGap: false
        },
        yAxis: {
          name: "每日收衣量",
          axisTick: {
            show: false
          },
          splitLine: {
            show: false
          }
        },
        legend: {
          data: ["收取量"]
        },
        series: [
          {
            name: "收取量",
            type: "line",
            smooth: true,
            data: data.seriesData,
            lineStyle: {
              color: "#00b5ff",
              width: 1
            },
            areaStyle: {
              normal: {
                color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [
                  { offset: 0, color: "red" },
                  { offset: 0.5, color: "pink" },
                  { offset: 1, color: "black" }
                ])
              }
            },
            itemStyle: {
              color: "rgb(255, 70, 131)",
              opacity: 0 //为0不会绘制图形拐点消失
            }, //拐点的样式
            markPoint: {
              data: [
                {
                  name: "最大值",
                  type: "max"
                }
              ]
            }
          }
        ]
      });
      myChart.resize();
    },
    getseries(id, length, data) {
      var seriesData = [];
      for (var i = 0; i < length; i++) {
        seriesData.push({
          value: data[i].clothCount
        });
      }
      return {
        seriesData: seriesData
      };
    },
    getxAxis(id, length, data) {
      var xAxisData = [];
      for (var j = 0; j < length; j++) {
        xAxisData.push({
          value: data[j].dateTime
        });
      }
      return {
        xAxisData: xAxisData
      };
    },
    // 取衣echarts 的定义
    setchartsoption1(id, length) {
      let echarts = require("echarts");
      let myChart2 = echarts.init(document.getElementById(id));
      let data = this.getseries1(id, length, this.takeClothes);
      let data1 = this.getxAxis1(id, length, this.takeClothes);
      myChart2.setOption({
        title: {
          text: "取衣日统计"
        },
        tooltip: {
          trigger: "axis",
          axisPointer: {
            type: "shadow",
            label: {
              backgroundColor: "#4bcffa"
            }
          }
        },
        xAxis: {
          name: "日期",
          data: data1.xAxisData,
          axisTick: {
            show: false
          },
          splitLine: {
            show: false
          },
          axisLabel: {
            interval: 0,
            rotate: 30
          },
          boundaryGap: false
        },
        yAxis: {
          name: "每日取衣量",
          axisTick: {
            show: false
          },
          splitLine: {
            show: false
          }
        },
        legend: {
          data: ["取衣量"]
        },
        series: [
          {
            name: "取衣量",
            type: "line",
            smooth: true,
            data: data.seriesData,
            lineStyle: {
              color: "#00b5ff",
              width: 1
            },
            areaStyle: {
              normal: {
                color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [
                  { offset: 0, color: "red" },
                  { offset: 0.5, color: "pink" },
                  { offset: 1, color: "black" }
                ])
              }
            },
            itemStyle: {
              color: "rgb(255, 70, 131)",
              opacity: 0 //为0不会绘制图形拐点消失
            }, //拐点的样式
            markPoint: {
              data: [
                {
                  name: "最大值",
                  type: "max"
                }
              ]
            }
          }
        ]
      });
      myChart2.resize();
    },
    getseries1(id, length, data) {
      var seriesData = [];
      for (var i = 0; i < length; i++) {
        seriesData.push({
          value: data[i].takeCount
        });
      }
      return {
        seriesData: seriesData
      };
    },
    getxAxis1(id, length, data) {
      var xAxisData = [];
      for (var j = 0; j < length; j++) {
        xAxisData.push({
          value: data[j].takeDate
        });
      }
      return {
        xAxisData: xAxisData
      };
    },
    // 营业额
    setchartsoption2(id, length) {
      let echarts = require("echarts");
      let myChart3 = echarts.init(document.getElementById(id));
      let data = this.getseries2(id, length, this.turnover);
      let data1 = this.getxAxis2(id, length, this.turnover);
      myChart3.setOption({
        title: {
          text: "日营业额统计"
        },
        tooltip: {
          trigger: "axis",
          axisPointer: {
            type: "shadow",
            label: {
              backgroundColor: "#4bcffa"
            }
          }
        },
        xAxis: {
          name: "日期",
          data: data1.xAxisData,
          axisTick: {
            show: false
          },
          splitLine: {
            show: false
          },
          axisLabel: {
            interval: 0,
            rotate: 30
          },
          boundaryGap: false
        },
        yAxis: {
          name: "每日营业额",
          axisTick: {
            show: false
          },
          splitLine: {
            show: false
          }
        },
        legend: {
          data: ["营业额"]
        },
        series: [
          {
            name: "营业额",
            type: "line",
            smooth: true,
            data: data.seriesData,
            lineStyle: {
              color: "#00b5ff",
              width: 1
            },
            areaStyle: {
              normal: {
                color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [
                  { offset: 0, color: "red" },
                  { offset: 0.5, color: "pink" },
                  { offset: 1, color: "black" }
                ])
              }
            },
            itemStyle: {
              color: "rgb(255, 70, 131)",
              opacity: 0 //为0不会绘制图形拐点消失
            }, //拐点的样式
            markPoint: {
              data: [
                {
                  name: "最大值",
                  type: "max"
                }
              ]
            }
          }
        ]
      });
      myChart3.resize();
    },
    getseries2(id, length, data) {
      var seriesData = [];
      for (var i = 0; i < length; i++) {
        seriesData.push({
          value: data[i].count
        });
      }
      return {
        seriesData: seriesData
      };
    },
    getseries3(id, length, data) {
      var seriesData = [];
      for (var i = length - 1; i >= 0; i--) {
        seriesData.push({
          value: data[i].count
        });
      }
      return {
        seriesData: seriesData
      };
    },
    getseries4(id, length, data) {
      var seriesData = [];
      for (var i = length - 1; i >= 0; i--) {
        seriesData.push({
          value: data[i].clothCount
        });
      }
      return {
        seriesData: seriesData
      };
    },
    getseries5(id, length, data) {
      var seriesData = [];
      for (var i = length - 1; i >= 0; i--) {
        seriesData.push({
          value: data[i].takeCount
        });
      }
      return {
        seriesData: seriesData
      };
    },
    getxAxis2(id, length, data) {
      var xAxisData = [];
      for (var j = 0; j < length; j++) {
        xAxisData.push({
          value: data[j].currdate
        });
      }
      return {
        xAxisData: xAxisData
      };
    },
    getxAxis3(id, length, data) {
      var xAxisData = [];
      for (var j = length - 1; j >= 0; j--) {
        xAxisData.push({
          value: data[j].takeDate
        });
      }
      return {
        xAxisData: xAxisData
      };
    },
    // 营业额对比展示
    setchartsoption3(id) {
      let echarts = require("echarts");
      let myChart4 = echarts.init(document.getElementById(id));
      let data1 = this.getseries5(id, this.first.length, this.first);
      let data2 = this.getseries4(id, this.second.length, this.second);
      let data3 = this.getseries3(id, this.third.length, this.third);
      let data4 = this.getseries3(id, this.fourth.length, this.fourth);
      let data5 = this.getxAxis3(id, this.first.length, this.first);

      console.log(data1);
      myChart4.setOption({
         title: {
          text: "日营业额统计"
        },
        color: ["#003366", "#006699", "#4cabce", "#e5323e"],
        tooltip: {
          trigger: "axis",
          axisPointer: {
            type: "shadow"
          }
        },
        legend: {
          data: ["取衣量", "收衣量", "赔偿量", "重洗量"]
        },
        toolbox: {
          show: true,
          orient: "vertical",
          left: "right",
          top: "center"
        },
        xAxis: [
          {
            type: "category",
            axisTick: { show: false },
            data: data5.xAxisData
          }
        ],
        yAxis: [
          {
            type: "value"
          }
        ],
        series: [
          {
            name: "取衣量",
            type: "bar",
            barGap: 0,
            data: data1.seriesData
          },
          {
            name: "收衣量",
            type: "bar",
            data: data2.seriesData
          },
          {
            name: "赔偿量",
            type: "bar",
            data: data3.seriesData
          },
          {
            name: "重洗量",
            type: "bar",
            data: data4.seriesData
          }
        ]
      });
      myChart4.resize();
    }
  },
  mounted() {
    this.drawLine();
    this.listtakeCount();
    this.listTurnover();
    this.listIntervalTurn();
  }
};
</script>

<style scoped>
</style>