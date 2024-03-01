<template>
  <div class="home-main">
    <div class="index-bg">
      <div class="index-main">
        <p class="title">都江堰特产</p>
        <p class="title desc">Local Production</p>
      </div>
    </div>
    <div class="list ml mr">
      <p style="margin-top: 30px" class="title">热门商品</p>
      <p class="title">Popular Productions</p>
      <div class="grid-container">
        <el-card
          shadow="hover"
          @click="handleClick(item)"
          :body-style="{ padding: '0px' }"
          v-for="item in list"
          :key="item.id"
          class="grid-item"
        >
          <div class="top-bg">
            <img style="width: 300px;height: 300px;" :src="item.img" alt="" />
          </div>
          <div class="main">
            <div class="intro">
              <div class="title">
                <p>{{ item.name }}</p>
              </div>
            </div>
          </div>
          <div class="bottom">
            <p class="text">￥{{ item.price }}元</p>
            <div class="price"><el-button round> 购买 </el-button></div>
          </div>
        </el-card>
      </div>
    </div>
  </div>
</template>

<script setup>
import g1 from '../../assets/home/goods/g1.png'
import g2 from '../../assets/home/goods/g2.png'
import g3 from '../../assets/home/goods/g3.png'
import g4 from '../../assets/home/goods/g4.png'
import g5 from '../../assets/home/goods/g5.png'
import g6 from '../../assets/home/goods/g6.png'
import g7 from '../../assets/home/goods/g7.png'

import { useRouter } from 'vue-router'

const router = useRouter()
const list = [
  {
    id: 1,
    name: '青城雪芽',
    img: g1,
    price: 32.5,
    detailImg: 'product1_detail.jpg'
  },
  {
    id: 2,
    name: '匠心腊味礼盒',
    img: g2,
    price: 199,
    detailImg: 'product2_detail.jpg'
  },
  {
    id: 3,
    name: '李记乐宝酸菜粉丝',
    img: g3,
    price: 29.9,
    detailImg: 'product2_detail.jpg'
  },
  {
    id: 4,
    name: '红心猕猴桃',
    img: g4,
    price: 20,
    detailImg: 'product2_detail.jpg'
  },
  {
    id: 5,
    name: '青城山飘雪',
    img: g5,
    price: 480,
    detailImg: 'product2_detail.jpg'
  },
  {
    id: 6,
    name: '青梅酒',
    img: g6,
    price: 46,
    detailImg: 'product2_detail.jpg'
  },
  {
    id: 7,
    name: '张三芝麻糕',
    img: g7,
    price: 29.9,
    detailImg: 'product2_detail.jpg'
  }
]

const handleClick = (item) => {
  router.push(`/local-produce/goods/${item.id}`)
}
</script>

<style lang="scss" scoped>
.home-main {
  width: 100%;
  .index-bg {
    position: relative;
    height: 100vh;
    background-image: url(../../assets/local-produce-index.jpg);
    background-size: 100% 100%;
    .index-main {
      position: absolute;
      left: 50%;
      top: 50%;
      transform: translate(-50%, -100%);
      .title {
        text-align: center;
        font-size: 80px;
        letter-spacing: 20px;
        text-shadow: 0 0 25px #defaff; /* 利用文字阴影 */
        font-weight: 600;
        color: white;
      }
      .desc {
        margin-top: 5px;
        font-weight: lighter;
        font-size: 46px;
        letter-spacing: 5px;
      }
    }
  }
  .list {
    .title {
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
      height: 400px;
      cursor: pointer;
      .main {
        padding: 10px 14px 0 14px;
        .intro {
          display: flex;
          justify-content: space-between;
          .title {
            font-weight: 500;
            font-size: 16px;
            line-height: 18px;
          }
          .location {
            display: flex;
            align-items: flex-start;
            font-size: 14px;
            color: #606060;
          }
        }
        .desc {
          margin-top: 8px;
          max-height: 100px;
          font-size: 14px;
          color: #606060;
        }
      }
      .bottom {
        left: 14px;
        right: 14px;
        bottom: 10px;
        position: absolute;
        display: flex;
        justify-content: space-between;
        align-items: center;
        .text {
          font-size: 18px;
        }
        .price {
          font-size: 14px;
          color: #606060;
        }
      }
    }
  }
}
</style>
