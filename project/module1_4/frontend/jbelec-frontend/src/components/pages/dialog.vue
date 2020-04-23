<template>
  <div>
  <div>
  <el-button type="text" @click="dialogTableVisible = true">打开嵌套检修票表格的 Dialog</el-button>
  <el-button type="text" @click="errorFormVisible = true">打开嵌套故障表单的 Dialog</el-button>
  <el-button type="text" @click="repairFormVisible = true">打开嵌套维修表单的 Dialog</el-button>
  <el-button type="text" @click="dialogVisible = true">点击打开 Dialog</el-button>
  </div>


  <div>
<el-dialog
  title="提示"
  :visible.sync="dialogVisible"
  width="30%"
  :before-close="handleClose">
  <span>这是一段信息</span>
  <span slot="footer" class="dialog-footer">
    <el-button @click="dialogVisible = false">取 消</el-button>
    <el-button type="primary" @click="dialogVisible = false">确 定</el-button>
  </span>
</el-dialog>
 </div>

 <div>
 <el-dialog title="检修票列表" :visible.sync="dialogTableVisible">
   <el-table :data="repairList">
     <el-table-column property="date" label="日期" width="150"></el-table-column>
     <el-table-column property="name" label="姓名" width="200"></el-table-column>
     <el-table-column property="address" label="地址"></el-table-column>
   </el-table>
 </el-dialog>
 </div>

  <div>
    <el-dialog title="维修上报表单" :visible.sync="repairFormVisible"width="30%">
    <el-form ref="repairform" :model="repairform" label-width="100px">
      <el-form-item label="维修票标题">
        <el-input v-model="repairform.title"></el-input>
      </el-form-item>
      <el-form-item label="检修工作内容">
          <el-input type="textarea" v-model="repairform.content"></el-input>
      </el-form-item>
      <el-form-item label="维修类别">
        <el-select v-model="repairform.repairlevel" placeholder="请选择检修类别">
          <el-option label="配合电网检修" value="配合电网检修"></el-option>
          <el-option label="通信网独立检修" value="通信网独立检修"></el-option>
          <el-option label="须电网配合" value="须电网配合"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="检修类型">
        <el-select v-model="repairform.checklevel" placeholder="请选择检修类型">
          <el-option label="临时检修" value="临时检修"></el-option>
          <el-option label="计划检修" value="计划检修"></el-option>
          <el-option label="检修" value="检修"></el-option>
        </el-select>
      </el-form-item>
        <el-form-item label="申请开工时间">
          <el-col :span="11">
            <el-date-picker type="date" placeholder="选择日期" v-model="repairform.apply_startdate" style="width: 100%;"></el-date-picker>
          </el-col>
          <el-col class="line" :span="2">-</el-col>
          <el-col :span="11">
            <el-time-picker placeholder="选择时间" v-model="repairform.apply_starttime" style="width: 100%;"></el-time-picker>
          </el-col>
        </el-form-item>
        <el-form-item label="申请完工时间">
          <el-col :span="11">
            <el-date-picker type="date" placeholder="选择日期" v-model="repairform.apply_enddate" style="width: 100%;"></el-date-picker>
          </el-col>
          <el-col class="line" :span="2">-</el-col>
          <el-col :span="11">
            <el-time-picker placeholder="选择时间" v-model="repairform.apply_endtime" style="width: 100%;"></el-time-picker>
          </el-col>
        </el-form-item>
        <el-form-item label="实际开工时间">
          <el-col :span="11">
            <el-date-picker type="date" placeholder="选择日期" v-model="repairform.actual_startdate" style="width: 100%;"></el-date-picker>
          </el-col>
          <el-col class="line" :span="2">-</el-col>
          <el-col :span="11">
            <el-time-picker placeholder="选择时间" v-model="repairform.actual_starttime" style="width: 100%;"></el-time-picker>
          </el-col>
        </el-form-item>
        <el-form-item label="实际完工时间">
          <el-col :span="11">
            <el-date-picker type="date" placeholder="选择日期" v-model="repairform.actual_enddate" style="width: 100%;"></el-date-picker>
          </el-col>
          <el-col class="line" :span="2">-</el-col>
          <el-col :span="11">
            <el-time-picker placeholder="选择时间" v-model="repairform.actual_endtime" style="width: 100%;"></el-time-picker>
          </el-col>
        </el-form-item>
      <el-form-item label="申请单位">
        <el-select v-model="repairform.unit" placeholder="请选择申请单位">
          <el-option label="唐山供电公司" value="缺陷申报"></el-option>
          <el-option label="冀北电力有限公司检修分公司" value="实时监视"></el-option>
          <el-option label="张家口供电公司" value="运行巡视"></el-option>
          <el-option label="廊坊供电公司" value="廊坊供电公司"></el-option>
          <el-option label="秦皇岛供电公司" value="秦皇岛供电公司"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="申请人">
        <el-select v-model="repairform.name" placeholder="请选择报告人员">
          <el-option label="王珏" value="王珏"></el-option>
          <el-option label="李波" value="李波"></el-option>
          <el-option label="李刚" value="李刚"></el-option>
          <el-option label="滑水亮" value="滑水亮"></el-option>
          <el-option label="武跃斌" value="武跃斌"></el-option>
          <el-option label="柳超" value="柳超"></el-option>
          <el-option label="孙涛" value="孙涛"></el-option>
        </el-select>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="onSubmit">故障上报</el-button>
        <el-button>取消</el-button>
      </el-form-item>
    </el-form>

    <div slot="footer" class="dialog-footer">
      <el-button @click="repairFormVisible = false">取 消</el-button>
      <el-button type="primary" @click="repairFormVisible = false">确 定</el-button>
    </div>
  </el-dialog>
   </div>


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
  import axios from 'axios'
  export default {
      data() {
        return {
          readonly:true,
          dialogTableVisible: false,
          repairFormVisible: false,
          errorFormVisible: false,
          errorform: {
            title: 'asdas',
            description:'',
            level: '',
            personname: '',
            source: '',
            date1: '',
            date2: '',
            delivery: false,
            type: [],
            resource: '',
            desc: ''
          },
          repairform: {
            title: '',
            content: '',
            repairlevel: '',
            checklevel: '',
            unit: '',
            name: '',
            apply_startdate:'',
            apply_starttime:'',
            apply_enddate:'',
            apply_endtime:'',
            actual_startdate:'',
            actual_starttime:'',
            actual_enddate:'',
            actual_enddate:'',
            delivery: false,
            type: [],
            resource: '',
            desc: ''
          },
          formLabelWidth: '120px',
          dialogVisible: false
        };
      }
    ,
    methods: {
      onSubmit() {
        console.log('submit!');
        console.log(this.errorform);
        axios.get('http://127.0.0.1:8888/alarm/',this.errorform,{'xhrFields' : {withCredentials: true},crossDomain: true})
        .then(res=>{
          console.log(res.data);
         })
        .catch(err=>{
          console.log(err)
         })
      },
      handleClose(done) {
              this.$confirm('确认关闭？')
                .then(_ => {
                  done();
                })
                .catch(_ => {});
            }
    }
    };
</script>

<style>
</style>
