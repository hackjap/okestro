<template>
	<v-container class="container">
		<DateFilter @fetch="fillData($event, 0)"></DateFilter>

		<div class="chart-container" align="center">
			<line-chart :chartData="datacollection" :options="options"></line-chart>
		</div>
		<div align="center">
			<CycleButton
				@prev="prependDay(dayCycle)"
				class="cycle-button ml-7"
				@next="appendDay(dayCycle)"
			></CycleButton>
		</div>
		<div class="table-container ">
			<hr class="primary lighten-4" />

			<transition name="page">
				<SimpleDataTable
					class="ma-10"
					:day="this.dayCycle"
					:listnum="this.listNum"
				></SimpleDataTable>
			</transition>
			<!-- <DataTable class="mt-10" none></DataTable> -->
		</div>

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
import DateFilter from '@/components/common/DateFilter';
import CycleButton from '@/components/common/CycleButton.vue';
// import DataTable from '@/components/DataTable.vue';
import SimpleDataTable from '@/components/common/SimpleDataTable.vue';
import { fetchPatient } from '../api/covid';
import { Line } from 'vue-chartjs';

export default {
	components: {
		LineChart,
		DateFilter,
		CycleButton,
		// DataTable,
		SimpleDataTable,
	},
	data() {
		return {
			datacollection: null,
			value: [], // 총 코로나 확진자 정보
			patients: [], // 일일 코로나 확진자 수
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
	beforeMount() {
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
				// 데이터 테이블에도 보내기
				this.listFlag = false;
			}
		},
		appendDay(size) {
			if (this.listNum <= 0) alert('마지막 리스트입니다.');
			else {
				this.listNum -= size;
				this.fillData(size, this.listNum);
				this.listFlag = true;
			}
		},
	},
};
</script>

<style>
.container {
	width: 80%;
	margin: 0 auto;
	padding: 0;
}
.chart-container * {
	width: 400px;
	height: 400px;
}

.cycle-button {
	width: 350px;
}

/* 라우터 트랜지션 */
.page-enter-active,
.page-leave-active {
	transition: opacity 0.5s;
}
.page-enter, .page-leave-to /* .fade-leave-active below version 2.1.8 */ {
	opacity: 0;
}
</style>
