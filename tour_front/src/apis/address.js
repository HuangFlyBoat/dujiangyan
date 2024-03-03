import http from '@/http/index.js'
import { ElMessage } from 'element-plus'

const getAll = async () => {
  try {
    const userId = localStorage.getItem('userId')
    const { data } = await http.get(`/address/user?userId=${userId}`)
    return data
  } catch (error) {
    ElMessage.error('获取失败')
    return Promise.resolve([])
  }
}

const createOrUpdate = async (formData) => {
  try {
    const { data } = await http.post('/address/createOrUpdate', formData)
    return data
  } catch (error) {
    ElMessage.error(`执行失败,${error}`)
    return Promise.reject(error)
  }
}

const deleteAddress = async (id) => {
  try {
    const { data } = await http.post('/address/delete', { id })
    return data
  } catch (error) {
    ElMessage.error(`删除失败,${error}`)
    return Promise.reject(error)
  }
}

export { getAll, createOrUpdate, deleteAddress }
