<template>
  <div class="home-head">
    <div class="logo">
      <router-link
        to="/"
        class="router-link-active"
        style="font-size: 20px;color: #fff;"
        @click="handleNavClick('#')"
        >Trave</router-link>
    </div>
    <div class="navigation">
      <div class="header-navigation">
        <div class="header-navigation-item">
          <router-link
            @click="handleNavClick('#')"
            to="/"
            class="router-link-active router-link-exact-active"
            aria-current="page"
            ><div class="text-label">
              <div :class="isActive('#') ? 'showLine' : ''" class="title">首页</div>
            </div></router-link
          >
        </div>
        <div class="header-navigation-item">
          <router-link to="/local-produce" class="" @click="handleNavClick('local-produce')"
            ><div class="text-label">
              <div :class="isActive('local-produce') ? 'showLine' : ''" class="title">特产商城</div>
            </div></router-link
          >
        </div>
        <div class="header-navigation-item">
          <router-link to="/cart" @click="handleNavClick('cart')"
            ><div class="text-label nav-cart">
              <div :class="isActive('cart') ? 'showLine' : ''" class="title">购物车</div>
            </div></router-link
          >
        </div>
        <div v-if="!isLogin" class="header-navigation-item">
          <router-link to="/login" @click="handleNavClick('login')">
            <div class="text-label">
              <div :class="isActive('login') ? 'showLine' : ''" class="title" title="">登录/注册</div>
            </div>
          </router-link>
        </div>
        <div v-if="isLogin" class="header-navigation-item">
          <router-link to="/address" @click="handleNavClick('address')">
            <div class="text-label">
              <div :class="isActive('address') ? 'showLine' : ''" class="title" title="">我的地址</div>
            </div>
          </router-link>
        </div>
        <div v-if="isLogin" class="header-navigation-item">
            <div style="cursor:auto;" class="text-label">
              <span style="padding-bottom: 5px;color: white;" text>{{ userName }}</span>
              <el-link @click="loginOut">退出登录</el-link>
            </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, watch } from 'vue'
import { useRoute, useRouter } from 'vue-router'

const routePath = ref('#')
const router = useRouter()
const route = useRoute()

const isLogin = ref(!!localStorage.getItem('userName'))
const userName = localStorage.getItem('userName')

const loginOut = () => {
  localStorage.clear()
  isLogin.value = false
  router.push('/')
}

watch(
  () => localStorage.getItem('userName'),
  () => {
    isLogin.value = !!localStorage.getItem('userName')
  },
  { immediate: true }
)

watch(
  () => route.path,
  () => {
    const name = route.path.split('/')[1]
    if (name === '') {
      routePath.value = '#'
    } else routePath.value = name
  },
  { immediate: true }
)

function handleNavClick (url) {
  routePath.value = url
}

function isActive (url) {
  return routePath.value === url
}

</script>

<style lang="scss" scoped>
.home-head {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin: 38px 7px 6px;
  .logo {
    flex: 1;
    flex-shrink: 0;
    margin-right: 20px;
    margin-bottom: 2px;
    max-width: 352px;
  }
  .header-navigation {
    display: flex;
    box-sizing: border-box;
    &-item {
      position: relative;
      margin-left: 36px;
    }
    .text-label {
      display: flex;
      flex-direction: column;
      align-items: center;
      color: inherit;
      font-size: 12px;
      font-weight: 400;
      letter-spacing: 1px;
      word-break: normal;
      cursor: pointer;
      .title {
        color: #fff;
        display: flex;
        justify-content: center;
        align-items: center;
        font-weight: 400;
        font-size: 14px;
        line-height: 20px;
      }
    }
  }
}
.header-navigation-item:first-child {
  margin-left: 0;
}
.header-navigation-item .nav-cart .cart-icon {
  position: absolute;
  right: 0;
  margin-top: -3px;
}

.showLine {
  border-bottom: 1px solid #ffffff;
}
</style>
