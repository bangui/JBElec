<template>
  <div>
    <baidu-map class="map" :center="{lng: 116.404, lat: 40.515}" :zoom="zoom" :scroll-wheel-zoom="true" :mapStyle="mapStyle">
        <bm-map-type :map-types="['BMAP_NORMAL_MAP', 'BMAP_HYBRID_MAP']" anchor="BMAP_ANCHOR_TOP_RIGHT"></bm-map-type>


        <bm-control>
          <button @click="addZoom(15)">缩放至最大</button>
          <button @click="addZoom(8)">还原</button>
          <button @click="addZoom(3)">缩放至最小</button>
        </bm-control>

        <!--站点节点-->
        <div v-for = '(Level,index) in checkedPowers'>
          <div v-for = '(item,index) in groupsStation[Level]'>

            <bm-marker :level="item.power_LEVEL":position="{lng:item.x, lat:item.y}" :dragging="false"@click = "LookSummary(item)"@rightclick="onContextmenu($event,item)">

              <bm-label :content="PowerLabel[item.power_LEVEL]":labelStyle="{color: 'red', fontSize : '12px'}"/>

            </bm-marker>

          </div>
        </div>


        <!--左键信息窗口，显示站点基础信息-->
        <div>
        <bm-info-window :show="infoWindow.show" @close="infoWindowClose" @open="infoWindowOpen" style="font-size: 14px":position="{lng:infoWindow.info.lng, lat:infoWindow.info.lat}">
              <p>站点名称：{{ infoWindow.info.name }}</p>
              <p>站点地址：{{ infoWindow.info.lng }}~{{ infoWindow.info.lat }}</p>
        </bm-info-window>
        </div>


        <!--站点电压复选框,参考checkbox.vue-->
        <div class="checkBox">
       <el-checkbox-group v-model="checkedPowers" @change="handleCheckedPowersChange">
         <el-checkbox v-for="power in powers" :label="power" :key="power">{{power}}</el-checkbox>
       </el-checkbox-group>
        </div>


        <!--右键菜单，单击查看站点属性出现后的对话框嵌套表格,参考table.vue和mailTable.vue-->
        <div>
          <el-dialog title="变电站信息表" :visible.sync="dialogTableVisible">
             <div style="height:250px;overflow-y:scroll;overflow-x:none;">
               <mailTable :tableData="tableData" :tableStyle="{ width:'700px' }"></mailTable>
             </div>
          </el-dialog>
        </div>

         <!-- 光缆线路 带电压等级版
        <div v-for = '(Level,index) in checkedPowers'>
          <div v-for = '(item,index) in groupsFiber[Level]'>
            <bml-curve-line :points="[{lng:geoStation[item.stations_ID[0]].x,lat:geoStation[item.stations_ID[0]].y},{lng:geoStation[item.stations_ID[1]].x,lat:geoStation[item.stations_ID[1]].y}]" :editing="false" strokeColor='#9b0957' strokeOpacity='1'></bml-curve-line>
          </div>
        </div>
        -->

        <!--光缆线路-->
        <div v-for = '(item,index) in originFiber'>
          <!--加一个站点电压的判断-->
          <bml-curve-line :points="[{lng:geoStation[item.stations_ID[0]].x,lat:geoStation[item.stations_ID[0]].y},{lng:geoStation[item.stations_ID[1]].x,lat:geoStation[item.stations_ID[1]].y}]"
          :editing="false" strokeColor='#9b0957' strokeOpacity='1'@click="onFiberContextmenu($event,item)">
          </bml-curve-line>
        </div>

         <!--故障上报表单-->
        <div>
          <el-dialog title="故障上报表单" :visible.sync="errorFormVisible"width="30%">
          <el-form ref="errorform" :model="errorform" label-width="100px">
            <el-form-item label="标题">
              <el-input v-model="errorform.title"></el-input>
            </el-form-item>
            <el-form-item label="缺陷现象描述">
                <el-input type="description" v-model="errorform.description"></el-input>
            </el-form-item>
            <el-form-item label="缺陷等级">
              <el-select v-model="errorform.level" placeholder="请选择缺陷等级">
                <el-option label="一级" value="一级"></el-option>
                <el-option label="二级" value="二级"></el-option>
                <el-option label="三级" value="三级"></el-option>
                <el-option label="四级" value="四级"></el-option>
              </el-select>
            </el-form-item>
            <el-form-item label="报告人员姓名">
              <el-select v-model="errorform.personname" placeholder="请选择报告人员">
                <el-option label="高鑫" value="高鑫"></el-option>
                <el-option label="张东波" value="张东波"></el-option>
                <el-option label="杨雪莲" value="杨雪莲"></el-option>
                <el-option label="杨锐浪" value="杨锐浪"></el-option>
              </el-select>
            </el-form-item>
            <el-form-item label="缺陷来源">
              <el-select v-model="errorform.source" placeholder="请选择报告人员">
                <el-option label="缺陷申报" value="缺陷申报"></el-option>
                <el-option label="实时监视" value="实时监视"></el-option>
                <el-option label="运行巡视" value="运行巡视"></el-option>
              </el-select>
            </el-form-item>

            <el-form-item>
              <el-button type="primary" @click="onSubmit">故障上报</el-button>
              <el-button>取消</el-button>
            </el-form-item>
          </el-form>

          <div slot="footer" class="dialog-footer">
            <el-button @click="errorFormVisible = false">取 消</el-button>
            <el-button type="primary" @click="errorFormVisible = false">确 定</el-button>
          </div>
        </el-dialog>
         </div>



    <bm-boundary name="河北省秦皇岛市" :strokeWeight="3" strokeColor='blue' fillOpacity="0.5" fillColor='#a68fff'></bm-boundary>
    <bm-boundary name="河北省廊坊市" :strokeWeight="3" strokeColor='blue' fillOpacity="0.5" fillColor='#a68fff'></bm-boundary>
    <bm-boundary name="河北省张家口市" :strokeWeight="3" strokeColor='blue' fillOpacity="0.5" fillColor='#a68fff'></bm-boundary>
    <bm-boundary name="河北省唐山市" :strokeWeight="3" strokeColor='blue' fillOpacity="0.5" fillColor='#a89cff'></bm-boundary>
    <bm-boundary name="河北省承德市" :strokeWeight="3" strokeColor='blue' fillOpacity="0.5" fillColor='#a68fff'></bm-boundary>
    <bm-boundary name="北京市" :strokeWeight="2" strokeColor="red" fillColor='#ff7ba3'></bm-boundary>
    <bm-overview-map anchor="BMAP_ANCHOR_BOTTOM_RIGHT" :isOpen="true"></bm-overview-map>


  </baidu-map>
  </div>



