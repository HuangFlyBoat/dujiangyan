import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
// 引入模板的全局的样式
import '@/styles/index.scss'

createApp(App).use(router).mount('#app')
