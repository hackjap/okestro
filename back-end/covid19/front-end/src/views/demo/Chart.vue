<template>
	<div>
		<v-card color="grey lighten-4">
			<v-card-title>일별 신규 확진자 수</v-card-title>
			<!-- 차트 -->
			<div style="width:500px">
				<canvas id="myChart"></canvas>
			</div>
		</v-card>

		<v-form ref="form">
			<span>
				<v-text-field v-model="date" label="날짜" required></v-text-field>
				<v-btn class="mt-5" @click="chartConfig(7)"> 일주일 </v-btn>
				<v-btn class="mt-5" @click="chartConfig(30)"> 한달 </v-btn>
			</span>
		</v-form>
	</div>
</template>
<script>
import Chart from 'chart.js';
import { fetchPatient } from '@/api/covid';
export default {
	data: () => ({
		store: [],
		value: [],
		myChart: {},
		// ctx: {},
	}),
	mounted() {
		this.ctx = document.getElementById('myChart');
	},

	methods: {
		async fetchCovid(date) {
			const { data } = await fetchPatient(date);
			// 코로나 확진자 가져오기
			const patients = data.response.body.items.item;

			this.store = patients;

			const temp = [];
			for (var i = 1; i < patients.length; i++) {
				temp.push(patients[i - 1].decideCnt - patients[i].decideCnt);
				console.log(patients[i].decideCnt);
			}
			this.value = temp.reverse();

			// return temp.reverse();
		},

		fetchDate() {
			var result = [];
			var strTmp = this.store.reverse();
			for (var i = 1; i < strTmp.length; i++) {
				result.push(this.dateSlice(strTmp[i].createDt));
			}
			console.log(result);
			return result;
		},

		dateSlice(string) {
			return string.slice(0, 10);
		},
		async getWeek() {
			var result = await this.fetchCovid(7);
			return result;
		},
		async getMonth() {
			var result = await this.fetchCovid(30);
			return result;
		},

		async chartConfig(day) {
			var ctx = document.getElementById('myChart');
			var date = this.fetchDate();

			const myChart = new Chart(ctx, {
				type: 'line',
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
			myChart.data.datasets[0].data = this.value;
			myChart.update();

			if (day == 7) {
				await this.getWeek();
			} else if (day == 30) {
				await this.getMonth();
			} else {
				await this.getMonth();
			}
			// const dataSet = result;
			// await this.fetchCovid();
			console.log('Mount :' + this.value);

			// int a = Math.random;s

			// this.ctx == null;
			// this.ctx = document.getElementById('myChart');
			// this.myChart = null;

			// myChart.destroy();
			// console.log(myChart);
		}, // end of chartConfig
	},
};
</script>

<style></style>
