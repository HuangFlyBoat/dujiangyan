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
      <el-table-column label="操作栏">
      <template #default="{row}">
        <el-button size="small" @click="onOpen('edit',row)">编辑</el-button>
        <el-popconfirm title="确定删除吗?" @confirm="handleDelete(row.id)">
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
    :title="curType==='new'? '新增地址' :'更新地址'"
    width="500"
    :before-close="handleClose"
    :close-on-click-modal = "false"
    :close-on-press-escape = "false"
  >
          <el-form ref="formEl" :rules="rules" :model="form" label-width="80px">
              <el-form-item prop="name">
                <span>收货人姓名：</span>
                <el-input v-model="form.name" />
              </el-form-item>
              <el-form-item prop="place">
                <span>地址：</span>
                <el-input v-model="form.place"
                />
              </el-form-item>
              <el-form-item prop="tel">
                <span>手机号：</span>
                <el-input v-model="form.tel"
                />
              </el-form-item>
              <el-form-item>
                <el-button :loading="isLoadingSubmit" style="width: 100%" type="primary" @click="onConfirm"
                  >提交</el-button
                >
              </el-form-item>
            </el-form>
    <template #footer>
    </template>
  </el-dialog>
  </div>
</template>

<script setup>
import { ref, reactive, onMounted } from 'vue'
import { getAll, createOrUpdate, deleteAddress } from '@/apis/address.js'
import { ElMessage } from 'element-plus'

const isLoading = ref(false)
const dialogVisible = ref(false)
const isLoadingSubmit = ref(false)
const formEl = ref()
const tableData = ref([])
const form = ref({})
const curType = ref('new')

const rules = reactive({
  name: [
    { required: true, message: '请输入收货人姓名', trigger: 'blur' }
  ],
  tel: [
    { required: true, message: '请输入电话号码', trigger: 'blur' },
    { min: 11, max: 11, message: '请输入正确位数的电话号码', trigger: 'blur' }
  ],
  place: [
    { required: true, message: '请输入地址', trigger: 'blur' }
  ]
})

const handleDelete = async (id) => {
  await deleteAddress(id)
  ElMessage.success('删除成功')
  load()
}

const onOpen = (type, item) => {
  if (type === 'new') {
    form.value = {}
    curType.value = type
  }
  if (type === 'edit') {
    form.value = item
    curType.value = type
  }
  dialogVisible.value = true
}

const onConfirm = async () => {
  form.value.userId = localStorage.getItem('userId')
  if (!form.value.userId) {
    ElMessage.warning('未检测到用户信息，请登录')
    return
  }
  isLoadingSubmit.value = true
  await createOrUpdate(form.value)
  isLoadingSubmit.value = false
  curType.value === 'new' ? ElMessage.success('新增成功') : ElMessage.success('更新成功')
  load()
  form.value = {}
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
