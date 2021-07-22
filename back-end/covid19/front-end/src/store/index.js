import Vue from 'vue';
import Vuex from 'vuex';
import { getUserFromCookie } from '../utils/index';
Vue.use(Vuex);

export default new Vuex.Store({
	state: {
		name: getUserFromCookie(),

		user: {},
		order: {},
		vaccine: {},
		orderitem: [],
	},
	getters: {
		isLogin(state) {
			return state.name !== '';
		},
		isAdmin(state) {
			return state.name == 'admin@naver.com';
		},
	},
	mutations: {
		setName(state, name) {
			state.name = name;
		},
		clearName(state) {
			state.name = '';
		},
		setOrderitem(state, orderitem) {
			state.orderitem = orderitem;
		},
	},
	actions: {
		// LOGIN({commit},userDate){
		// }
	},
});
