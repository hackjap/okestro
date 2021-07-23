<template>
	<v-simple-table>
		<template v-slot:default>
			<thead class="pa-3">
				<tr class="table-header green lighten-5 ">
					<td class="ta text-center black--text" style="font-size:20px">
						날짜
					</td>
					<td class="ta text-center black--text" style="font-size:20px">
						확진환자
					</td>
					<td class="ta text-center black--text" style="font-size:20px ">
						격리해제
					</td>
					<td class="ta text-center black--text" style="font-size:20px">
						치료중
					</td>
					<td class="ta text-center black--text" style="font-size:20px">
						사망
					</td>
				</tr>
			</thead>
			<tbody class="grey lighten-5">
				<tr
					v-for="(item, i) in value"
					:key="item.name"
					class="font-weight-medium "
				>
					<template v-if="i !== value.length - 1">
						<td class="text-center">{{ item.stateDt - 1 }}</td>
						<td class="text-center">
							{{ item.decideCnt.toLocaleString() + '명' }}
							<span class="red--text ">
								{{ '▲' + patients[i] }}
							</span>
						</td>
						<td class="text-center">
							{{ item.clearCnt.toLocaleString() + '명' }}
							<span class="indigo--text">{{ '▲' + clear[i] }} </span>
						</td>
						<td class="text-center">
							{{ item.careCnt.toLocaleString() + '명' }}
							<span class="green--text">{{ '▲' + care[i] }} </span>
						</td>
						<td class="text-center">
							{{ item.deathCnt.toLocaleString() + '명' }}
							<span class="grey--text">{{ '▲' + death[i] }} </span>
						</td>
					</template>
				</tr>
			</tbody>
		</template>
	</v-simple-table>
</template>
<script>
import { fetchPatient } from '@/api/covid';

export default {
	async created() {
		// this.cycle = this.day;
		// this.cycle = this.day;
		console.log(this.day);
		await this.fetchData(this.day, 0);
	},
	// async beforeUpdate() {
	// 	console.log(this.day);
	// 	await this.fetchData(this.cycle, 0);
	// },

	data() {
		return {
			covid: [],
			value: null,
			patients: [], // 확진자 수
			clear: [], // 격리해제 수
			care: [], // 치료수
			death: [], // 사망자 수
			table: [],
			dayCycle: 0,
			listNum: 0, // 차트에 보여지는 리스트 목록
		};
	},
	props: ['day', 'listnum'],
	watch: {
		day: async function() {
			await this.fetchData(this.day, 0);
		},
		listnum: async function() {
			await this.fetchData(this.day, this.listnum);
		},
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
		prependDay(size) {
			if (this.listNum < 0) {
				alert('마지막 리스트입니다.');
			} else {
				this.listNum += size;
				this.fetchData(size, this.listNum);
			}
		},
		appendDay(size) {
			if (this.listNum <= 0) alert('마지막 리스트입니다.');
			else {
				this.listNum -= size;
				this.fetchData(size, this.listNum);
			}
		},

		dateFormat(date) {
			let month = date.getMonth() + 1;
			let day = date.getDate();
			let hour = date.getHours();
			let minute = date.getMinutes();
			let second = date.getSeconds();

			month = month >= 10 ? month : '0' + month;
			day = day >= 10 ? day : '0' + day;
			hour = hour >= 10 ? hour : '0' + hour;
			minute = minute >= 10 ? minute : '0' + minute;
			second = second >= 10 ? second : '0' + second;

			return (
				date.getFullYear() +
				'-' +
				month +
				'-' +
				day +
				' ' +
				hour +
				':' +
				minute +
				':' +
				second
			);
		},
	},
};
</script>
<style scopped>
.ta {
	font-size: 20pt;
}
</style>
