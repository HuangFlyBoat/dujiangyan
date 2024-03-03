<template>
  <div class="main">
    <t-card>
      <t-table row-key="id" :loading="isLoading" :data="list" :columns="columns">
      </t-table>
      <t-pagination
        style="margin-top: 10px"
        @current-change="handlePageChange"
        :total="total"
        :showPageSize="false"
        :pageSize="15"
        showPageNumber
        showPreviousAndNextBtn
      />
    </t-card>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'

import { allUserService } from '@/services/user.js'

const columns = ref([
  {
    colKey: 'userId',
    title: 'id',
    width: 30
  },
  {
    colKey: 'userName',
    title: '用户名',
    width: 100
  },
  {
    colKey: 'email',
    cell: 'email',
    title: '邮箱',
    width: 100
  },
  {
    colKey: 'phone',
    cell: 'phone',
    title: '电话',
    width: 100
  }
])
const isLoading = ref(false)
const list = ref([])
const total = ref(0)

const load = async () => {
  isLoading.value = true
  const data = await allUserService()
  list.value = data
  total.value = data.length
  isLoading.value = false
}

onMounted(() => {
  load()
})
</script>

<style lang="scss" scoped>
.main {
  width: 100%;
  padding: 10px;
}
</style>
