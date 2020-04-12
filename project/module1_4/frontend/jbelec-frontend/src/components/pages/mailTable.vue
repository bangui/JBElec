<template>
  <table class="mailTable" :style="styleObject" v-if="s_showByRow">
    <tr v-for="index in rowCount">
      <td class="column">{{tableData[index*2-2].key}}</td>
      <td>{{tableData[index*2-2].value}}</td>
      <td class="column">{{tableData[index*2-1] !== undefined ? tableData[index*2-1].key : ''}}</td>
      <td>{{tableData[index*2-1] !== undefined ? tableData[index*2-1].value :''}}</td>
    </tr>
  </table>
  <table id="customers" class="mailTable" :style="styleObject" v-else>
    <tr class="alt"v-for="index in rowCount">
      <td class="column">{{tableData[index-1].key}}</td>
      <td>{{tableData[index-1].value}}</td>

    </tr>
  </table>
</template>

<script>
export default {
  data() {
    return {
      styleObject: {},
      s_showByRow: false,
    };
  },
  props: ['tableData','tableStyle','showByRow'],
  computed: {
    rowCount: function() {
      return Math.ceil(this.tableData.length);
    }
  },
  created() {
    this.styleObject = this.tableStyle;
    if(this.showByRow !== undefined){
      this.s_showByRow = this.showByRow;
    }
  },
}
</script>

<style>
  #customers
  {
  	font-family:"Trebuchet MS", Arial, Helvetica, sans-serif;
  	width:100%;
  	border-collapse:collapse;
    position: relative;
    left:0%;
  }
  #customers td, #customers th
  {
  	font-size:1em;
  	border:1px solid #98bf21;
  	padding:3px 7px 2px 7px;
  }
  #customers th
  {
  	font-size:1.1em;
  	text-align:left;
  	padding-top:5px;
  	padding-bottom:4px;
  	background-color:#A7C942;
  	color:#ffffff;
  }
  #customers tr.alt td
  {
  	color:#000000;
  	background-color:#EAF2D3;
  }
</style>
