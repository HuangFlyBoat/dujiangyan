<template>
  <div class="main">
    <div class="attr-name">
      <div style="width: 320px;padding-left: 50px;">商品</div>
      <div style="width: 220px;padding-left: 160px;">单价</div>
      <div style="width: 260px;padding-left: 200px;">数量</div>
      <div style="width: 220px;padding-left: 180px;">小计</div>
    </div>
    <div class="list">
      <div class="card" v-for="item in list" :key="item.id">
        <el-card shadow="never">
          <div class="card-item">
            <el-checkbox v-model="item.checked"  size="large" />
            <div class="img-box">
              <img style="width: 100%; height:100%" src="https://picsum.photos/300/250" alt="">
            </div>
            <p class="title">title</p>
            <p class="price">￥18.00</p>
            <div class="number">
              <el-input-number @change="onNumberChange" v-model="item.num"/>
            </div>
            <p class="total">￥18.00</p>
          </div>
        </el-card>
      </div>
    </div>
    <div class="bottom">
      <div class="bottom-left">
        <el-checkbox v-model="isAll" label="全选" size="large" />
        <el-button type="text" >清空购物车</el-button>
        <span>已选择{{ `${0}` }}件</span>
      </div>
      <div class="bottom-right">
        <span>总价：</span>
        <span>￥115</span>
        <el-button type="primary" style="margin-left: 15px">结算</el-button>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue'

const list = ref([
  {
    id: 1,
    checked: false
  },
  {
    id: 2,
    checked: false
  },
  {
    id: 3,
    checked: false
  },
  {
    id: 4,
    checked: false
  },
  {
    id: 5,
    checked: false
  },
  {
    id: 6,
    checked: false
  }
])
const isAll = ref(false)
const onNumberChange = (number) => {
  console.log(number)
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
