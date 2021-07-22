import Vue from 'vue';
import VueRouter from 'vue-router';

// import Chart from '@/views/Chart';
import store from '@/store/index';
Vue.use(VueRouter);

const router = new VueRouter({
	mode: 'history',
	routes: [
		{
			path: '/',
			name: '코로나차트',
			component: () => import('@/views/VueChart'),

			meta: { auth: true },
		},
		{
			path: '/signup',
			name: '회원가입',
			// component: SignUp,
			component: () => import('@/views/SignUp'),
		},
		{
			path: '/login',
			name: '로그인',
			component: () => import('@/views/Login.vue'),
		},

		{
			path: '/map',
			name: '코로나 맵',
			component: () => import('@/views/Map'),

			meta: { auth: true },
		},
		{
			path: '/vaccine',
			name: '백신',
			component: () => import('@/views/Vaccine'),

			meta: { auth: true },
		},
		{
			path: '/vaccineform',
			name: '백신폼',
			component: () => import('@/components/VaccineForm'),

			meta: { auth: true },
		},
		{
			path: '/vaccinelist',
			name: '백신리스트',
			component: () => import('@/components/VaccineList'),

			meta: { auth: true },
		},
		{
			path: '/vaccineregistform',
			name: '백신등록',
			component: () => import('@/components/VaccineRegistForm'),

			meta: { auth: true },
		},
		{
			path: '/vaccineregistlist',
			name: '등록리스트',
			component: () => import('@/components/VaccineRegistList'),
			meta: { auth: true },
		},
		{
			path: '/adminregister',
			name: '관리자페이지',
			component: () => import('@/views/AdminRegister'),
			meta: { admin: true },
		},
	],
});

// 네비게이션 가드
router.beforeEach((to, from, next) => {
	if (to.meta.auth && !store.getters.isLogin) {
		alert('로그인인 후 이용해주세요.');
		next('/login');
		return;
	} else if (to.meta.admin && !store.getters.isAdmin) {
		alert('관리자 로그인 후 이용 가능합니다.');
		next('/login');
		return; //
	}
	next();
});

export default router;
