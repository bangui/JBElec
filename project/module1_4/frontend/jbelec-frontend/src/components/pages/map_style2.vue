<template>
  <div>
    <baidu-map class="map" :center="{lng: 116.404, lat: 40.515}" :zoom="zoom" :scroll-wheel-zoom="true" :mapStyle="mapStyle">
        <bm-map-type :map-types="['BMAP_NORMAL_MAP', 'BMAP_HYBRID_MAP']" anchor="BMAP_ANCHOR_TOP_RIGHT"></bm-map-type>

        <bm-control>
          <button @click="addZoom(15)">缩放至最大</button>
          <button @click="addZoom(8)">还原</button>
          <button @click="addZoom(3)">缩放至最小</button>
        </bm-control>
        <div v-for = '(Level,index) in PowerLevel'>
          <div v-for = '(item,index) in groups[Level]'>
            <bm-marker :position="{lng:item.x, lat:item.y}" :dragging="false"@click = "LookDetail(item)">
              <bm-label :content="PowerLabel[item.power_LEVEL]":labelStyle="{color: 'red', fontSize : '12px'}"/>
            <!--
            <bm-context-menu>
            <bm-context-menu-item :callback="station_position" text="站点坐标"></bm-context-menu-item>
            <bm-context-menu-item :callback="station_position" text="站点属性"></bm-context-menu-item>
            <bm-context-menu-item :callback="station_business" text="承载业务"></bm-context-menu-item>
            </bm-context-menu>
            -->
            </bm-marker>
          </div>
        </div>

        <bm-info-window :show="infoWindow.show" @close="infoWindowClose" @open="infoWindowOpen" style="font-size: 14px":position="{lng:infoWindow.info.lng, lat:infoWindow.info.lat}">
              <p>站点名称：{{ infoWindow.info.name }}</p>
              <p>站点地址：{{ infoWindow.info.lng }}~{{ infoWindow.info.lat }}</p>
        </bm-info-window>



    <bm-boundary name="河北省秦皇岛市" :strokeWeight="3" strokeColor='blue' fillOpacity=0.5 fillColor='#a68fff'></bm-boundary>
    <bm-boundary name="河北省廊坊市" :strokeWeight="3" strokeColor='blue' fillOpacity=0.5 fillColor='#a68fff'></bm-boundary>
    <bm-boundary name="河北省张家口市" :strokeWeight="3" strokeColor='blue' fillOpacity=0.5 fillColor='#a68fff'></bm-boundary>
    <bm-boundary name="河北省唐山市" :strokeWeight="3" strokeColor='blue' fillOpacity=0.5 fillColor='#a89cff'></bm-boundary>
    <bm-boundary name="河北省承德市" :strokeWeight="3" strokeColor='blue' fillOpacity=0.5 fillColor='#a68fff'></bm-boundary>
    <bm-boundary name="北京市" :strokeWeight="2" strokeColor="red" fillColor='#ff7ba3'></bm-boundary>
    <bm-overview-map anchor="BMAP_ANCHOR_BOTTOM_RIGHT" :isOpen="true"></bm-overview-map>



    <bml-curve-line :points="points1" :editing="false" strokeColor='#9b0957' strokeOpacity=1></bml-curve-line>
    <bml-curve-line :points="points2" :editing="false" strokeColor='#c1701f' strokeOpacity=1></bml-curve-line>
    <bml-curve-line :points="points3" :editing="false" strokeColor='#1d4702' strokeOpacity=1></bml-curve-line>

  </baidu-map>
  </div>


</template>

<script>
  import {BmlHeatmap} from 'vue-baidu-map'
  import {BmlCurveLine} from 'vue-baidu-map'
  import axios from 'axios';

