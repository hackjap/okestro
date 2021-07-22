<template>
	<v-data-table
		class="elevation-1"
		:headers="headers"
		:items="covid"
		:items-per-page="7"
	>
		<template v-slot:default>
			<thead>
				<tr class="primary table-header">
					<th class="text-left white--text ">
						날짜
					</th>
					<th class="text-left white--text">
						확진환자
					</th>
					<th class="text-left white--text">
						격리해제
					</th>
					<th class="text-left white--text">
						치료중
					</th>
					<th class="text-left white--text">
						사망
					</th>
				</tr>
			</thead>
			<tbody class="grey lighten-5">
				<tr
					v-for="(item, i) in value"
					:key="item.name"
					class="font-weight-medium "
				>
					<template v-if="i !== value.length - 1">
						<td class="">{{ item.stateDt }}</td>
						<td class="">
							{{ item.decideCnt }}
							<span class="red--text ">{{ '▲' + patients[i] }} </span>
						</td>
						<td>
							{{ item.clearCnt }}
							<span class="indigo--text">{{ '▲' + clear[i] }} </span>
						</td>
						<td>
							{{ item.careCnt }}
							<span class="green--text">{{ '▲' + care[i] }} </span>
						</td>
						<td>
							{{ item.deathCnt }}
							<span class="grey--text">{{ '▲' + death[i] }} </span>
						</td>
					</template>
				</tr>
			</tbody>
		</template>
	</v-data-table>
</template>

<script>
import { fetchPatient } from '../api/covid';

export default {
	async created() {
		await this.fetchData(14, 0);
	},
	methods: {
		async fetchData(day, cycle) {
			// 코로나 확진자 총 데이터
			const { data } = await fetchPatient(day, cycle);
			this.value = data.response.body.items.item;
			console.log(this.value);

			this.getTableData();
			// this.getPatient();
			// this.getDate();
		},

		getTableData() {
			const tmp = this.value;

			// this.patients = null  추후 초기화 예정

			for (var i = 1; i < tmp.length; i++) {
				// this.patients.push(tmp[i - 1].decideCnt - tmp[i].decideCnt);
				// this.clear.push(tmp[i - 1].clearCnt - tmp[i].clearCnt);
				// this.care.push(tmp[i - 1].careCnt - tmp[i].careCnt);
				// this.death.push(tmp[i - 1].deathCnt - tmp[i].deathCnt);

				var cash = {};
				cash.stateDt = this.value[i - 1].stateDt;
				cash.patients =
					tmp[i - 1].decideCnt.toString() +
					' ▲' +
					(tmp[i - 1].decideCnt - tmp[i].decideCnt).toString();
				cash.clear =
					tmp[i - 1].clearCnt.toString() +
					' ▲' +
					(tmp[i - 1].clearCnt - tmp[i].clearCnt).toString();
				cash.care =
					tmp[i - 1].careCnt.toString() +
					' ▲' +
					(tmp[i - 1].careCnt - tmp[i].careCnt).toString();
				cash.death =
					tmp[i - 1].deathCnt.toString() +
					' ▲' +
					(tmp[i - 1].deathCnt - tmp[i].deathCnt).toString();

				// cash.clear = tmp[i - 1].clearCnt - tmp[i].clearCnt;
				// cash.care = tmp[i - 1].careCnt - tmp[i].careCnt;
				// cash.death = tmp[i - 1].deathCnt - tmp[i].deathCnt;
				this.covid.push(cash);
			}

			console.log(this.patients);
		},
	},

	data() {
		return {
			headers: [
				{ text: '날짜', value: 'stateDt', class: 'success--text ' },
				{ text: '확진환자', value: 'patients' },
				{ text: '격리해제', value: 'clear' },
				{ text: '치료수', value: 'care' },
				{ text: '사망수', value: 'death' },
			],
			covid: [],
			value: null,
			patients: [],
			clear: [],
			care: [],
			death: [],
			todayData: [], // 일일 데이터
		};
	},
};
</script>

<style scoped>
.table-header > * {
	font-size: 32px;
}
</style>
