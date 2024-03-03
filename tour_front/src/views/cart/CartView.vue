<template>
  <div class="main">
    <div class="attr-name">
      <div style="width: 320px;padding-left: 50px;">商品</div>
      <div style="width: 220px;padding-left: 160px;">单价</div>
      <div style="width: 260px;padding-left: 200px;">数量</div>
      <div style="width: 220px;padding-left: 180px;">小计</div>
    </div>
    <div class="list" v-loading="isLoading">
      <div class="card" v-for="item in list" :key="item">
        <el-card shadow="never">
          <div class="card-item">
            <el-checkbox @change="onCheck(item)" v-model="item.checked" size="large" />
            <div class="img-box">
              <img style="width: 100%; height:100%" :src="item.productImg" alt="">
            </div>
            <div class="title">
              <p style="font-size: large;padding-bottom: 10px;">{{ item.productName }}</p>
              <p style="font-size: small;color: rgb(101, 101, 101);">{{ item.speName }}</p>
            </div>
            <p class="price">￥{{ item.productPrice }}</p>
            <div class="number">
              <el-input-number :min="0" @change="(value)=> onNumberChange(item,value)" v-model="item.number"/>
            </div>
            <p class="total">￥{{ item.productPrice * item.number }}</p>
          </div>
        </el-card>
      </div>
    </div>
    <div class="bottom">
      <div class="bottom-left">
        <el-checkbox @change="onCahngeAll" v-model="isAll" label="全选" size="large" />
        <el-button type="text" >清空购物车</el-button>
        <span>已选择{{ `${totalChecked}` }}件</span>
      </div>
      <div class="bottom-right">
        <span>总价：</span>
        <span>￥{{ total }}</span>
        <el-button :disabled="total === 0"
          @click="dialogVisible = true" type="primary" style="margin-left: 15px">结算</el-button>
      </div>
    </div>
    <el-dialog
      v-model="dialogVisible"
      width="600"
      :close-on-click-modal="false"
      :close-on-press-escape="false"
    >
        <div style="display: flex; align-items: center">
          <span style="width: 90px;">地址选择：</span>
          <el-select
          v-model="addressId"
          placeholder="请选择地址"
          size="large"
          style="width: 500px"
        >
            <el-option
              v-for="item in addressOptions"
              :key="item.value"
              :label="item.label"
              :value="item.value"
            />
          </el-select>
        </div>

      <template #footer>
        <div class="dialog-footer">
          <el-button type="primary" :loading="isSubmitLoading" @click="createOrder"> 确认结算 </el-button>
        </div>
      </template>
    </el-dialog>
  </div>
</template>

<script setup>
import { ref, computed, onMounted } from 'vue'
import { updateCart, getCartList } from '@/apis/cart.js'
import { getAll } from '@/apis/address.js'
import { ElMessage } from 'element-plus'

const list = ref([])
const isAll = ref(false)
const isLoading = ref(false)
const isSubmitLoading = ref(false)
const dialogVisible = ref(false)
const addressId = ref(0)
const addressOptions = ref([])
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

const onCheck = item => {
  const filterList = list.value.filter(item => item.checked)
  if (filterList.length === list.value.length) {
    isAll.value = true
  } else {
    isAll.value = false
  }
}

const onCahngeAll = (v) => {
  console.log(isAll.value)
  list.value.forEach(item => {
    isAll.value ? item.checked = true : item.checked = false
  })
}

const onNumberChange = async (item, value) => {
  await updateCart(item.speId, item.productId, value)
  load()
}

const load = async () => {
  isLoading.value = true
  const res = await getCartList()
  list.value = res
  isLoading.value = false
}

const getOptions = async () => {
  const res = await getAll()
  addressOptions.value = res.map(item => {
    return {
      label: `姓名：${item.name},地址：${item.place},电话：${item.tel}`,
      value: item.id
    }
  })
  addressId.value = addressOptions?.value[0]?.value || 0
}

const createOrder = async () => {
  if (addressId.value === 0) {
    ElMessage.warning('请选择地址')
    return
  }
  const params = {
    addressId: addressId.value,
    cartItems: list.value.filter(item => item.checked)
  }
  params.cartItems.forEach((item) => {
    delete item.checked
  })
  isSubmitLoading.value = true
  isSubmitLoading.value = false
  load()
  ElMessage.success('支付成功')
  addressId.value = 0
  dialogVisible.value = false
}

onMounted(() => {
  load()
  getOptions()
})

</script>

<style lang="scss" scoped>
.main{
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  margin-top: 90px;
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
