import HomeView from '@/views/home/HomeView.vue'
import LocalProduce from '@/views/local-produce/LocalProduce.vue'
import LayoutView from '@/components/LayoutView.vue'
import ProductionView from '@/views/production/ProductionView.vue'
import LoginView from '@/views/login/LoginView.vue'

const routes = [
  {
    path: '/',
    name: 'layout',
    component: LayoutView,
    children: [
      {
        path: '/',
        name: 'home',
        component: HomeView
      },
      {
        path: '/local-produce',
        name: 'local-produce',
        component: LocalProduce
      },
      {
        path: '/local-produce/goods/:id',
        name: 'good',
        component: ProductionView
      },
      {
        path: '/login',
        name: 'login',
        component: LoginView
      }
    ]
  }
]

export default routes
