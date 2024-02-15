<template>
  <div class="home-main">
    <div class="index-bg">
      <div class="index-main">
        <p class="title">都江堰特产</p>
        <p class="title desc">Local Production</p>
      </div>
    </div>
    <div class="list ml mr">
      <p style="margin-top:30px" class="title">热门商品</p>
      <p class="title">Popular Productions</p>
      <div class="grid-container">
          <el-card shadow="hover" @click="handleClick" :body-style="{ padding: '0px' }" v-for="item in list" :key="item" class="grid-item">
            <div class="top-bg">
              <img src="https://picsum.photos/300/250" alt="">
            </div>
            <div class="main">
              <div class="intro">
                <div class="title">
                  <p>夏威夷群岛</p>
                  <p>ddadadada</p>
                </div>
              </div>
            </div>
            <div class="bottom">
              <p class="text">￥155元</p>
              <div class="price"><el-button round>
                购买
              </el-button></div>
            </div>
          </el-card>
      </div>
    </div>
  </div>
</template>

<script setup>
import { useRouter } from 'vue-router'

const router = useRouter()
const list = [1, 2, 3, 4, 5, 6, 7, 8, 9]

const handleClick = () => {
  router.push(`/local-produce/goods/${1}`)
}

</script>

<style lang="scss" scoped>
.home-main{
  width: 100%;
  .index-bg{
    position: relative;
    height: 100vh;
    background-image: url(../../assets/local-produce-index.jpg);
    background-size: 100% 100%;
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
  .list{
    .title{
      font-size: 36px;
      font-weight: 500;
    }
      .grid-container {
        display: grid;
        grid-template-columns: repeat(4, 1fr);
        grid-gap: 20px; /* 可选，用于设置元素之间的间距 */
      }
      .grid-item {
        position: relative;
        box-sizing: border-box;
        margin: 15px 0;
        width: 300px;
        height: 350px;
        cursor: pointer;
        .main{
          padding: 10px 14px 0 14px;
          .intro{
            display: flex;
            justify-content: space-between;
            .title{
              font-weight: 500;
              font-size: 16px;
              line-height: 18px;
            }
            .location{
              display: flex;
              align-items: flex-start;
              font-size: 14px;
              color: #606060;
            }
          }
          .desc{
            margin-top: 8px;
            max-height: 100px;
            font-size: 14px;
            color: #606060;
          }
        }
        .bottom{
          left: 14px;
          right: 14px;
          bottom: 10px;
          position: absolute;
          display: flex;
          justify-content: space-between;
          align-items: center;
          .text{
            font-size: 18px;
          }
          .price{
            font-size: 14px;
            color: #606060;
          }
        }
      }
    }
}
</style>
