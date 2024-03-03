<template>
  <div class="main">
    <t-card style="margin-bottom: 10px">
      <t-button @click="onOpenDialog('new')">新增土特产</t-button>
    </t-card>
    <t-card>
      <t-table row-key="id" :loading="isLoading" :data="list" :columns="columns">
        <template #img="{ row }">
          <div style="width: 50px; height: 50px;">
            <img style="width: 100%;height: 100%;" :src="row.img" alt="图片">
          </div>
        </template>
        <template #detailImg="{ row }">
          <div style="width: 50px; height: 50px;">
            <img style="width: 100%;height: 100%;" :src="row.detailImg" alt="长图">
          </div>
        </template>
        <template #operation="{ row }">
          <t-link style="margin-right: 15px;" theme="primary" @click="onOpenDialog('edit',row)">编辑</t-link>
          <t-popconfirm @confirm="handleDelete(row)" content="确认删除吗">
            <t-link theme="danger">删除</t-link>
          </t-popconfirm>
        </template>
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
    <t-dialog v-model:visible="visible" header="新增土特产" width="40%" :on-close="onReset" :footer="false">
      <t-form ref="form" :rules="rules" :data="formData" :colon="true" @reset="onReset" @submit="onSubmit">
        <t-form-item label="土特产名称" name="name">
          <t-input v-model="formData.name" placeholder="请输入土特产名称"></t-input>
        </t-form-item>

        <t-form-item label="土特产图片" name="img">
          <t-upload
            :sizeLimit="{ size: 1, unit: 'MB', message: '图片大小不超过1MB' }"
            theme="image"
            accept="image/*"
            @success="onImg"
            :action="actionURL"
          />
        </t-form-item>

        <t-form-item label="土特产价格" name="price">
          <t-input
            :sizeLimit="{ size: 1, unit: 'MB', message: '图片大小不超过1MB' }"
            v-model="formData.price"
            placeholder="请输入土特产价格"
          ></t-input>
        </t-form-item>

        <t-form-item label="土特产长图" name="detailImg">
          <t-upload theme="image" accept="image/*" @success="ondetailImg" :action="actionURL" />
        </t-form-item>

        <t-form-item v-if="currentDialogType==='new'" label="规格" name="speName">
          <t-input v-model="formData.speName" placeholder="请输入土特产保质期时间（多个规格逗号隔开）"></t-input>
        </t-form-item>

        <t-form-item>
          <t-space size="small">
            <t-button theme="primary" type="submit">提交</t-button>
            <t-button theme="default" variant="base" type="reset">重置</t-button>
          </t-space>
        </t-form-item>
      </t-form>
    </t-dialog>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import { MessagePlugin } from 'tdesign-vue-next'

import { getProductList, deleteProduct, addProduct, editProduct } from '@/services/product'

const actionURL = 'http://localhost:8888/file/image'

const columns = ref([
  {
    colKey: 'id',
    title: 'id',
    cell: 'id',
    width: 30
  },
  {
    colKey: 'name',
    title: '土特产名称',
    width: 100
  },
  {
    colKey: 'img',
    cell: 'img',
    title: '土特产图片',
    width: 100
  },
  {
    colKey: 'price',
    title: '土特产价格',
    width: 100
  },
  {
    colKey: 'detailImg',
    title: '土特产长图',
    width: 100
  },
  {
    colKey: 'operation',
    cell: 'operation',
    title: '操作',
    width: 120
  }
])
const list = ref([])
const isLoading = ref(false)
const currentPage = ref(1)
const total = ref(0)
const visible = ref(false)
const currentDialogType = ref('new')

const rules = {
  name: [{ required: true }],
  img: [{ required: true }],
  price: [{ required: true }],
  detailImg: [{ required: true }],
  speName: [{ required: true }]
}

const formData = ref({
  name: '',
  price: '',
  detailImg: '',
  img: '',
  speName: ''
})

const handleDelete = async row => {
  await deleteProduct(row.id)
  await load(currentPage)
  MessagePlugin.success('删除成功')
}

const load = async () => {
  isLoading.value = true
  const data = await getProductList()
  console.log(data)
  list.value = data
  total.value = list.value.length
  isLoading.value = false
}

const onReset = () => {
  formData.value = {
    name: '',
    price: '',
    detailImg: '',
    img: '',
    speName: ''
  }
}

const onSubmit = async ({ validateResult, firstError }) => {
  console.log(formData.value)
  if (currentDialogType.value === 'new') { formData.value.speName = formData.value.speName.split(',') }
  if (validateResult === true) {
    if (currentDialogType.value === 'new') {
      await addProduct(formData.value)
      MessagePlugin.success('新增成功')
    } else {
      await editProduct(formData.value)
      MessagePlugin.success('更新成功')
    }
    load()
    visible.value = false
  } else {
    console.log('Errors: ', validateResult)
    MessagePlugin.warning(firstError)
  }
}

const handlePageChange = async newPage => {
  currentPage.value = newPage
  load()
}

const ondetailImg = ({ response }) => {
  console.log(response)
  formData.value.detailImg = response.data.url
}

const onImg = ({ response }) => {
  console.log(response)
  formData.value.img = response.data.url
}

const onOpenDialog = (type, item) => {
  if (type === 'edit') {
    currentDialogType.value = type
    formData.value = item
  }

  if (type === 'new') {
    currentDialogType.value = type
    onReset()
  }

  visible.value = true
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
