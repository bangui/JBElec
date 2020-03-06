<template>
  <div>
    <div style="width: 250px" class="line-search">
        <div class="section-header">
            <span>光缆搜索</span>
        </div>
        <el-input v-model="lineValue" placeholder="输入光缆" icon="search" :on-icon-click="searchLine">
        </el-input>
    </div>
    <div style="width: 250px" class="tq-heat">
        <div class="section-header">
            <span>站点搜索</span>
        </div>
        <el-input v-model="stValue" placeholder="输入站点" icon="search" :on-icon-click="searchSt">
        </el-input>
    </div>
    <div style="width: 250px" class="tq-heat">
        <div class="section-header">
            <span>业务搜索</span>
        </div>
        <el-input v-model="ywValue" placeholder="输入业务" icon="search" :on-icon-click="searchYw">
        </el-input>
    </div>
   <div style="width: 250px" >
     <button@click = 'sendAjax'>查找所有站点</button>
  </div>
  </div>

</template>

<script>
  import axios from 'axios';
  export default{
    name: 'side-nav',
    data(){
      return {
        lineValue: '',
        stValue: '',
        ywValue: '',
        stationlist:[],
      }
    },
  methods:{
    searchLineAction() {
      console.log(this.lineValue);
      axios.get('http://127.0.0.1:8888/fiber/find/one',{params:{
        fiber_id: this.lineValue
      }}).then(res=>{
        console.log(res.data);
      })
    },
    searchStAction() {
      console.log(this.stValue);
      axios.get('http://127.0.0.1:8888/station/find/one',{params:{
        station_id: this.stValue
      }}).then(res=>{
        console.log(res.data);
        this.stationlist = [{lng:res.data.x,lat:res.data.y,count:50}];
        this.$bus.$emit('globalEvent',this.stationlist)
      })
    },
    searchYwAction() {
      console.log(this.ywValue);
      axios.get('http://127.0.0.1:8888/protect/find/one',{params:{
        protect_id: this.ywValue
      }}).then(res=>{
        console.log(res.data);
      })
    },
    sendAjax(){
      axios.get('http://127.0.0.1:8888/station/find/all')
      .then(res=>{
        console.log(res.data.slice(0,100));
        this.stationlist = res.data.map(function(v) {
            var obj = {};
            obj.lng = v.x;
            obj.lat = v.y;
            obj.count = 50;
            return obj;
        });
        this.$bus.$emit('globalEvent',this.stationlist)
       })
      .catch(err=>{
        console.log(err)
       })
    },
    searchLine() {
       let lid = this.lineValue;
       this.searchLineAction(lid);
    },
    searchSt() {
      let stno = this.stValue;
      this.searchStAction(stno);
    },
    searchYw(){
      let ywno = this.ywValue;
      this.searchYwAction(ywno);
    },
  }
 }
</script>

<style>
</style>
