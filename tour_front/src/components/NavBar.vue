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
          <router-link to="/local-produce" class="" @click="handleNavClick('goods')"
            ><div class="text-label">
              <div :class="isActive('goods') ? 'showLine' : ''" class="title">土特产</div>
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
        <div class="header-navigation-item">
          <router-link to="/login" @click="handleNavClick('login')">
            <div class="text-label">
              <div :class="isActive('login') ? 'showLine' : ''" class="title" title="">登录/注册</div>
            </div>
          </router-link>
        </div>
        <div class="header-navigation-item">
          <router-link to="personal" @click="handleNavClick('personal')"
            ><div class="text-label">
              <div :class="isActive('personal') ? 'showLine' : ''" class="title" title="">个人中心</div>
            </div></router-link
          >
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue'

const routePath = ref('#')

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
