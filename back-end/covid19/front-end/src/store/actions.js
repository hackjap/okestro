import { loginUser } from '@/api/auth';
import { saveUserToCookie } from '@/utils/index';
import router from '../router';
import store from '@/store/index';
export default {
	async LOGIN({ commit }, userData) {
		try {
			const { data } = await loginUser(userData);
			console.log(data);
			const email = data.data[0].email;
			commit('setName', email);

			saveUserToCookie(email);

			const validation = store.state.email != '';
			if (validation) {
				alert(`${email}님 환영합니다!`);
				router.push('/');
			}
		} catch (error) {
			alert(`아이디 비밀번호를 확인해주세요!`);
		}
	},
};
