import Vue from 'vue';
import VueRouter from 'vue-router';
import Chart from '@/views/Chart.vue';
import Login from '@/views/Login.vue';
import SignUp from '@/views/SignUp.vue';
import Home from '../views/Home.vue';

// import Chart from '@/views/Chart';
Vue.use(VueRouter);

const router = new VueRouter({
	mode: 'history',
	routes: [
		{
			path: '/',
			name: 'Home',
			component: Home,
		},
		{
			path: '/signup',
			name: '회원가입',
			component: SignUp,
		},
		{
			path: '/login',
			name: '로그인',
			component: Login,
		},
		{
			path: '/chart',
			name: '코로나 차트',
			component: Chart,
		},
	],
});

export default router;
