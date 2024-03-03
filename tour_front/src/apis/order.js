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

export { createOrder }
