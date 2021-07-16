import axios from 'axios';

/**
 * 공공 데이터 API
 */
// 코로나 확진자 수
function fetchPatient(date) {
	const response = axios.get(`http://localhost:8888/covid/week?date=${date}`);
	// var result = data.response.body.items.item;
	return response;
}

// 백신접종센터
function fetchVaccine() {
	const url =
		'https://api.odcloud.kr/api/15077586/v1/centers?page=1&perPage=200&serviceKey=%2F6YC05LX402Mq1%2Beg8O2m74njrcI2N0h7Km4BNbneOT0MOJlEhWA7Zj7y5c0NrBO2PYPPHWjGBfMFEk6731aug%3D%3D';
	const response = axios.get(url);
	return response;
}

/**
 *  백엔드 서버 API
 */

// == 관리자 API   == //

// 관리자 백신 등록 조회
function fetchRegistedVaccine() {
	const response = axios.get('http://localhost:8888/items');
	return response;
}

// 관리자 백신 등록하기I
function registVaccine(formData) {
	const response = axios.post('http://localhost:8888/items/new', formData);
	return response;
}

// == 유저 API   == //

// 유저 리스트
function fetchUserList() {
	const response = axios.get('http://localhost:8888/users');
	return response;
}

//사용자 백신 예약 리스트
function fetchOrders() {
	const response = axios.get('http://localhost:8888/orders/list');
	return response;
}

// 사용자 백신  예약
function orderVaccine(orderData) {
	const response = axios.post(
		// `http://localhost:8888/order/?userId=${userId}&itemId=${orderId}&count=${count}`
		'http://localhost:8888/orders/',
		orderData,
	);
	return response;
}

// 사용자 백신 예약 취소
function cancelOrderVaccine(orderId) {
	const response = axios.post(`http://localhost:8888/orders/${orderId}/cancel`);
	return response;
}

// 사용자 백신 접종 완료
function completeOrderVaccine(orderId) {
	const response = axios.put(
		`http://localhost:8888/orders/${orderId}/complete`,
	);
	return response;
}

// 사용자 백신 예약 삭제
function deletelOrderVaccine(orderId) {
	const response = axios.delete(
		`http://localhost:8888/orders/${orderId}/delete`,
	);
	return response;
}
export {
	orderVaccine,
	registVaccine,
	fetchPatient,
	fetchVaccine,
	fetchRegistedVaccine,
	fetchOrders,
	fetchUserList,
	cancelOrderVaccine,
	deletelOrderVaccine,
	completeOrderVaccine,
};
