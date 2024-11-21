import { createRouter, createWebHistory } from 'vue-router'
import QuizSolveView from '@/views/QuizSolveView.vue'
import LoginView from '@/views/LoginView.vue'
import JoinView from '@/views/JoinView.vue'
import QuizCreateView from '@/views/QuizCreateView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: QuizSolveView,
    },
    {
      path: '/login',
      name: 'login',
      component: LoginView,
    },
    {
      path: '/join',
      name: 'join',
      component: JoinView,
    },
    {
      path: '/create',
      name: 'create',
      component: QuizCreateView,
    }
  ],
})

export default router
