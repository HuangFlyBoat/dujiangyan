import axios from 'axios'
import { MessagePlugin } from 'tdesign-vue-next'

const service = axios.create({
  baseURL: 'http://localhost:8888', // url = base url + request url
  timeout: 15000 // request timeout
})

service.interceptors.response.use(
  response => {
    const res = response.data
    if (res.code !== 2000) {
      console.log('接口信息报错', res.msg)
      if (res.code === 40100) {
        MessagePlugin.warning('请登录')
        location.replace('/login')
      }
      return Promise.reject(new Error(res.msg || 'Error'))
    } else {
      return res
    }
  },
  error => {
    console.log('接口信息报错' + JSON.stringify(error))
    return Promise.reject(error)
  }
)

export default service
