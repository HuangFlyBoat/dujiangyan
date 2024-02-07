import HomeView from '@/views/home/HomeView.vue'
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
      }
    ]
  }
]

export default routes
