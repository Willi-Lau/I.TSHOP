import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'

import Register from '../views/Register.vue'
import Index from '../views/Index.vue'
import Router from '../views/Router.vue'
import Address from '../views/Address.vue'
import Cart from '../views/Cart'
import BossLogin from '../views/BossLogin'
import BossUser from '../views/BossUser'
import BossAdmin from '../views/BossAdmin'
import BossAddClothes from '../views/BossAddClothes'
import BossUserPoint from "../views/BossUserPoint";
import BossUserCartHistory from "../views/BossUserCartHistory";
import BossAdmintime from "../views/BossAdmintime";
import BossUsertime from "../views/BossUsertime";

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },

  {
    path: '/register',
    name: 'Register',

    component: Register
  },
  {
    path: '/Address',
    name: 'Address',

    component: Address
  },
  {
    path: '/Index',
    name: 'Index',

    component: Index,

  },
  {
    path: '/Router',
    name: 'Router',

    component: Router,

  },
  {
    path: '/Cart',
    name: 'Cart',

    component: Cart,

  },
  {
    path: '/BossLogin',
    name: 'BossLogin',

    component: BossLogin,

  },
  {
    path: '/BossUser',
    name: 'BossUser',

    component: BossUser,

  },
  {
    path: '/BossAdmin',
    name: 'BossAdmin',

    component: BossAdmin,

  }
  ,
  {
    path: '/BossAddClothes',
    name: 'BossAddClothes',

    component: BossAddClothes,
  }
  ,
  {
    path: '/BossUserPoint',
    name: 'BossUserPoint',

    component: BossUserPoint,
  }
  ,
  {
    path: '/BossUserCartHistory',
    name: 'BossUserCartHistory',

    component: BossUserCartHistory,
  }
  ,
  {
    path: '/BossAdmintime',
    name: 'BossAdmintime',

    component: BossAdmintime,
  }
  ,
  {
    path: '/BossUsertime',
    name: 'BossUsertime',

    component: BossUsertime,
  }
]
const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
  return originalPush.call(this, location).catch(error=> error)
}

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
