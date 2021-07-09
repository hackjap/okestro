import axios from 'axios';

function fetchPatient() {
	const response = axios.get('http://localhost:9999/covid');
	// var result = data.response.body.items.item;
	return response;
}

function fetchVaccine() {
	const url =
		'https://api.odcloud.kr/api/15077586/v1/centers?page=1&perPage=100&serviceKey=%2F6YC05LX402Mq1%2Beg8O2m74njrcI2N0h7Km4BNbneOT0MOJlEhWA7Zj7y5c0NrBO2PYPPHWjGBfMFEk6731aug%3D%3D';
	const response = axios.get(url);
	return response;
}

export { fetchPatient, fetchVaccine };
