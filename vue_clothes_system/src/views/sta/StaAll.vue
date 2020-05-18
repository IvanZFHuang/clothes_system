<template>
  <div style="text-align:center">
    <div id="myChart4" style="width: 80%; height:500px;margin-top:50px;margin-left:120px"></div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      first: [],
      second: [],
      third: [],
      fourth: []
    };
  },
  methods: {
    // 营业额对比图
    listIntervalTurn() {
      this.getRequest("/basic/washedcloth/listIntervalTurn").then(resp => {
        if (resp) {
          this.first = resp.first;
          this.second = resp.second;
          this.third = resp.third;
          this.fourth = resp.fourth;
          this.setchartsoption3("myChart4");
        }
      });
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
    // 营业额对比展示
    setchartsoption3(id) {
      let echarts = require("echarts");
      let myChart4 = echarts.init(document.getElementById(id));
      let data1 = this.getseries2(id, this.first.length, this.first);
      let data2 = this.getseries2(id, this.second.length, this.second);
      let data3 = this.getseries2(id, this.third.length, this.third);
      let data4 = this.getseries2(id, this.fourth.length, this.fourth);
      let data5 = this.getxAxis2(id, this.first.length, this.first);

      console.log(data1);
      myChart4.setOption({
        title: {
          text: "各店营业额对比"
        },
        color: ["#003366", "#006699", "#4cabce", "#e5323e"],
        tooltip: {
          trigger: "axis",
          axisPointer: {
            type: "shadow"
          }
        },
        legend: {
          data: ["第一分店", "第二分店", "第三分店", "第四分店"]
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
            name: "第一分店",
            type: "bar",
            barGap: 0,
            data: data1.seriesData
          },
          {
            name: "第二分店",
            type: "bar",
            data: data2.seriesData
          },
          {
            name: "第三分店",
            type: "bar",
            data: data3.seriesData
          },
          {
            name: "第四分店",
            type: "bar",
            data: data4.seriesData
          }
        ]
      });
      myChart4.resize();
    }
  },
  mounted() {
    this.listIntervalTurn();
  }
};
</script>

<style scoped>
</style>