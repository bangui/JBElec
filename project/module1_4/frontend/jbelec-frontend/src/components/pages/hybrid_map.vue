<template>
  <baidu-map class="map" :center="{lng: 116.404, lat: 40.515}" :zoom="8" :scroll-wheel-zoom="true" :mapStyle="mapStyle" mapType="BMAP_HYBRID_MAP">
    <bm-boundary name="河北省秦皇岛市" :strokeWeight="3" strokeColor="blue" fillOpacity='0.1' fillColor='#6f79ff'></bm-boundary>
    <bm-boundary name="河北省廊坊市" :strokeWeight="3" strokeColor="blue" fillOpacity='0.1' fillColor='#a68fff'></bm-boundary>
    <bm-boundary name="河北省张家口市" :strokeWeight="3" strokeColor="blue" fillOpacity='0.1' fillColor='#c89bff'></bm-boundary>
    <bm-boundary name="河北省唐山市" :strokeWeight="3" strokeColor="blue" fillOpacity='0.1' fillColor='#a89cff'></bm-boundary>
    <bm-boundary name="河北省承德市" :strokeWeight="3" strokeColor="blue" fillOpacity='0.1' fillColor='#8074ff'></bm-boundary>
    <bm-boundary name="北京市" :strokeWeight="2" strokeColor="red" fillColor='#ff7ba3'></bm-boundary>
    <bm-overview-map anchor="BMAP_ANCHOR_BOTTOM_RIGHT" :isOpen="true"></bm-overview-map>

    <bml-heatmap :data="stationdata" :max="100" :radius="20"></bml-heatmap>
    <bml-curve-line :points="points1" :editing="true" strokeColor='#9b0957' strokeOpacity='1'></bml-curve-line>
    <bml-curve-line :points="points2" :editing="true" strokeColor='#dbce38' strokeOpacity='1'></bml-curve-line>
    <bml-curve-line :points="points3" :editing="true" strokeColor='#1d4702' strokeOpacity='1'></bml-curve-line>

  </baidu-map>
</template>
<script>
  import {BmlHeatmap} from 'vue-baidu-map'
  import {BmlCurveLine} from 'vue-baidu-map'
export default {
  components: {
      BmlHeatmap,
      BmlCurveLine
    },
  data () {
    return {
      PowerLevel:['交流110kV','交流220kV','交流500kV','交流35kV','交流10kV','直流35kV','直流30kV','交流1000kV'],
      stationdataWithlevel:[],
      stationdata:[],
      origindata:[],

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
        {lng:118.5870643009,lat:39.2366071434},
        {lng:119.5176972, lat:40.02698083},
        {lng: 117.310791, lat: 41.003419},
        {lng:117.9697837303,lat:40.9578450374},

      ],
      points3:[
        {lng:118.5870643009,lat:39.2366071434},
        {lng:118.51, lat:40.0},
        {lng:118.8,lat:40.9},
        {lng:117.1870643009,lat:41.6366071434}

      ],
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
      }
    }
  },
  methods: {
    divideData(origindata,f) { //f返回对象的某个指定属性的属性值并存放在数组中
      let groups= {};
      origindata.forEach(function(o){ // o是每个元素
        var group = JSON.stringify(f(o));// PowerLevel为key
        groups[group] = groups[group] || [];//按PowerLevel来分组
        groups[group].push(o); // 把list中每个对象压入数组中作为value
      })
      return groups;
      /*
      return Obejct.keys(groups).map(function(group)) { // 取出groups对象中的所有key，然后边离一个一个key组成的新数组，返回分好了组的二维数组
        return groups[group];
      }
      */
    },
    test() {
      let groups= {};
      this.origindata.forEach(function(o){ // o是每个元素
        var group = o.power_LEVEL;// PowerLevel为key
        groups[group] = groups[group] || [];//按PowerLevel来分组
        groups[group].push(o); // 把list中每个对象压入数组中作为value
      })
      console.log(groups);
      console.log(groups[this.PowerLevel[0]]);
      return groups;
    },
 },
  created(){
    /*
       // 绑定全局事件globalEvent事件，
      this.$bus.$on('globalEvent',(val)=>{
           this.stationdata = val;
           console.log(this.stationdata);
      }),
    */
      this.$bus.$on('Event1',(val)=>{
           this.origindata = val;
           this.test();
      })

  }
}

</script>
<style>
  .map{
     width: 100%;
     height: 700px;
  }
</style>
