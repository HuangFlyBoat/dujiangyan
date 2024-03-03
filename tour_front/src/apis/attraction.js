import http from '@/http/index.js'
import { ElMessage } from 'element-plus'

const getAttractionList = async () => {
  try {
    const { data } = await http.get('/attraction/getAttractionList')
    return data
  } catch (error) {
    ElMessage.error(`获取景点失败,${error}`)
    return Promise.reject(error)
  }
}

export { getAttractionList }
