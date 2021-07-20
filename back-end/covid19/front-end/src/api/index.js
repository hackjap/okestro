import axios from 'axios';
// import { setInterceptors } from './common/interceptors';

// 기본(8888) 서버 초기화 함수
function createInstance() {
	return axios.create({
		baseURL: process.env.VUE_APP_API_URL,
	});
}

// function createInstanceWithAuth(url) {
// 	const instance = axios.create({
// 		baseURL: `${process.env.VUE_APP_API_URL}${url}`,
// 	});
// 	return setInterceptors(instace);
// }

// const auths = createInstanceWithAuth('users');

const instance = createInstance();

export { instance };

// 토큰 인증 관련 초기화 함수
