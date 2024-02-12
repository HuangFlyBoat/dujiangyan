import HomeView from '@/views/home/HomeView.vue'
import LocalProduce from '@/views/local-produce/LocalProduce.vue'
import LayoutView from '@/components/LayoutView.vue'

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
      }
    ]
  }
]

export default routes