export default {
  components: {
      BmlHeatmap,
      BmlCurveLine
    },
  data () {
    return {
      //PowerLabel:{'交流110kV':1,'交流220kV':2,'交流500kV':3,'交流35kV':4,'交流10kV':5,'直流35kV':6,'直流30kV':7,'交流1000kV':8},
      PowerLabel:{'交流220kV':2,'交流500kV':3,'交流1000kV':8},
      PowerLevel:['交流220kV','交流500kV','交流1000kV'],
      //PowerLevel:['交流110kV','交流220kV','交流500kV','交流35kV','交流10kV','直流35kV','直流30kV','交流1000kV'],
      infoWindow: { // 集中器信息窗口
        show: false,
        info: {
          lat: '',
          lng: '',
          name: ''
        }
      },
      groups:{},
      origindata:[],
      zoom:8,
      markerPoint:{lng: 114.310791, lat: 41.003419},
      station1:{lng: 114.310791, lat: 41.003419},
      station2:{lng: 115.310791, lat: 40.003419},
      station3:{lng: 115.486419, lat: 40.877282},
      station4:{lng: 116.631234, lat: 41.177282},
      station5:{lng:118.8,lat:40.9},
      station6:{lng:117.1870643009,lat:41.6366071434},
      station7:{lng:118.18,lat:40.6},

      station8:{lng:119.5176972, lat:40.02698083},
      station9:{lng: 117.310791, lat: 41.003419},
      station10:{lng:117.9697837303,lat:40.9578450374},

      station11:{lng:118.5870643009,lat:39.2366071434},
      station12:{lng:118.51, lat:40.0},
      mapStyle: {
              styleJson: [
      {
                  "featureType": "all",
                  "elementType": "geometry",
                  "stylers": {
                      "hue": "#fefb9f",
                      "saturation": 90
                  }
                },
        ]
            },
      heatdata:[
        {lng: 116.418261, lat: 39.921984, count: 50},
        {lng: 116.423332, lat: 39.916532, count: 51},
        {lng: 116.419787, lat: 39.930658, count: 15}
      ],
      points1:[
        {lng: 114.310791, lat: 41.003419},
        {lng: 115.310791, lat: 40.003419},
        {lng: 115.486419, lat: 40.877282},
        {lng: 116.631234, lat: 41.177282},
        {lng:118.8,lat:40.9},
        {lng:117.1870643009,lat:41.6366071434},
        {lng:118.18,lat:40.6},
      ],
      points2:[
        {lng:119.5176972, lat:40.02698083},
        {lng: 117.310791, lat: 41.003419},
        {lng:117.9697837303,lat:40.9578450374},

      ],
      points3:[
        {lng:118.5870643009,lat:39.2366071434},
        {lng:118.51, lat:40.0},

      ],
      station1000kv:[
        {lng: 114.310791, lat: 41.003419},
        {lng: 115.310791, lat: 40.003419},
        {lng: 115.486419, lat: 40.877282},
        {lng: 116.631234, lat: 41.177282},


      ],
      station220kv:[
        {lng:119.5176972, lat:40.02698083},
        {lng: 117.310791, lat: 41.003419},
        {lng:117.9697837303,lat:40.9578450374},

      ],
      station500kv:[
        {lng:118.5870643009,lat:39.2366071434},
        {lng:118.51, lat:40.0},


      ],

    }
  },
  methods: {
        addZoom (level) {
          this.zoom = level
        },
        test() {
          let groups= {};
          this.origindata.forEach(function(o){ // o是每个元素
            var group = o.power_LEVEL;// PowerLevel为key
            groups[group] = groups[group] || [];//按PowerLevel来分组
            groups[group].push(o); // 把list中每个对象压入数组中作为value
          })
          //console.log(groups);
          //console.log(groups[this.PowerLevel[0]]);
          return groups;
        },
        LookDetail(item,target) {
          this.infoWindow.show = true;
          this.infoWindow.info.name = item.station_NAME;
          this.infoWindow.info.lng = item.x;
          this.infoWindow.info.lat = item.y;
          console.log(this.infoWindow);
          console.log("item");
          console.log(item);
        },
        infoWindowClose () {
            this.show = false
        },
        infoWindowOpen () {
            //这里有个问题纠结了很久，百度的信息窗口默认有个点击其他地方就消失的事件，我没有找到
            //并且信息窗口点击一次显示，一次消失
            //于是我加了一个100毫秒的定时器，保证每次点击地图都可以展示信息窗口
           setInterval(()=>{
             this.show = true
           },100)
        },
        clickHandler1000kv (e) {
              alert(`变电站坐标为：${e.point.lng}, ${e.point.lat} 1000kv变电站`);
            },
        clickHandler500kv (e) {
              alert(`变电站坐标为：${e.point.lng}, ${e.point.lat} 500kv变电站`);
            },
        clickHandler220kv (e) {
              alert(`变电站的坐标为：${e.point.lng}, ${e.point.lat} 220kv变电站`);
            },
        station_position (e) {
              console.log(e)
              alert(`${e.point.lng} / ${e.point.lat}`)
            },
        station_property1 (e) {
              alert(`1000kv变电站`)
            },
        station_business1 (e) {
              alert(`业务xxx`)
            },


  },
  created(){
      console.log("从后端获取数据...")
      axios.get('http://127.0.0.1:8888/station/find/all')
      .then(res=>{
        console.log(res.data.slice(0,100));
        this.stationlist = res.data.map(function(v) {
            var obj = {};
            obj.lng = v.x;
            obj.lat = v.y;
            obj.level = 50;
            return obj;
        });
        this.$bus.$emit('globalEvent',this.stationlist);
        this.$bus.$emit('Event1',res.data);
       })
      .catch(err=>{
        console.log(err)
       })
      this.$bus.$on('Event1',(val)=>{
           console.log("地图收到了数据");
           this.origindata = val;
           this.groups= this.test();
      })

  },
  mounted(){
      this.addZoom(level);
  }
}
</script>
<style>
  .map{
     width: 100%;
     height: 700px;
  }
</style>
