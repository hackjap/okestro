/**
 * 공공 데이터 API
 */
import axios from 'axios';
import { instance } from './index';

// 코로나 확진자 수
function fetchPatient(date, cycle) {
	const response = instance.get(`covid/day?date=${date}&cycle=${cycle}`);
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
	const response = instance.get('items');
	return response;
}

// 관리자 백신 등록하기I
function registVaccine(formData) {
	const response = instance.post('items/new', formData);
	return response;
}

// == 유저 API   == //

// 유저 리스트
function fetchUserList() {
	const response = instance.get('users');
	return response;
}

//사용자 백신 예약 리스트
function fetchOrders() {
	const response = instance.get('orders/list');
	return response;
}

// 사용자 백신  예약
function orderVaccine(orderData) {
	const response = instance.post('orders/', orderData);
	return response;
}

// 사용자 백신 예약 취소
function cancelOrderVaccine(orderId) {
	const response = instance.post(`orders/${orderId}/cancel`);
	return response;
}

// 사용자 백신 접종 완료
function completeOrderVaccine(orderId) {
	const response = instance.put(`orders/${orderId}/complete`);
	return response;
}

// 사용자 백신 예약 삭제
function deletelOrderVaccine(orderId) {
	const response = instance.delete(`orders/${orderId}/delete`);
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
