<template>
  <div>
  <h1>图表区</h1>
  <h1>{{stationlist[0]}}</h1>
  </div>

</template>

<script>
  export default{
    name: 'right-nav',
    data(){
      return {
        stationlist:[],
        fiber:[],
        protect:[],
      }
    },
    created(){
      console.log("右侧栏收到了数据")
         // 绑定全局事件globalEvent事件，
        this.$bus.$on('globalEvent',(val)=>{
           this.stationlist = val;
           console.log(this.stationlist);
        })
    }
 }
</script>

<style>
</style>
