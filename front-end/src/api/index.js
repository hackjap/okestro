import axios from 'axios';

function fetchData() {
	const response = axios.get('http://localhost:9999/covid');
	// var result = data.response.body.items.item;
	return response;
}

export { fetchData };
