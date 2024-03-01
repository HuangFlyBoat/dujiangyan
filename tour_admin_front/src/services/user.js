import http from '@/axios/index.js'
import { MessagePlugin } from 'tdesign-vue-next'

const loginService = async ({ userName, password }) => {
  try {
    const { data } = await http.post('/admin/login', { userName, password })
    return data
  } catch (error) {
    MessagePlugin.error(`登录失败,${error}`)
    return Promise.reject(error)
  }
}

const allUserService = async () => {
  try {
    const { data } = await http.get('/user/allUser')
    return data
  } catch (error) {
    MessagePlugin.error(`查找失败,${error}`)
    return Promise.reject(error)
  }
}

export { loginService, allUserService }
