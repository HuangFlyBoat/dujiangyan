import http from '@/http/index.js'
import { ElMessage } from 'element-plus'

const login = async ({ userName, password }) => {
  try {
    const { data } = await http.post('/user/login', { userName, password })
    return data
  } catch (error) {
    ElMessage.error(`登录失败,${error}`)
    return Promise.reject(error)
  }
}

const register = async (formData) => {
  try {
    const { data } = await http.post('/user/register', formData)
    return data
  } catch (error) {
    ElMessage.error(`注册失败,${error}`)
    return Promise.reject(error)
  }
}

export { register, login }
