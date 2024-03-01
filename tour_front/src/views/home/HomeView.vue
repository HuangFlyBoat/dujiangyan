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
        <el-carousel trigger="click" :interval="4000" type="card" height="700px">
          <el-carousel-item v-for="item in goodsImgList" :key="item">
            <img style="width: 100%;" :src="item" alt="">
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
        <div class="grid-container">
          <div v-for="item in attrList" :key="item.title" class="grid-item">
            <div class="top-bg">
              <el-carousel :autoplay="false" height="300px">
                <el-carousel-item v-for="imgsrc in item.imgs" :key="imgsrc">
                 <img style="width: 100%;height: 100%;" :src="imgsrc" alt="">
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
import { ref } from 'vue'
import g1 from '../../assets/home/goods/g1.png'
import g2 from '../../assets/home/goods/g2.png'
import g3 from '../../assets/home/goods/g3.png'
import g4 from '../../assets/home/goods/g4.png'
import o1 from '../../assets/home/outline/o1.png'
import o2 from '../../assets/home/outline/o2.png'
import i1 from '../../assets/home/img/1.png'
import i2 from '../../assets/home/img/2.png'
import i3 from '../../assets/home/img/3.png'
import i4 from '../../assets/home/img/4.png'
import i5 from '../../assets/home/img/5.png'
import i6 from '../../assets/home/img/6.png'
import i7 from '../../assets/home/img/7.png'
import i8 from '../../assets/home/img/8.png'
import i9 from '../../assets/home/img/9.png'
import i10 from '../../assets/home/img/10.png'
import i11 from '../../assets/home/img/11.png'
import i12 from '../../assets/home/img/12.png'
import i13 from '../../assets/home/img/13.png'
import i14 from '../../assets/home/img/14.png'
import i15 from '../../assets/home/img/15.png'
import i16 from '../../assets/home/img/16.png'
import i17 from '../../assets/home/img/17.png'
import i18 from '../../assets/home/img/18.png'
import i19 from '../../assets/home/img/19.png'
import i20 from '../../assets/home/img/20.png'

const goodsImgList = [g1, g2, g3, g4]
const outlineImg = [o1, o2]
const attrList = [
  {
    title: '都江堰景区',
    level: 5,
    address: '四川省成都市都江堰市公园路',
    businessHours: '08:00-17:30',
    ticketPrice: 80,
    introduced: '都江堰景区，位于都江堰市城西岷江干流上，由秦国蜀郡太守李冰及其子于西元前256年左右修建，是目前中国保存完整的古代水利工程。工程由鱼嘴分水堤、飞沙堰溢洪道、宝瓶口引水口三大主体工程和百丈堤、人字堤等附属工程构成，把汹涌的岷江分隔成外江和內江，外江排洪，內江引水灌溉，使川西平原成为了“天府之国”。',
    imgs: [i1, i2, i3, i4]
  },
  {
    title: '青城山',
    level: 5,
    address: '四川省成都市都江堰市西南部青城山风景区',
    businessHours: '08:30-17:00',
    ticketPrice: 80,
    introduced: '青城山自古素有“青城天下幽”的美誉，分前山和后山两部分，前山是青城山的主体，道教文化、文物古迹多集中这里，这里也是一般游客口中的“青城山”；后山以自然风光取胜，是度假休闲的好去处。',
    imgs: [i5, i6, i7, i8]
  },
  {
    title: '成都融创乐园',
    level: 4,
    address: '四川省成都市都江堰市至臻路31号',
    businessHours: '10:00-18:00',
    ticketPrice: 198,
    introduced: '成都融创乐园位于都江堰市玉堂，占地面积约51.5万平方米，以蜀文化为主题，设计了天府耍都、蜀汉风云、藏羌秘境、星际传奇、奇遇花园、萌宠小镇六大主题区， 共有天路历险、飞行影院、 极速狂飙等25套大型游乐设备，1台大型剧场演出《爱丽丝梦游仙境》，以及《巨 马凯旋》花车巡游、《太阳神 鸟大湖秀》等特色演出。',
    imgs: [i9, i10, i11]
  },
  {
    title: '都江堰中华大熊猫苑',
    level: 4,
    address: '成都市都江堰市怀中路青城山镇石桥村789组',
    businessHours: '08:30-16:30',
    ticketPrice: 53,
    introduced: '都江堰中华大熊猫苑（又名熊猫乐园、都江堰中华大熊猫苑（原熊猫乐园））位于都江堰市青城山镇石桥村，距市区18公里，北邻道教圣地青城山，南邻川西街子古镇，省道S106(川西旅游环线)连贯其间，紧邻大熊猫栖息地世界遗产区域，拥有适宜大熊猫生活的气候和自然环境。.5万平方米，以蜀文化为主题，设计了天府耍都、蜀汉风云、藏羌秘境、星际传奇、奇遇花园、萌宠小镇六大主题区， 共有天路历险、飞行影院、 极速狂飙等25套大型游乐设备，1台大型剧场演出《爱丽丝梦游仙境》，以及《巨 马凯旋》花车巡游、《太阳神 鸟大湖秀》等特色演出。',
    imgs: [i12, i13, i14]
  },
  {
    title: '灌县古城',
    level: 4,
    address: '成都市都江堰市灌县古城西街32号',
    businessHours: '全天开放',
    ticketPrice: 0,
    introduced: '灌县古城，一座与千年古堰相伴的古城，一座景城一体的古城，一座品味生活的古城，一座快铁直达的古城。这个曾经遭受“5·12”大地震重创的古城，2012年5月19日这一天灌县古城举行盛大的开城仪式，正式揭开她的神秘面纱。(川西旅游环线)连贯其间，紧邻大熊猫栖息地世界遗产区域，拥有适宜大熊猫生活的气候和自然环境。.5万平方米，以蜀文化为主题，设计了天府耍都、蜀汉风云、藏羌秘境、星际传奇、奇遇花园、萌宠小镇六大主题区， 共有天路历险、飞行影院、 极速狂飙等25套大型游乐设备，1台大型剧场演出《爱丽丝梦游仙境》，以及《巨 马凯旋》花车巡游、《太阳神 鸟大湖秀》等特色演出。',
    imgs: [i15, i16, i17]
  },
  {
    title: '南桥',
    level: 5,
    address: '四川省成都市都江堰市团结巷146号',
    businessHours: '全天开放',
    ticketPrice: 0,
    introduced: '南桥是一座仿古廊桥，廊桥的天棚有彩画天花及卷棚仿古天棚，所有的木雕进行描金填彩。廊桥边上有一条热闹的美食街，能够吃到各种当地的美食。夜晚的廊桥特别美丽，吹江风，吃小吃，欣赏夜景，非常惬意。',
    imgs: [i18, i19, i20]
  }
]

const rateValue = ref(4)
const desc = '都江堰是中国四川省的一个著名旅游景点，被誉为世界文化遗产。它以其古老而壮丽的水利工程而闻名，这个工程已有两千多年的历史。都江堰也是中国四大名著《西游记》中的重要地点之一。这里拥有壮丽的山水景观、悠久的历史文化和丰富的民俗风情，吸引着来自世界各地的游客。'
const descEn = 'Dujiangyan is a famous tourist attraction in Sichuan, China, known as a UNESCO World Heritage site. It is renowned for its ancient and magnificent irrigation system, which has a history of over two thousand years. Dujiangyan is also an important location mentioned in one of China\'s four great classic novels, "Journey to the West." The area boasts splendid natural landscapes, rich historical and cultural heritage, and vibrant local customs, attracting visitors from around the world.'

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
</style>
