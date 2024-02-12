<template>
  <div class="main-layout">
    <div class="header-home">
      <NavBar />
    </div>
    <RouterView />
  </div>
</template>

<script setup>
import NavBar from './NavBar.vue'

</script>

<style lang="scss" scoped>
.main-layout {
  width: 100%;
  margin: 0 auto;
  display: flex;
  flex-direction: column;
  align-items: center;
}
.header-home {
  width: 100%;
  position: absolute;
  z-index: 999;
  display: flex;
  flex-direction: column;
  justify-content: center;
  margin-bottom: 6px;
  padding: 0 120px;
}

.header-home::before {
  content: "";
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(53, 111, 134, 0.21); /* 黑色半透明蒙版 */
  z-index: -1; /* 将蒙版置于导航栏背景之后 */
}
</style>
