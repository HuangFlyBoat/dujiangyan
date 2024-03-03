<template>
  <div class="main" style="width: 100%">
    <div style="margin-bottom: 15px;">
      <el-button @click="onOpen('new')">新增地址</el-button>
    </div>

    <el-table v-loading="isLoading" :data="tableData" style="width: 100%">
      <el-table-column prop="id" label="Id" />
      <el-table-column prop="name" label="收货人姓名" />
      <el-table-column prop="tel" label="电话" />
      <el-table-column prop="place" label="地址" />
      <el-table-column label="Operations">
      <template #default="{row}">
        <el-button size="small" @click="onOpen('edit',row)">编辑</el-button>
        <el-popconfirm title="Are you sure to delete this?" @confirm="handleDelete(row.id)">
            <template #reference>
                <el-button
                size="small"
                type="danger">删除</el-button>
            </template>
        </el-popconfirm>
      </template>
    </el-table-column>
    </el-table>

    <el-dialog
    v-model="dialogVisible"
    title="Tips"
    width="500"
    :before-close="handleClose"
    :close-on-click-modal = "false"
    :close-on-press-escape = "false"
  >
    <span>This is a message</span>
    <template #footer>
      <div class="dialog-footer">
        <el-button @click="dialogVisible = false">取消</el-button>
        <el-button type="primary" @click="onConfirm">
          Confirm
        </el-button>
      </div>
    </template>
  </el-dialog>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import { getAll, createOrUpdate, deleteAddress } from '@/apis/address.js'
import { ElMessage } from 'element-plus'

const isLoading = ref(false)
const dialogVisible = ref(false)
const tableData = ref([])
const fromData = ref({})

const handleDelete = async (id) => {
  await deleteAddress(id)
  ElMessage.success('删除成功')
  load()
}

const onOpen = (type, item) => {
  if (type === 'new') {
    fromData.value = {}
  }
  if (type === 'edit') {
    fromData.value = item
  }
  dialogVisible.value = true
}

const onConfirm = async () => {
  await createOrUpdate(fromData.value)
  ElMessage.success('新增成功')
  load()
  dialogVisible.value = false
}

const load = async () => {
  isLoading.value = true
  const res = await getAll()
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
