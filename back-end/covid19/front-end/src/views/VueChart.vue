<template>
	<v-container class="small mt-0">
		<DateFilter @fetch="fillData($event, 0)"></DateFilter>
		<line-chart :chartData="datacollection" :options="options"></line-chart>
		<CycleButton
			@prev="prependDay(dayCycle)"
			@next="appendDay(dayCycle)"
		></CycleButton>
		<!-- <v-text-field label="몇일전?" center v-model="inputDay">
			<v-icon @click="appendDay" slot="append" color="red">
				mdi-plus
			</v-icon>
			<v-icon @click="prependDay" slot="prepend" color="green">
				mdi-minus
			</v-icon>
		</v-text-field>
		<v-btn @click="fillData(inputDay, 0)">확인</v-btn> -->
	</v-container>
</template>

<script>
import LineChart from '@/mixins/LineChart';
import DateFilter from '@/components/DateFilter';
import CycleButton from '@/components/CycleButton.vue';
import { fetchPatient } from '../api/covid';
import { Line } from 'vue-chartjs';

export default {
	components: {
		LineChart,
		DateFilter,
		CycleButton,
	},
	data() {
		return {
			datacollection: null,
			value: [],
			patients: [],
			date: [],
			options: {
				scales: {
					yAxes: [
						{
							softMax: 2,
							tickAmount: 3,
							display: true,
							ticks: {
								suggestedMin: 10, // minimum will be 0, unless there is a lower value.
								suggestedMax: 2000, // 2000고정
								// OR //
								beginAtZero: true, // minimum value will be 0.
							},
						},
					],
				},
			},
			inputDay: undefined,
			listNum: 0, // 차트에 보여지는 리스트 목록
			dayCycle: 0,
		};
	},
	mounted() {
		this.fillData(7, 0);
	},
	methods: {
		async fillData(day, cycle) {
			this.dayCycle = day;
			await this.fetchData(day, cycle);
			this.datacollection = {
				type: Line,
				labels: this.date.reverse(),

				datasets: [
					{
						label: '일별 코로나 확진자',
						backgroundColor: '#f87979',
						data: this.patients.reverse(),
					},
				],
			};
		},

		async fetchData(day, cycle) {
			// 코로나 확진자 총 데이터
			const { data } = await fetchPatient(day, cycle);
			this.value = data.response.body.items.item;
			console.log(data);
			console.log(this.value);

			this.getPatient();
			this.getDate();
		},

		getPatient() {
			const tmp = this.value;
			this.patients = [];
			for (var i = 1; i < tmp.length; i++) {
				this.patients.push(tmp[i - 1].decideCnt - tmp[i].decideCnt);
			}
		},

		getDate() {
			const tmp = this.value;
			this.date = [];

			for (var i = 1; i < tmp.length; i++) {
				this.date.push(this.dateSlice(tmp[i].createDt));
			}

			console.log('날짜');
			console.log(this.date);
			// this.datacollection.labels = this.date;
		},

		dateSlice(string) {
			return string.slice(5, 10);
		},
		prependDay(size) {
			if (this.listNum < 0) {
				alert('마지막 리스트입니다.');
			} else {
				this.listNum += size;
				this.fillData(size, this.listNum);
			}
		},
		appendDay(size) {
			if (this.listNum <= 0) alert('마지막 리스트입니다.');
			else {
				this.listNum -= size;
				this.fillData(size, this.listNum);
			}
		},
	},
};
</script>

<style>
.small {
	max-width: 600px;
	margin: 150px auto;
}
</style>
