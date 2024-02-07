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
  width: 100vw;
  margin: 0 auto;
  display: flex;
  flex-direction: column;
  align-items: center;
}
.header-home {
  position: absolute;
  z-index: 999;
  width: 1300px;
  display: flex;
  flex-direction: column;
  justify-content: center;
  margin-bottom: 6px;
}
</style>
