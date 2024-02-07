<template>
  <div class="home-main">
    <div class="index-bg">
      <div class="index-main">
        <p class="title">都江堰</p>
        <p class="title desc">Dujiangyan</p>
      </div>
    </div>
  </div>
</template>

<script setup>

</script>

<style lang="scss" scoped>
.home-main{
  .index-bg{
    position: relative;
    width: 100vw;
    height: 100vh;
    background-image: url(https://picsum.photos/id//16/1600/800);
    overflow: hidden;
  }
  .index-main{
    position: absolute;
    left: 50%;
    top: 50%;
    transform: translate(-50%,-100%);
    .title{
      text-align: center;
      font-size: 80px;
      letter-spacing:20px;
      text-shadow: 0 0 25px #defaff; /* 利用文字阴影 */
      font-weight: 600;
      color: white;
    }
    .desc{
      margin-top: 5px;
      font-weight: lighter;
      font-size: 46px;
      letter-spacing: 5px;
    }
  }
}
</style>
