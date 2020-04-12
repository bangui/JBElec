<template>
  <div>
  <el-checkbox :indeterminate="isIndeterminate" v-model="checkAll" @change="handleCheckAllChange">全选</el-checkbox>
  <div style="margin: 15px 0;"></div>
  <el-checkbox-group v-model="checkedPowers" @change="handleCheckedPowersChange">
    <el-checkbox v-for="power in powers" :label="power" :key="power">{{power}}</el-checkbox>
  </el-checkbox-group>
  </div>
</template>
<script>
  const powerOptions = ['无','10kV','35kV','110kV','220kV','500kV','1000kV'];
  export default {
    data() {
      return {
        checkAll: false,
        checkedPowers: ['500kV','1000kV'], //被勾选的
        powers: powerOptions,
        isIndeterminate: true
      };
    },
    methods: {
      handleCheckAllChange(val) {
        this.checkedPowers = val ? powerOptions : [];
        this.isIndeterminate = false;
      },
      handleCheckedPowersChange(value) {
        let checkedCount = value.length;
        this.checkAll = checkedCount === this.powers.length;
        this.isIndeterminate = checkedCount > 0 && checkedCount < this.powers.length;
      }
    }
  };
</script>
