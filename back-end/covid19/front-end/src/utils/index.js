import axios from 'axios';
//auth

function loginUser(userData) {
	const url = 'http://localhost:8888/user/login';
	const response = axios.post(url, userData);
	return response;
}

function signupUser(userData) {
	const url = 'http://localhost:8888/user/signup';
	const response = axios.post(url, userData);
	return response;
}

// cookie
function saveAuthToCookie(value) {
	document.cookie = `til_auth=${value}`;
}

function saveUserToCookie(value) {
	document.cookie = `til_user=${value}`;
}

function getAuthFromCookie() {
	return document.cookie.replace(
		/(?:(?:^|.*;\s*)til_auth\s*=\s*([^;]*).*$)|^.*$/,
		'$1',
	);
}

function getUserFromCookie() {
	return document.cookie.replace(
		/(?:(?:^|.*;\s*)til_user\s*=\s*([^;]*).*$)|^.*$/,
		'$1',
	);
}

function deleteCookie(value) {
	document.cookie = `${value}=; expires=Thu, 01 Jan 1970 00:00:01 GMT;`;
}

export {
	saveAuthToCookie,
	saveUserToCookie,
	getAuthFromCookie,
	getUserFromCookie,
	deleteCookie,
	loginUser,
	signupUser,
};
