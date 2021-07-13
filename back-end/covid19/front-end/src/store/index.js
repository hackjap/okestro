import Vue from 'vue';
import Vuex from 'vuex';

Vue.use(Vuex);

export default new Vuex.Store({
	state: {
		name: '',
	},
	getters: {
		isLogin(state) {
			return state.name !== '';
		},
	},
	mutations: {
		setName(state, name) {
			state.name = name;
		},
		clearName(state) {
			state.name = '';
		},
	},
	actions: {
		// LOGIN({commit},userDate){
		// }
	},
});
