<template>
  <div>
  <div>
  <el-button type="text" @click="dialogTableVisible = true">打开嵌套表格的 Dialog</el-button>
  <el-button type="text" @click="dialogFormVisible = true">打开嵌套表单的 Dialog</el-button>
  </div>

  <div>
  <el-dialog title="收货地址" :visible.sync="dialogTableVisible">
    <el-table :data="gridData"height="250">
      <el-table-column property="date" label="日期" width="150"></el-table-column>
      <el-table-column property="name" label="姓名" width="200"></el-table-column>
      <el-table-column property="address" label="地址"></el-table-column>
    </el-table>
  </el-dialog>
  </div>


     <el-dialog title="变电站信息表" :visible.sync="dialogFormVisible">
    <div style="height:250px;overflow-y:scroll;overflow-x:none;">
    <el-form :model="form" >
      <el-form-item label="站点名称" :label-width="formLabelWidth">
        <el-input :value="form.name" autocomplete="off":readonly="readonly"></el-input>
      </el-form-item>
      <el-form-item label="站点电压" :label-width="formLabelWidth">
        <el-input v-model="form.name" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="站点经度" :label-width="formLabelWidth">
        <el-input v-model="form.name" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="站点纬度" :label-width="formLabelWidth">
        <el-input v-model="form.name" autocomplete="off"></el-input>
      </el-form-item>
    </el-form>
    </div>
    <div slot="footer" class="dialog-footer">
      <el-button @click="dialogFormVisible = false">取 消</el-button>
      <el-button type="primary" @click="dialogFormVisible = false">确 定</el-button>
    </div>
  </el-dialog>

  <!--
  <el-dialog title="光缆信息表" :visible.sync="dialogFormVisible">
    <el-form :model="fiber">
      <el-form-item label="光缆名称" :label-width="formLabelWidth">
        <el-input :value="fiber.fiber_name" autocomplete="off":readonly="readonly"></el-input>
      </el-form-item>
      <el-form-item label="光缆电压" :label-width="formLabelWidth">
        <el-input v-model="fiber.power_level" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="所属区域" :label-width="formLabelWidth">
        <el-input v-model="form.auunit" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="起始站点" :label-width="formLabelWidth">
        <el-input v-model="form.stations_name[0]" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="终止站点" :label-width="formLabelWidth">
        <el-input v-model="form.stations_name[1]" autocomplete="off"></el-input>
      </el-form-item>
    </el-form>
    <div slot="footer" class="dialog-footer">
      <el-button @click="dialogFormVisible = false">取 消</el-button>
      <el-button type="primary" @click="dialogFormVisible = false">确 定</el-button>
    </div>
  </el-dialog>
  -->

  </div>
</template>

<script>
  export default {
      data() {
        return {
          gridData: [{
            date: '2016-05-02',
            name: '王小虎',
            address: '上海市普陀区金沙江路 1518 弄'
          }, {
            date: '2016-05-04',
            name: '王小虎',
            address: '上海市普陀区金沙江路 1518 弄'
          }, {
          }, {
            date: '2016-05-04',
            name: '王小虎',
            address: '上海市普陀区金沙江路 1518 弄'
          }, {
          }, {
            date: '2016-05-04',
            name: '王小虎',
            address: '上海市普陀区金沙江路 1518 弄'
          }, {
          }, {
            date: '2016-05-04',
            name: '王小虎',
            address: '上海市普陀区金沙江路 1518 弄'
          }, {
            date: '2016-05-01',
            name: '王小虎',
            address: '上海市普陀区金沙江路 1518 弄'
          }, {
            date: '2016-05-03',
            name: '王小虎',
            address: '上海市普陀区金沙江路 1518 弄'
          }],
          readonly:true,
          dialogTableVisible: false,
          dialogFormVisible: false,
          form: {
            name: 'asdas',
            region: '',
            date1: '',
            date2: '',
            delivery: false,
            type: [],
            resource: '',
            desc: ''
          },
          formLabelWidth: '120px'
        };
      }
    };
</script>

<style>
</style>
