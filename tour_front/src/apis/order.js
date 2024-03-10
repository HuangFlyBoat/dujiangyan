import http from '@/http/index.js'
import { ElMessage } from 'element-plus'

const createOrder = async (addressId, formData) => {
  try {
    const { data } = await http.post(`/order/createOrder?addressId=${addressId}`, formData)
    return data
  } catch (error) {
    ElMessage.error('支付失败')
    return Promise.resolve(0)
  }
}

const getList = async () => {
  try {
    const { data } = await http.get('/order/getOrderLIst')
    return data
  } catch (error) {
    ElMessage.error('获取列表失败')
    return Promise.resolve([])
  }
}

export { createOrder, getList }
