import Vue from 'vue';
import VueRouter from 'vue-router';

import Home from '../views/Home.vue';
import LoginPage from '../views/LoginPage.vue';
import SignupPage from '../views/SignupPage.vue';

Vue.use(VueRouter);


const router = new VueRouter({
    mode: "history",
    routes: [{
            path: '/',
            name: 'Home',
            component: Home
        },
        {
            path: '/login',
            name: 'Login',
            component: LoginPage
        },
        {
            path: '/signup',
            name: 'Signup',
            component: SignupPage
        },
        {
            path: '/company',
            name: 'Company',
            component: () => import('../views/CompanyView.vue'),
        },
         {
            path: '/register',
            name: 'Register',
            component: () => import('../views/CompanyRegisterView.vue'),
        },
    ]
});

export default router;




// const router = new VueRouter({
//   routes: [
//     {
//       path: '/user/:userId',
//       name: 'user',
//       component: User
//     }
//   ]
// });