<template>
    <div>
<div class="chart" id="mapChart"></div>
    </div>
</template>
<script>

    import chinaJson from 'echarts/map/json/china.json'

export default{
    data() {
            return {

            }
            },

    methods:{
        drawMapChart(){
             //初始化echarts实例
             this.$echarts.registerMap('china', chinaJson)
                var myChart = this.$echarts.init(document.getElementById('mapChart'));
            var data = [
            {name: '土门子变电站', value: 9},
            {name: '刘田庄变电站', value: 12},
            {name: '燕大变电站', value: 12},
            {name: '娄杖子变电站', value: 12}];
            var geoCoordMap = {
                '土门子变电站':[119.1332822,40.47500918],
                '刘田庄变电站':[119.0070982,39.8326443],
                '燕大变电站':[119.511289,39.90729717],
                '娄杖子变电站':[118.7804827,40.33575862]};

var convertData = function (data) {
    var res = [];
    for (var i = 0; i < data.length; i++) {
        var geoCoord = geoCoordMap[data[i].name];
        if (geoCoord) {
            res.push({
                name: data[i].name,
                value: geoCoord.concat(data[i].value)
            });
        }
    }
    return res;
};

var option = {
    title: {
        text: '全国主要城市空气质量 - 百度地图',
        subtext: 'data from PM25.in',
        sublink: 'http://www.pm25.in',
        left: 'center'
    },
    tooltip : {
        trigger: 'item'
    },
       //布局e
       geo: {
                        show: true,
                        map: 'china',
                        zoom: 1,  //地图绽放
                        scaleLimit: 2,
                        label: {
                            normal: {
                                show: true,
                                textStyle: {
                                    color: '#fff'
                                }
                            },
                            emphasis: {
                                show: false,
                            }
                        },
                        roam: true,//是否开启鼠标缩放和平移漫游
                        itemStyle: {
                            normal: {
                                areaColor: 'transparent',
                                borderColor: '#3fdaff',
                                borderWidth: 2,
                                shadowColor: 'rgba(63, 218, 255, 0.5)',
                                shadowBlur: 30
                            },
                            emphasis: {
                                areaColor: '#2B91B7',
                                color: '#fff'
                            }
                        }
                    },

    bmap: {
        show: true,
        center: [104.114129, 37.550339],
        map: 'china',
        zoom: 5,
        roam: true,
        mapStyle: {
            styleJson: [{
                'featureType': 'water',
                'elementType': 'all',
                'stylers': {
                    'color': '#d1d1d1'
                }
            }, {
                'featureType': 'land',
                'elementType': 'all',
                'stylers': {
                    'color': '#f3f3f3'
                }
            }, {
                'featureType': 'railway',
                'elementType': 'all',
                'stylers': {
                    'visibility': 'off'
                }
            }, {
                'featureType': 'highway',
                'elementType': 'all',
                'stylers': {
                    'color': '#fdfdfd'
                }
            }, {
                'featureType': 'highway',
                'elementType': 'labels',
                'stylers': {
                    'visibility': 'off'
                }
            }, {
                'featureType': 'arterial',
                'elementType': 'geometry',
                'stylers': {
                    'color': '#fefefe'
                }
            }, {
                'featureType': 'arterial',
                'elementType': 'geometry.fill',
                'stylers': {
                    'color': '#fefefe'
                }
            }, {
                'featureType': 'poi',
                'elementType': 'all',
                'stylers': {
                    'visibility': 'off'
                }
            }, {
                'featureType': 'green',
                'elementType': 'all',
                'stylers': {
                    'visibility': 'off'
                }
            }, {
                'featureType': 'subway',
                'elementType': 'all',
                'stylers': {
                    'visibility': 'off'
                }
            }, {
                'featureType': 'manmade',
                'elementType': 'all',
                'stylers': {
                    'color': '#d1d1d1'
                }
            }, {
                'featureType': 'local',
                'elementType': 'all',
                'stylers': {
                    'color': '#d1d1d1'
                }
            }, {
                'featureType': 'arterial',
                'elementType': 'labels',
                'stylers': {
                    'visibility': 'off'
                }
            }, {
                'featureType': 'boundary',
                'elementType': 'all',
                'stylers': {
                    'color': '#fefefe'
                }
            }, {
                'featureType': 'building',
                'elementType': 'all',
                'stylers': {
                    'color': '#d1d1d1'
                }
            }, {
                'featureType': 'label',
                'elementType': 'labels.text.fill',
                'stylers': {
                    'color': '#999999'
                }
            }]
        }
    },
    series : [
        {
            name: 'pm2.5',
            type: 'scatter',
       coordinateSystem: 'geo',
            data: convertData(data),
            symbolSize: function (val) {
                var d= val[2] / 10;
                console.log( val[2]+"   "+d)
                return val[2] / 10;
            },
            label: {
                normal: {
                    formatter: '{b}',
                    position: 'right',
                    show: false
                },
                emphasis: {
                    show: true
                }
            },
            itemStyle: {
                                normal: {
                                    color: '#F4E925',
                                    shadowBlur: 10,
                                    shadowColor: '#05C3F9'
                                }
                            },
        },
        {
            name: 'Top 5',
            type: 'effectScatter',
            coordinateSystem: 'geo',
            data: convertData(data.sort(function (a, b) {
                return b.value - a.value;
            }).slice(0, 6)),
            symbolSize: function (val) {
                return val[2] / 10;
            },
            showEffectOn: 'render',
            rippleEffect: {
                brushType: 'stroke'
            },
            hoverAnimation: true,
            label: {
                normal: {
                    formatter: '{b}',
                    position: 'right',
                    show: true
                }
            },
            itemStyle: {
                                normal: {
                                    color: '#F4E925',
                                    shadowBlur: 10,
                                    shadowColor: '#05C3F9'
                                }
                            },
            zlevel: 1
        }
    ]
};
myChart.setOption(option);

}
    },
    mounted(){
        this.drawMapChart();
    }
}
</script>
<style>
.chart{
    height:500px;
}</style>
