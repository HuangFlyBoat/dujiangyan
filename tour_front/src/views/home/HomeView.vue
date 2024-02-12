<template>
  <div class="home-main">
    <div class="index-bg">
      <div class="index-main">
        <p class="title">都江堰</p>
        <p class="title desc">Dujiangyan</p>
      </div>
    </div>
    <div class="hot-goods mt ml">
      <div class="left">
        <div class="title">
          <p>土特产</p>
          <p>Local Produce</p>
        </div>
        <div class="desc">
          <p>川岛美味，传承千年</p>
          <p>Dujiangyan local delicacies, a taste that spans millennia.</p>
        </div>
        <div class="bottom">
          <div class="line"></div>
          <span class="more">查看全部 ></span>
        </div>
      </div>
      <div class="right">
        <el-carousel trigger="click" :interval="4000" type="card" height="500px">
          <el-carousel-item v-for="item in 6" :key="item">
            <img :src="`https://picsum.photos/400/500`" alt="">
          </el-carousel-item>
        </el-carousel>
      </div>
    </div>
    <div class="outline mt ml">
      <div class="left-img">
        <img src="https://picsum.photos/id//16/500/550" alt="">
      </div>
      <div class="right-text">
        <p class="title">都江堰</p>
        <p class="title">Dujiangyan</p>
        <div class="text">
          <p>{{ desc }}</p>
          <p>{{ descEn }}</p>
        </div>
      </div>
    </div>
    <div class="attractions mt ml mr">
      <div class="head">
        <p class="title">都江堰的热门景点</p>
        <p class="title">Popular attractions</p>
      </div>
      <div class="list">
        <div class="grid-container">
          <div v-for="item in list" :key="item" class="grid-item">
            <div class="top-bg">
              <img src="https://picsum.photos/400/300" alt="">
            </div>
            <div class="main">
              <div class="intro">
                <div class="title">
                  <p>夏威夷群岛</p>
                  <p>ddadadada</p>
                </div>
                <div class="location">
                  <el-icon><Location /></el-icon>
                  <p>地址</p>
                </div>
              </div>
              <p class="desc">
                描述信息xxxxxxxxxxxxxxxxxxxxxxxxx测飒飒
              </p>
            </div>
            <div class="bottom">
              <el-rate v-model="rateValue" disabled />
              <div class="price">{{ `免费` }}</div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue'

const list = [1, 2, 3, 4, 5, 6, 7, 8, 9]
const desc = '都江堰是中国四川省的一个著名旅游景点，被誉为世界文化遗产。它以其古老而壮丽的水利工程而闻名，这个工程已有两千多年的历史。都江堰也是中国四大名著《西游记》中的重要地点之一。这里拥有壮丽的山水景观、悠久的历史文化和丰富的民俗风情，吸引着来自世界各地的游客。'
const descEn = 'Dujiangyan is a famous tourist attraction in Sichuan, China, known as a UNESCO World Heritage site. It is renowned for its ancient and magnificent irrigation system, which has a history of over two thousand years. Dujiangyan is also an important location mentioned in one of China\'s four great classic novels, "Journey to the West." The area boasts splendid natural landscapes, rich historical and cultural heritage, and vibrant local customs, attracting visitors from around the world.'
const rateValue = ref(4)

</script>

<style lang="scss" scoped>
.home-main{
  width: 100%;
  .index-bg{
    position: relative;
    height: 100vh;
    background-image: url(https://picsum.photos/id//16/1600/800);
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

  .hot-goods{
    display: flex;
    justify-content: space-between;
    align-items: center;
    height: 400px;
    .left{
      height: 100%;
      .title{
        font-size: 42px;
        text-shadow: 0 0 1px #040404; /* 利用文字阴影 */
      }
      .desc{
        padding: 40px 0 160px 0;
        font-size: 16px;
        color: #0b0b0b;
        p{
          padding: 2px 0;
        }
      }
      .bottom{
        display: flex;
        justify-content: space-between;
        align-items: center;
        .line{
          flex: 1;
          height: 0.5px;
          background-color: #000;
        }
        .more{
          margin-left: 50px;
        }
      }
    }
    .right{
      margin-left: 50px;
      width: 100%;
      height: 500px;
    }
  }

  .outline{
    display: flex;
    justify-content: flex-start;
    align-items: center;
    height: 550px;
    .right-text{
      margin-left: 60px;
      .title{
        font-size: 60px;
        font-weight: 500;
      }
      .text{
          padding: 40px 0;
          max-width: 600px;
          line-height: 20px;
          font-size: 14px;
          font-weight: lighter;
          color: #191919;
        }
    }
  }

  .attractions{
    .head{
      padding-bottom: 30px;
      font-size: 36px;
      font-weight: 500;
    }
    .list{
      .grid-container {
        display: grid;
        grid-template-columns: repeat(3, 1fr);
        grid-gap: 20px; /* 可选，用于设置元素之间的间距 */
      }
      .grid-item {
        position: relative;
        box-sizing: border-box;
        margin: 15px 0;
        width: 400px;
        height: 500px;
        border-left: #bababa47 solid 0.5px;
        box-shadow: 2px 2px 4px rgba(197, 197, 197, 0.338);
        .main{
          padding: 20px 14px 0 14px;
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
          bottom: 25px;
          position: absolute;
          display: flex;
          justify-content: space-between;
          align-items: center;
          .price{
            font-size: 14px;
            color: #606060;
          }
        }
      }
    }
  }
  .mt{
    margin-top: 120px;
  }
  .ml{
    margin-left: 120px;
  }
  .mr{
    margin-right: 120px;
  }
}
</style>
