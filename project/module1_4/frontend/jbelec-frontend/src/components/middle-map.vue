<template>
    <div>
<div class="chart" id="mapChart"></div>
    </div>
</template>
<script>
    import geoJson from '@/assets/Echarts/NBmap.json'

export default{
    data() {
            return {
              stationdata:[],

            }
            },

    methods:{
        drawMapChart(){
             //初始化echarts实例

             this.$echarts.registerMap('NBmap', geoJson,{})
             var myChart = this.$echarts.init(document.getElementById('mapChart'));
             var data = [
             {name: '土门子变电站', value: 9},
             {name: '刘田庄变电站', value: 12},
             {name: '燕大变电站', value: 12},
             {name: '娄杖子变电站', value: 12}];
             var geoCoordMap = {
                 '土门子变电站':[119.1332822,40.47500918],
                 '刘田庄变电站':[119.0070982,39.8326443],
                 '燕大变电站':[119.511289,39.90729717],
                 '娄杖子变电站':[118.7804827,40.33575862]};
             var convertData = function (data) {
                 var res = [];
                 for (var i = 0; i < data.length; i++) {
                     var geoCoord = geoCoordMap[data[i].name];
                     if (geoCoord) {
                         res.push({
                             name: data[i].name,
                             value: geoCoord.concat(data[i].value)
                         });
                     }
                 }
                 return res;
             };

             var option = {

                 tooltip: {
                     trigger: 'item'
                 },

                 series: [
                     {
                     	name: '北京河北五市',
                         type: 'map',
                         mapType: 'NBmap',
                         aspectScale: 0.85,  //地图长度比
                         label: {
                             normal: {
                               formatter: '{b}',
                               position: 'right',
                                 show: true,
                                 textStyle: {
                                     color: '#fff'
                                 }
                             },
                             emphasis: {
                                 show: true,
                                 textStyle: {
                                     color: '#fff'
                                 }
                             }
                         },
                         roam: true,
                         itemStyle: {
                             normal: {
                                 color: '#F4E925',
                                 areaColor: 'transparent',
                                 borderColor: '#3fdaff',
                                 borderWidth: 2,
                                 shadowColor: 'rgba(63, 218, 255, 0.5)',
                                 shadowBlur: 30
                             },
                             emphasis: {
                                 areaColor: '#2B91B7',
                                 color: '#fff'
                             }
                         },
                         data: convertData(data),
                     }
                 ],
             };

             myChart.setOption(option);
      }
    },
    created(){
         // 绑定全局事件globalEvent事件，
        this.$bus.$on('globalEvent',(val)=>{
             this.stationdata = val;
             console.log(this.stationdata);
        })
    },
    mounted(){
      this.drawMapChart();
    }
}
</script>
<style>
.chart{
    height:500px;
}</style>
