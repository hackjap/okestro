import Vue from 'vue';
import VueRouter from 'vue-router';
import Chart from '@/views/Chart.vue';
import Login from '@/views/Login.vue';
import SignUp from '@/views/SignUp.vue';
import Home from '../views/demo/Home.vue';
import Map from '../views/Map.vue';
import Vaccine from '../views/Vaccine.vue';
import store from '@/store/index';
import VaccineForm from '@/components/VaccineForm';
import VaccineList from '@/components/VaccineList';
import VaccineRegistForm from '../components/VaccineRegistForm.vue';

import AdminRegister from '../views/AdminRegister';
// import VaccineRegistList from '../components/VaccineRegistList.vue';
import VaccineRegistList from '../components/VaccineRegistList.vue';
// import Chart from '@/views/Chart';
Vue.use(VueRouter);

const router = new VueRouter({
	mode: 'history',
	routes: [
		{
			path: '/',
			name: 'Home',
			component: Home,
			meta: { auth: true },
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
			meta: { auth: true },
		},
		{
			path: '/map',
			name: '코로나 맵',
			component: Map,
			meta: { auth: true },
		},
		{
			path: '/vaccine',
			name: '백신',
			component: Vaccine,
			meta: { auth: true },
		},
		{
			path: '/vaccineform',
			name: '백신폼',
			component: VaccineForm,
			meta: { auth: true },
		},
		{
			path: '/vaccinelist',
			name: '백신리스트',
			component: VaccineList,
			meta: { auth: true },
		},
		{
			path: '/vaccineregistform',
			name: '백신등록',
			component: VaccineRegistForm,
			meta: { auth: true },
		},
		{
			path: '/vaccineregistlist',
			name: '등록리스트',
			component: VaccineRegistList,
			meta: { auth: true },
		},
		{
			path: '/adminregister',
			name: '관리자페이지',
			component: AdminRegister,
			meta: { admin: true },
		},
	],
});

// 네비게이션 가드
router.beforeEach((to, from, next) => {
	if (to.meta.auth && !store.getters.isLogin) {
		alert('로그인하고 써라 ㅋㅋ');
		next('/login');
		return; //
	}
	next();
});

export default router;
