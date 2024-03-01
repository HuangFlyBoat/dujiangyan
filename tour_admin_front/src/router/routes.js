import LayoutView from '@/components/LayoutView.vue'
import LoginView from '@/views/LoginView.vue'
import ProductListView from '@/views/ProductList'

const routes = [
  {
    path: '/',
    name: 'layout',
    component: LayoutView,
    children: [
      {
        path: '/',
        name: 'home',
        component: ProductListView
      }
    ]
  },
  {
    path: '/login',
    name: 'login',
    component: LoginView
  }
]

export default routes
