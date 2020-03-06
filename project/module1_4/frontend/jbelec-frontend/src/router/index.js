import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import index from '@/components/pages/index'
import test from '@/components/pages/test'
import HybridMap from '@/components/pages/hybrid_map'
import MiddleMap from '@/components/middle-map'
import mainchart from '@/components/mainchart'
import TopHeader from '@/components/top-header'

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


  ]
})
