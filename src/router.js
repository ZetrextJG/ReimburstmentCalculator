import { createWebHistory, createRouter } from "vue-router";
import CalculatorPage from '@/views/CalculatorPage.vue';
import AdminPage from '@/views/AdminPage.vue';

const routes = [
  {
    path: "/",
    name: "Home",
    component: CalculatorPage,
    meta: {
        title: "Calculator Page"
    }
  },
  {
    path: "/admin",
    name: "Admin",
    component: AdminPage,
    meta: {
        title: "Admin Page"
    }
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

router.beforeEach((to, _, next) => {
  document.title = to.meta.title
  next()
})

export default router;

