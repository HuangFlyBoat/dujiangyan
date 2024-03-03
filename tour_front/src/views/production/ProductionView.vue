<template>
  <div class="main">
    <div class="detail">
      <div class="img" data-v-2a07f562="">
        <img
          class="cover-img"
          :src="itemInfo.img" />
      </div>
      <div class="info">
        <div class="base-card info-item">
          <div class="base-card-inner">
            <div class="name">{{ itemInfo.name }}</div>
            <div class="price">
              <span class="base-price">¥ {{ itemInfo.price }}</span>
            </div>
          </div>
        </div>
        <div class="base-card info-item">
          <div class="title">类型选择</div>
          <el-radio-group v-model="speId">
            <el-radio v-for="item in itemInfo.speList" :key="item.speId" style="padding: 24px 0;"
              :label="item.name"
            >
              <div class="extra">{{ item.name }}</div>
            </el-radio>
          </el-radio-group>
        </div>
        <div class="base-card info-item">
          <el-input-number v-model="num" :min="1" />
          <el-space size="large">
            <el-button :loading="isLoading" @click="onAddCart" style="margin-left: 10px;" round>加入购物车</el-button>
          </el-space>
        </div>
      </div>
    </div>
    <div class="long-img">
      <el-image style="width: 100%;min-height: 600px;" :src="itemInfo.detailImg" fit="contain" />
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import { useRoute } from 'vue-router'
import { getDetail } from '@/apis/product.js'
import { updateCart } from '@/apis/cart.js'
import { ElMessage } from 'element-plus'

const route = useRoute()
const isLoading = ref(false)
const itemInfo = ref({})
const id = route.params.id
const num = ref(1)
const speId = ref(0)

const onAddCart = async () => {
  isLoading.value = true
  await updateCart(speId.value, itemInfo.value.productId, num.value)
  ElMessage.success('新增成功')
  isLoading.value = false
}

onMounted(async () => {
  const res = await getDetail(id)
  itemInfo.value = res
  speId.value = res.speList[0].speId
})
</script>

<style lang="scss" scoped>
.main {
  margin-top: 66px;
  width: 65%;
  .detail {
    padding: 30px 0;
    display: flex;
    min-height: 634px;
    align-items: center;
    .img {
      width: 500px;
      flex-shrink: 0;
      .cover-img {
        width: 100%;
        border-radius: 20px;
      }
    }
    .info {
      min-width: 438px;
      margin-left: 15px;
      .base-card {
        background-color: rgba(255, 255, 255, 0.3);
        border-radius: 20px;
        padding: 20px;
        overflow: hidden;
        .base-card-inner {
          display: flex;
          justify-content: flex-start;
          .name {
            font-size: 21px;
            font-weight: 500;
            color: #333;
            line-height: 29px;
            letter-spacing: 1px;
          }
          .price {
            margin-left: 25px;
            font-size: 28px;
            font-weight: 500;
            color: #f37777;
            line-height: 29px;
            vertical-align: top;
            white-space: nowrap;
          }
        }
      }
      .info-item {
        margin-bottom: 15px;
        .title {
          font-size: 16px;
          font-weight: 500;
          color: #333;
          line-height: 22px;
          margin: 10px 0;
          -webkit-box-sizing: border-box;
          box-sizing: border-box;
        }
        .title:first-child {
          margin-top: 0;
        }
        .el-radio__label {
          display: flex;
        }
        .extra {
          font-size: 12px;
          font-weight: 400;
          color: #333;
          line-height: 17px;
        }
      }
    }
  }
  .long-img{
    width: 100%;
  }
}
</style>
