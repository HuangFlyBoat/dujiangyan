<template>
  <div class="main" style="width: 100%">
    <div style="margin-bottom: 15px;">
    </div>

    <el-table v-loading="isLoading" :data="tableData" style="width: 100%">
      <el-table-column prop="id" label="Id" />
      <el-table-column prop="date" label="日期" />
      <el-table-column prop="total" label="总价" />
    </el-table>

  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import { getList } from '@/apis/order.js'

const isLoading = ref(false)

const tableData = ref([])

const load = async () => {
  isLoading.value = true
  const res = await getList()
  tableData.value = res
  isLoading.value = false
}

onMounted(async () => {
  await load()
})
</script>

<style lang="scss" scoped>
.main{
  padding: 0 150px;
  margin-top: 90px;
}
</style>
