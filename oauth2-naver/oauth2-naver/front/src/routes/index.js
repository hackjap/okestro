import Vue from 'vue';
import VueRouter from 'vue-router';
import MainPage from "@/components/MainPage";
import LoginForm from "@/components/demoLoginForm";
import NaverLogin from "@/components/NaverLogin";
import NaverCallback from "@/components/NaverCallback";
Vue.use(VueRouter);NaverLogin

// export default new VueRouter
const router = new VueRouter({
    mode: 'history',
    routes: [
        {
            path: '/',

        },
        {
            path: '/main',
            component: MainPage,
        },
        {
            path: '/login',
            component: LoginForm,
        },
        {
          path: '/naverlogin',
          component: NaverLogin,
        },
        {
            path: '/navercallback',
            component: NaverCallback,
        }

        // {
        //     path: '/login',
        //     component: () => import('@/views/LoginPage.vue'),
        // },

    ],
});


export default router;
