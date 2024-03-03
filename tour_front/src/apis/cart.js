import http from '@/http/index.js'
import { ElMessage } from 'element-plus'

const getCartList = async () => {
  try {
    const { data } = await http.get('/cart/getCartList')
    return data
  } catch (error) {
    ElMessage.error('获取购物车失败')
    return Promise.resolve([])
  }
}

const updateCart = async (speId, productId, number) => {
  try {
    const { data } = await http.post(`/cart/updateCart?speId=${speId}&productId=${productId}`, { number })
    return data
  } catch (error) {
    ElMessage.error(`更新失败,${error}`)
    return Promise.resolve({})
  }
}

export { updateCart, getCartList }
