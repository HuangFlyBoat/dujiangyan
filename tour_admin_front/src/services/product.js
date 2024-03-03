import http from '@/axios/index.js'
import { MessagePlugin } from 'tdesign-vue-next'

const getProductList = async () => {
  try {
    const { data } = await http.get('/product/getProductList')
    return data
  } catch (error) {
    MessagePlugin.error('获取土特产列表失败')
    return Promise.reject(error)
  }
}

const deleteProduct = async id => {
  try {
    await http.post('/product/delete', { id })
    return
  } catch (error) {
    MessagePlugin.error('删除失败')
    return Promise.reject(error)
  }
}

const addProduct = async params => {
  try {
    await http.post('/product/addProduct', params)
    return
  } catch (error) {
    MessagePlugin.error('新增土特产失败')
    return Promise.reject(error)
  }
}

const editProduct = async params => {
  try {
    await http.post('/product/edit', params)
    return
  } catch (error) {
    MessagePlugin.error('更新土特产失败')
    return Promise.resolve(error)
  }
}

export { getProductList, deleteProduct, addProduct, editProduct }
