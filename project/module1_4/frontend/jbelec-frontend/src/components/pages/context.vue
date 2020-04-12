<template>
  <div id="app"@contextmenu.prevent="onContextmenu">

  <el-button type="text" >打开菜单context</el-button>
<!--
 <div id="app" style="width:100vw;height:100vh" @contextmenu.prevent="onContextmenu"></div>
 -->

 </div>


</template>
<script>
export default {
  data() {
     return {
      //menuShow: false //v-show标识隐藏显示
     }
  },

  mounted (){
    // let _this = this;
    // document.addEventListener('click', function (e) {　　　　// 下面这句代码是获取 点击的区域是否包含你的菜单，如果包含，说明点击的是菜单以外，不包含则为菜单以内
    // let flag = e.target.contains(document.getElementsByClassName('menu-class')[0])
   //  console.log(flag)
    // if(!flag) return //菜单以内，返回
    // _this.menuShow = true //菜单以外
   //  })
  },

 methods: {
  onContextmenu(event) {
    console.log("sss");
   this.$contextmenu({
    items: [
     {
      label: "关联到资源系统",
      disabled: true ,
      onClick: () => {
       this.message = "关联到资源系统";
       console.log("关联到资源系统");
      }
     },
     { label: "查看站点属性"},
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
  }
 }
};
</script>
