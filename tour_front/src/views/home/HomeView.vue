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
          <router-link to="/local-produce" class="more">查看全部 ></router-link>
        </div>
      </div>
      <div class="right">
        <el-carousel v-loading="loadingHot" trigger="click" :interval="4000" type="card" height="700px">
          <el-carousel-item v-for="item in goodsImgList" :key="item">
            <img style="width: 100%;" :src="item.img" alt="">
          </el-carousel-item>
        </el-carousel>
      </div>
    </div>
    <div class="outline mt ml">
      <div class="left-img">
        <el-carousel :autoplay="false" height="650px">
          <el-carousel-item v-for="item in outlineImg" :key="item">
            <img style="width: 100%;" :src="item" alt="">
          </el-carousel-item>
        </el-carousel>
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

        <div v-loading="loadingAttr" class="grid-container">
          <div v-for="item in attrList" :key="item.title" class="grid-item">
            <div class="top-bg">
              <el-carousel :autoplay="false" height="300px">
                <el-carousel-item v-for="img in item.images" :key="img.id">
                 <img style="width: 100%;height: 100%;" :src="img.imgUrl" alt="">
                </el-carousel-item>
              </el-carousel>
            </div>
            <div class="main">
              <div class="intro">
                <div class="title">
                  <p>{{ item.title }}</p>
                </div>
                <div class="location">
                  <el-icon><Location /></el-icon>
                  <p>{{ item.address }}</p>
                </div>
              </div>
              <p class="desc">
                {{ item.introduced }}
              </p>
            </div>
            <div class="bottom">
              <el-rate v-model="rateValue" disabled />
              <p class="price">{{ item.businessHours }}</p>
              <div class="price">¥{{ item.ticketPrice || '免费' }}</div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import { getAttractionList } from '@/apis/attraction.js'
import { getProductList } from '@/apis/product.js'
import o1 from '../../assets/home/outline/o1.png'
import o2 from '../../assets/home/outline/o2.png'

const goodsImgList = ref([])
const outlineImg = [o1, o2]
const attrList = ref([])
const loadingHot = ref(false)
const loadingAttr = ref(false)

const rateValue = ref(4)
const desc = '都江堰是中国四川省的一个著名旅游景点，被誉为世界文化遗产。它以其古老而壮丽的水利工程而闻名，这个工程已有两千多年的历史。都江堰也是中国四大名著《西游记》中的重要地点之一。这里拥有壮丽的山水景观、悠久的历史文化和丰富的民俗风情，吸引着来自世界各地的游客。'
const descEn = 'Dujiangyan is a famous tourist attraction in Sichuan, China, known as a UNESCO World Heritage site. It is renowned for its ancient and magnificent irrigation system, which has a history of over two thousand years. Dujiangyan is also an important location mentioned in one of China\'s four great classic novels, "Journey to the West." The area boasts splendid natural landscapes, rich historical and cultural heritage, and vibrant local customs, attracting visitors from around the world.'

const getAttraction = async () => {
  loadingAttr.value = true
  const res = await getAttractionList()
  loadingAttr.value = false
  attrList.value = res
}

const getHot = async () => {
  loadingHot.value = true
  const data = await getProductList()
  loadingHot.value = false
  goodsImgList.value = data.slice(0, 3)
}

onMounted(() => {
  getAttraction()
  getHot()
})

</script>

<style lang="scss" scoped>
.home-main{
  width: 100%;
  .index-bg{
    position: relative;
    height: 100vh;
    background-image: url(../../assets/home-bg.jpg);
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
    height: 600px;
    .left{
      padding-top: 60px;
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
          color: rgb(0, 107, 149);
          margin-left: 50px;
        }
      }
    }
    .right{
      margin-left: 50px;
      width: 100%;
      height: 700px;
    }
  }

  .outline{
    display: flex;
    justify-content: flex-start;
    align-items: center;
    height: 650px;
    .left-img {
      width: 500px;
    }
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
        height: 530px;
        border-left: #bababa47 solid 0.5px;
        box-shadow: 2px 2px 4px rgba(197, 197, 197, 0.338);
        .top-bg{
          width: 400px;
        }
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
            padding: 8px 0;
            height: 120px;
            overflow-y: scroll;
            font-size: 14px;
            line-height: 16px;
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
          .price{
            font-size: 14px;
            color: #606060;
          }
        }
      }
    }
  }

}
</style>import { slice } from 'core-js/core/array'
