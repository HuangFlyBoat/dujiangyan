import http from '@/axios/index.js'
import { MessagePlugin } from 'tdesign-vue-next'

const loginService = async ({ name, password }) => {
  try {
    const { data } = await http.post('/admin/login', { name, password })
    return data
  } catch (error) {
    MessagePlugin.error(`登录失败,${error}`)
    return Promise.resolve(error)
  }
}

const allUserService = async () => {
  try {
    const { data } = await http.get('/user/userList')
    return data
  } catch (error) {
    MessagePlugin.error(`查找失败,${error}`)
    return Promise.resolve(error)
  }
}

export { loginService, allUserService }
