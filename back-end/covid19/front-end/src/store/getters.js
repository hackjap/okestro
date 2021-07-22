export default {
	isLogin(state) {
		return state.name !== '';
	},
	isAdmin(state) {
		return state.name == 'admin@naver.com';
	},
};
