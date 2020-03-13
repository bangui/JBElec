<template>
    <div id="mainchart">
        <el-row >
            <top-header></top-header>
            <el-col :span="24">
                <el-col :span="6">
                  <side-nav></side-nav>
                </el-col>
                <el-col :span="12">
                  <middle-map></middle-map>
                </el-col>
                <el-col :span="6">
                  <right-nav></right-nav>
                </el-col>
            </el-col>
        </el-row>
    </div>
</template>

<script>
  import TopHeader from './top-header.vue';
  import SideNav from './side-nav.vue';
  //import MiddleMap from './middle-map.vue';
  import MiddleMap from './pages/map_style2.vue';
  //import MiddleMap from './pages/hybrid_map';
  import RightNav from './right-nav.vue';

  export default {
      name: 'mainchart',
      components:{
        TopHeader,
        SideNav,
        MiddleMap,
        RightNav
      },
      data() {
          return {
          };
      },
  }
</script>

<style>
    body {
        margin: 0;
        padding: 0;
    }
</style>
