/**
 * 로그인/회원가입
 */

import { instance } from './index';
function loginUser(userData) {
	const url = 'http://localhost:8888/user/login';
	const response = instance.post(url, userData);
	return response;
}

function signupUser(userData) {
	const url = 'http://localhost:8888/user/signup';
	const response = instance.post(url, userData);
	return response;
}

export { loginUser, signupUser };
