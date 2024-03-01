<template>
  <div class="main-layout">
    <t-layout>
      <t-layout>
        <t-aside style="border-top: 1px solid var(--component-border);height: 100vh;overflow: hidden;">
          <div style="display: flex;">
            <div style="width: 60px; height: 50px">
              <img style="width: 100%; height: 100%" class="logo" :src="logoSrc" alt="logo" />
            </div>
            <p style="line-height: 50px; font-size: 20px; color: rgba(26, 26, 26, 0.864)">都江堰管理后台</p>
          </div>
          <div style="display: flex; justify-content: space-around;align-items: center;">
            <div>
              <span>当前登录：</span>
              <span>{{ userName || '用户名' }}</span>
            </div>
            <t-button theme="primary" @click="onClick" variant="text">退出</t-button>
          </div>
          <t-menu theme="light" :value="current" style="margin-right: 50px" height="550px">
            <t-menu-item @click="onNavClick('/', 'dashboard')" value="dashboard">
              <template #icon>
                <t-icon name="server" />
              </template>
              土特产列表
            </t-menu-item>
            <t-menu-item @click="onNavClick('/user', 'user')" value="user">
              <template #icon>
                <t-icon name="server" />
              </template>
              用户列表
            </t-menu-item>
          </t-menu>
        </t-aside>
        <t-layout style="min-height: calc(100vh - 56px); padding: 6px">
          <router-view></router-view>
        </t-layout>
      </t-layout>
    </t-layout>
  </div>
</template>

<script setup>
import { clearToken } from '@/utils/auth.js'
import { ref } from 'vue'
import { useRouter } from 'vue-router'
import logoSrc from '@/assets/logo.jpg'

const router = useRouter()
const current = ref('dashboard')
const userName = localStorage.getItem('userName')

const onNavClick = (url, value) => {
  router.push(url)
  current.value = value
}

const onClick = () => {
  clearToken()
  router.push('/login')
}
</script>

<style lang="scss" scoped>
.main-layout {
  width: 100%;
  margin: 0 auto;
}
</style>
