<template>
  <div class="main">
    <div class="attr-name">
      <div style="width: 320px;padding-left: 50px;">商品</div>
      <div style="width: 220px;padding-left: 160px;">单价</div>
      <div style="width: 260px;padding-left: 200px;">数量</div>
      <div style="width: 220px;padding-left: 180px;">小计</div>
    </div>
    <div class="list">
      <div class="card" v-for="item in list" :key="item">
        <el-card shadow="never">
          <div class="card-item">
            <el-checkbox v-model="item.checked"  size="large" />
            <div class="img-box">
              <img style="width: 100%; height:100%" :src="item.productImg" alt="">
            </div>
            <div class="title">
              <p style="font-size: large;padding-bottom: 10px;">{{ item.productName }}</p>
              <p style="font-size: small;color: rgb(101, 101, 101);">{{ item.speName }}</p>
            </div>
            <p class="price">￥{{ item.productPrice }}</p>
            <div class="number">
              <el-input-number @change="onNumberChange" v-model="item.number"/>
            </div>
            <p class="total">￥{{ item.productPrice * item.number }}</p>
          </div>
        </el-card>
      </div>
    </div>
    <div class="bottom">
      <div class="bottom-left">
        <el-checkbox @click="onCahngeAll" :value="isAll" label="全选" size="large" />
        <el-button type="text" >清空购物车</el-button>
        <span>已选择{{ `${totalChecked}` }}件</span>
      </div>
      <div class="bottom-right">
        <span>总价：</span>
        <span>￥{{ total }}</span>
        <el-button type="primary" style="margin-left: 15px">结算</el-button>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, computed, watch } from 'vue'
import g1 from '../../assets/home/goods/g1.png'
import g2 from '../../assets/home/goods/g2.png'
import g3 from '../../assets/home/goods/g3.png'

const list = ref([
  {
    cartId: 1,
    userId: 2,
    number: 1,
    productId: 1,
    productName: '青城雪芽',
    productImg: g1,
    productPrice: 32.5,
    productDetailImg: 'product2_detail.jpg',
    speId: 1,
    speName: '青城雪芽53克*1袋'
  },
  {
    cartId: 1,
    userId: 2,
    number: 3,
    productId: 2,
    productName: '匠心腊味礼盒',
    productImg: g2,
    productPrice: 259,
    productDetailImg: 'product2_detail.jpg',
    speId: 2,
    speName: '匠心腊味礼盒2520g'
  },
  {
    cartId: 1,
    userId: 2,
    number: 1,
    productId: 3,
    productName: '李记乐宝酸菜粉丝',
    productImg: g3,
    productPrice: 29.9,
    productDetailImg: 'product2_detail.jpg',
    speId: 2,
    speName: '李记乐宝酸菜粉丝160g*6桶'
  }
])
const isAll = ref(false)

const total = computed(() => {
  let total = 0
  const filterList = list.value.filter((item) => item.checked)
  if (filterList.length === 0) return total
  filterList.forEach((item) => {
    total += item.productPrice * item.number
  })
  return total
})

const totalChecked = computed(() => {
  const filterList = list.value.filter((item) => item.checked)
  return filterList.length
})

const onNumberChange = (number) => {
  console.log(number)
}

watch(list.value, () => {
  let flag = false
  list.value.forEach((item) => {
    if (!item.checked) {
      flag = true
    }
  })

  flag ? isAll.value = false : isAll.value = true
  console.log(isAll.value)
})

const onCahngeAll = () => {
  isAll.value = !isAll.value
  list.value.forEach(item => {
    isAll.value ? item.checked = true : item.checked = false
  })
}

</script>

<style lang="scss" scoped>
.main{
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  margin-top: 66px;
  width: 100%;
  .attr-name{
    width: 80%;
    display: flex;
    font-size: 16px;
    line-height: 32px;
    color: #404040d9;
    border-bottom: 0.5px solid #4040405f;
  }
  .list{
    width: 80%;
    margin-bottom: 70px;
    .card{
      margin: 10px 0;
      .card-item{
        display: flex;
        align-items: flex-start;
        .title{
          width: 250px;
        }
        .price{
          padding-left: 80px;
          width: 220px;
        }
        .number{
          padding-left: 80px;
          width: 260px;
        }
        .total{
          padding-left: 100px;
          width: 220px
        }
        .img-box{
          width: 80px;
          height:80px;
          margin:0 15px;
        }
      }
    }
  }
  .bottom{
    display: flex;
    background-color: rgb(250, 254, 255);
    z-index: 999;
    justify-content: space-between;
    align-items: center;
    padding: 0 150px;
    position: fixed;
    height: 65px;
    box-shadow: 0px -1px 0.5px rgba(65, 79, 93, 0.46);
    bottom: 0;
    left: 0;
    right: 0;
    &-left{
      width: 220px;
      display: flex;
      justify-content: space-between;
      align-items: center;
    }
    &-right{
      display: flex;
      justify-content: space-between;
      align-items: center;
    }
  }
}
</style>
