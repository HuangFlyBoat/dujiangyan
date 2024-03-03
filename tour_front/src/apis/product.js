import http from '@/http/index.js'
import { ElMessage } from 'element-plus'

const getProductList = async () => {
  try {
    const { data } = await http.get('/product/getProductList')
    return data
  } catch (error) {
    ElMessage.error(`获取土特产失败,${error}`)
    return Promise.reject(error)
  }
}

const getDetail = async () => {
  try {
    const { data } = await http.get('/product/getDetail')
    return data
  } catch (error) {
    ElMessage.error(`获取土特产失败,${error}`)
    return Promise.reject(error)
  }
}

export { getProductList, getDetail }
