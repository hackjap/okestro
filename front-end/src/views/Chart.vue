<template>
	<v-container class="mt-5">
		<v-card class="" color="grey lighten-4">
			<v-card-title>일별 신규 확진자 수</v-card-title>
			<!-- 차트 -->
			<div style="width:800px">
				<canvas id="myChart"></canvas>
			</div>
		</v-card>
	</v-container>
</template>
<script>
import Chart from 'chart.js/auto';
import { fetchPatient } from '../api/index';
export default {
	data: () => ({
		store: [],
		value: [],
	}),

	methods: {
		async fetchCovid() {
			const { data } = await fetchPatient();
			const result = data.response.body.items.item;

			// 코로나 확진자
			const patients = result;
			console.log(patients);
			this.store = patients;

			const temp = [];
			for (var i = 1; i < patients.length; i++) {
				// if (i >= patients.length - 1) {
				// 	break;
				// } else {
				// if (i == 0) break;
				temp.push(patients[i - 1].decideCnt - patients[i].decideCnt);
				console.log(patients[i].decideCnt);
				// }
				console.log('VAULE : ' + this.value);
				console.log(patients.length);
			}
			this.value = temp.reverse();
		},
		fetchDate() {
			var result = [];
			var strTmp = this.store.reverse();
			for (var i = 1; i < strTmp.length; i++) {
				result.push(this.dateSlice(strTmp[i].createDt));
			}

			return result;
		},
		dateSlice(string) {
			return string.slice(0, 10);
		},
	},

	async mounted() {
		await this.fetchCovid();
		console.log('Mount :' + this.value);
		// int a = Math.random;
		var ctx = document.getElementById('myChart');
		var date = this.fetchDate();
		var myChart = new Chart(ctx, {
			type: 'bar',
			data: {
				labels: date,
				datasets: [
					{
						label: '일별 확진자 수',
						// data: [12000, 19000, 3000, 5000, 2000, 30000],
						data: this.value,

						backgroundColor: ['rgba(255, 99, 132, 0.2)'],
						borderColor: ['rgba(255, 99, 132, 1)'],
						borderWidth: 1,
					},
				],
			},
			options: {
				scales: {
					y: {
						beginAtZero: true,
					},
				},
			},
		});
		console.log(myChart);
	},
};
</script>

<style></style>