</template>

<script>
  const powerOptions = ['交流220kV','交流500kV','交流1000kV'];//光缆复选框的几种电压
  import {BmlHeatmap} from 'vue-baidu-map'
  import {BmlCurveLine} from 'vue-baidu-map'
  import axios from 'axios'
  import mailTable from "./mailTable.vue" //对话框里面的菜单项


export default {
  components: {
      BmlHeatmap,
      BmlCurveLine,
      mailTable
    },
  data () {
    return {
      // 复选框
      checkAll: false,  //复选框种默认勾选全部
      checkedPowers: ['交流220kV','交流500kV'], //复选框种默认被勾选的电压
      powers: powerOptions,
      isIndeterminate: true,

      // 故障表单
      errorFormVisible: false,
      errorform: {
        fiberid:'',
        title: 'asdas',
        level: '',
        personname: '',
        source: '',
        date1: '',
        date2: '',
      },
      // 查看光缆属性之对话框
      dialogFormVisible: false,
      // 查看站点属性之对话框
      dialogTableVisible: false,
      tableData: [
        {key: '站点名称', value: '安阳市供电公司老局'},
        {key: '全局名称', value: ''},
        {key: '简称', value: ''},
        {key: '所属区域', value: ''},
        {key: '站点类型', value: ''},
        {key: '电压等级', value: ''},
        {key: '地址', value: ''},
        {key: '邮政编码', value: ''},
        {key: '调度等级', value: ''},
        {key: '投运日期', value: ''},
        {key: '产权单位', value: ''},
        {key: '维护单位', value: ""},
        {key: '维护人', value: ''},
        {key: '联系电话', value: ''},
      ],
      formLabelWidth: '120px',

      imgUrl:require("../../assets/images/v1.png"),
      //PowerLevel:['交流110kV','交流220kV','交流500kV','交流35kV','交流10kV','直流35kV','直流30kV','交流1000kV'],// 原本所有的站点电压
      PowerLevelSt:['交流220kV','交流500kV','交流1000kV'], // 部分站点电压
      PowerLevelFi:['110kV','220kV','500kV','无','10kV','35kV','1000kV'], //所有的光缆电压
      PowerLabel:{'交流220kV':'1','交流500kV':'2','交流1000kV':'3'}, //站点电压Label

      // 左键站点集中器信息窗口
      infoWindow: {
        show: false,
        info: {
          lat: '',
          lng: '',
          name: ''
        }
      },

      //从后端接收和转换后的数据
      originStation:[], // 从后端接收的原始station数据
      originFiber:[], // 从后端接收的原始fiber数据
      groupsStation:{}, //转换的以电压分组的station数据
      //groupsFiber:{},//转换的以电压分组的fiber数据
      //geoFiber:{},
      geoStation:{},

      zoom:8,
      level:8,
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


    }
  },
  methods: {
        addZoom (level) {
          this.zoom = level
        },
        //表单提交
        onSubmit() {
            console.log('submit!');
            console.log(this.errorform);
            console.log("从前端提交故障表单数据...")
            axios('http://127.0.0.1:8888/alarm/',
            {params: {title:this.errorform.title,description:this.errorform.description,level:this.errorform.level,
            personname:this.errorform.personname,source:this.errorform.source,fiberid:this.errorform.fiberid}},
            {'xhrFields' : {withCredentials: true},crossDomain: true})
            .then(res=>{
              console.log(res.data);
             })
            .catch(err=>{
              console.log(err)
             })
          },
        //复选框
        handleCheckAllChange(val) {
          this.checkedPowers = val ? powerOptions : [];
          this.isIndeterminate = false;
        },
        handleCheckedPowersChange(value) {
          let checkedCount = value.length;
          this.checkAll = checkedCount === this.powers.length;
          this.isIndeterminate = checkedCount > 0 && checkedCount < this.powers.length;
        },

        onFiberContextmenu(event,item) {
           //console.log(item);
           //this.errorFormVisible = true;
        },

        //右键站点上下文菜单,参考context.vue
        onContextmenu(event,item) {
         this.tableData[0].value = item.station_NAME;
         this.tableData[5].value = item.power_LEVEL;
         console.log(item);
         this.$contextmenu({
          items: [
           {
           label: "故障上报",
           // disabled: true ,
            onClick: () => {
             this.message = "故障上报";
              this.errorFormVisible = true;
               this.errorform.fiberid = item.station_ID;
             console.log("故障上报");
            }

           },
           { label: "查看站点属性",
             onClick: () => {
              //this.dialogFormVisible = true;
              this.dialogTableVisible = true;
              console.log("查看站点属性");
              }
           },
           { label: "站点平面图", disabled: true ,divided: true, icon: "el-icon-refresh" },
           { label: "查看站内设备列表" },
           { label: "查看站内连接关系", icon: "el-icon-printer" },
           { label: "查看站点承载业务", divided: true },
           {
            label: "使用网页翻译(T)",
            divided: true,
            minWidth: 0,
            children: [{ label: "翻译成简体中文" }, { label: "翻译成繁体中文" }]
           },
           {
            label: "截取网页(R)",
            minWidth: 0,
            children: [
             {
              label: "截取可视化区域",
              onClick: () => {
               this.message = "截取可视化区域";
               console.log("截取可视化区域");
              }
             },
             { label: "截取全屏" }
            ]
           },
           { label: "查看网页源代码(V)", icon: "el-icon-view" },
           { label: "检查(N)" }
          ],
          event,
          customClass: "class-a",
          zIndex: 3,
          minWidth: 230
         });
         return false;
        },

        //转换从后端接收的原始数据station
        changeOriginStation() {
          let groups= {};
          let geoStation = {};//新增站点ID：站点
          this.originStation.forEach(function(o){ // o是每个元素
            var group = o.power_LEVEL;// PowerLevel为key
            var stationid = o.station_ID;
            geoStation[stationid] = o; //新增站点ID：站点
            groups[group] = groups[group] || [];//按PowerLevel来分组
            groups[group].push(o); // 把list中每个对象压入数组中作为value
          })
          //console.log(groups[this.PowerLevel[0]]);
          return {x:groups, y:geoStation};
        },
        /*
         //转换从后端接收的原始数据fiber
        changeOriginFiber() {
          let groups= {};
          let geoFiber = {};//新增光缆ID：光缆
          this.originFiber.forEach(function(o){ // o是每个元素
            var group = o.power_LEVEL;// PowerLevel为key
            var fiberid = o.fiber_ID;
            geoFiber[fiberid] = o; //新增光缆ID：光缆
            groups[group] = groups[group] || [];//按PowerLevel来分组
            groups[group].push(o); // 把list中每个对象压入数组中作为value
          })
          return {x:groups, y:geoFiber};
        },
        */
        //右键站点，menuShow控制上下文菜单显示与否
        LookDetail(item,target) {
          this.menuShow = true;
          console.log(this.menuShow);
        },
        //左键站点，简单信息窗口
        LookSummary(item,target) {
          this.infoWindow.show = true;
          this.infoWindow.info.name = item.station_NAME;
          this.infoWindow.info.lng = item.x;
          this.infoWindow.info.lat = item.y;
        },
        infoWindowClose () {
            this.show = false
        },
        infoWindowOpen () {
           setInterval(()=>{
             this.show = true
           },100)
        },
  },

  created(){
      console.log("从后端获取站点数据...")
      axios.get('http://127.0.0.1:8888/station/find/all')
      .then(res=>{
        console.log(res.data.slice(0,100));
        this.$bus.$emit('Event1',res.data);
       })
      .catch(err=>{
        console.log(err)
       })
      console.log("从后端获取光缆数据...")
      axios.get('http://127.0.0.1:8888/fiber/find/all')
      .then(res=>{
        console.log(res.data.slice(0,100));
        this.$bus.$emit('Event2',res.data);
       })
      .catch(err=>{
        console.log(err)
       })

      this.$bus.$on('Event1',(val)=>{
           console.log("地图收到了站点数据");
           this.originStation = val;
           var data = this.changeOriginStation();
           this.groupsStation= data.x;
           this.geoStation= data.y;
      })

      this.$bus.$on('Event2',(val)=>{
           console.log("地图收到了光缆数据");
           this.originFiber = val;
           /*
           var data = this.changeOriginFiber();
           this.groupsFiber = data.x;
           this.geoFiber = data.y;
           */
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
  .checkBox{
      position: absolute;
      top:40px;
      height:160px;
      width:30%;
      left:450px;
    }
</style>
