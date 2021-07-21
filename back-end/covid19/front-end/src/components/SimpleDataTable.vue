<template>
	<v-simple-table>
		<template v-slot:default>
			<thead>
				<tr class="table-header green lighten-5">
					<th class="text-left black--text ">
						날짜
					</th>
					<th class="text-left black--text">
						확진환자
					</th>
					<th class="text-left black--text">
						격리해제
					</th>
					<th class="text-left black--text">
						치료중
					</th>
					<th class="text-left black--text">
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
	</v-simple-table>
</template>
<script>
import { fetchPatient } from '../api/covid';

export default {
	async created() {
		await this.fetchData(7, 0);
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
			for (var i = 1; i < tmp.length; i++) {
				this.patients.push(tmp[i - 1].decideCnt - tmp[i].decideCnt);
				this.clear.push(tmp[i - 1].clearCnt - tmp[i].clearCnt);
				this.care.push(tmp[i - 1].careCnt - tmp[i].careCnt);
				this.death.push(tmp[i - 1].deathCnt - tmp[i].deathCnt);
			}

			console.log(this.patients);
		},
	},

	data() {
		return {
			covid: [],
			value: null,
			patients: [], // 확진자 수
			clear: [], // 격리해제 수
			care: [], // 치료수
			death: [], // 사망자 수
			table: [],
		};
	},
};
</script>
