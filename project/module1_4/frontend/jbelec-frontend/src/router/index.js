import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import index from '@/components/pages/index'
import test from '@/components/pages/test'
import HybridMap from '@/components/pages/hybrid_map'
import map_style2 from '@/components/pages/map_style2'
import MiddleMap from '@/components/middle-map'
import mainchart from '@/components/mainchart'
import TopHeader from '@/components/top-header'
import rightNav from '@/components/right-nav'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'mainchart',
      component: mainchart
    },
    {
      path: '/index',
      name: 'index',
      component: index
    },
    {
      path: '/test',
      name: 'test',
      component: test
    },
    {
      path: '/HelloWorld',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
        path: '/NBmap',
        name: 'MiddleMap',
        component: MiddleMap
    },
    {
        path: '/HybridMap',
        name: 'HybridMap',
        component: HybridMap
    },
    {
        path: '/map_style2',
        name: 'map_style2',
        component: map_style2
    },
    {
        path: '/rightNav',
        name: 'rightNav',
        component: rightNav
    },
    
  ]
})
