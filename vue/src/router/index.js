import Vue from 'vue'
import VueRouter from 'vue-router'
import login from '@/components/childPage/login'
import main from '@/components/childPage/main'
import reg from '@/components/childPage/reg'
import admin from '@/components/childPage/admin'
import order from '@/components/childPage/order'

// 初始化 VueRouter 插件
Vue.use(VueRouter)

// 创建路由
export default new VueRouter({
    routes: [
        {
            path: '/',
            name: 'Login',
            component: login
        },
        {
            path: '/main',
            name: 'Main',
            component: main
        },
        {
            path: '/reg',
            name: 'Reg',
            component: reg
        },
        {
            path: '/admin',
            name: 'Admin',
            component: admin
        }
        ,
        {
            path: '/order',
            name: 'Order',
            component: order
        }
    ]
})
