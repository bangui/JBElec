<template>

<div>
<div>
  <el-button type="text" @click="dialogTableVisible = true">打开嵌套表格的 Dialog</el-button>
</div>
<div>
  <el-dialog title="变电站信息表" :visible.sync="dialogTableVisible">
     <div style="height:250px;overflow-y:scroll;overflow-x:none;">
       <mailTable :tableData="tableData" :tableStyle="{ width:'700px' }"></mailTable>
     </div>
  </el-dialog>
</div>
</div>
<!--
<div v-for="(item, index) in tableData" >
                    <table width="100%">
                        <tr> <th>Company</th><td>{{item.value}}</td></tr>
                    </table>
</div>
-->

</template>

<script>
  import mailTable from "./mailTable.vue"
  export default {
    components: {
      mailTable,
      },
      data(){
        return{
          tableData: [
            {key: '站点名称', value: '安阳市供电公司老局'},
            {key: '全局名称', value: '豫 安阳/'},
            {key: '简称', value: '安阳市供电公司老局'},
            {key: '所属区域', value: '安阳'},
            {key: '站点类型', value: '中心站'},
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
           dialogTableVisible: false,
          }
      },

    }
</script>

<style>
</style>
