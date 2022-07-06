import { createWebHistory, createRouter } from "vue-router";
import CalculatorPage from '@/views/CalculatorPage.vue';
import AdminPage from '@/views/AdminPage.vue';

const routes = [
  {
    path: "/",
    name: "Home",
    component: CalculatorPage,
  },
  {
    path: "/admin",
    name: "Admin",
    component: AdminPage,
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;

