import Vue from 'vue';
import VueRouter from 'vue-router';
import MainPage from "@/components/MainPage";
import LoginForm from "@/components/LoginForm";
Vue.use(VueRouter);

// export default new VueRouter
const router = new VueRouter({
    mode: 'history',
    routes: [
        {
            path: '/',
            redirect: '/login',
        },
        {
            path: '/main',
            component: MainPage,
        },
        {
            path: '/login',
            component: LoginForm,
        }

        // {
        //     path: '/login',
        //     component: () => import('@/views/LoginPage.vue'),
        // },

    ],
});


export default router;
