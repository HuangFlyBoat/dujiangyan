import http from '@/axios/index.js'
import { MessagePlugin } from 'tdesign-vue-next'

const dessertListService = async (page = 1) => {
  try {
    const { data } = await http.get(`/dessert/getAllDessert?page=${page}`)
    return data
  } catch (error) {
    MessagePlugin.error(`服务异常,${error}`)
    return Promise.resolve(error)
  }
}

const deleteService = async dessertId => {
  try {
    await http.post('/product/delete', { dessertId })
    return
  } catch (error) {
    MessagePlugin.error(`服务异常,${error}`)
    return Promise.resolve(error)
  }
}

const addService = async formData => {
  try {
    await http.post('/product/addProduct', { ...formData })
    return
  } catch (error) {
    MessagePlugin.error(`服务异常,${error}`)
    return Promise.resolve(error)
  }
}

export { dessertListService, deleteService, addService }
