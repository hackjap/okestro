<template>
	<v-simple-table>
		<template v-slot:default>
			<thead>
				<tr>
					<th class="text-left">
						백신명
					</th>
					<th class="text-left">
						가격
					</th>
					<th class="text-left">수량</th>

					<th class="text-left">국가</th>
				</tr>
			</thead>
			<tbody>
				<tr v-for="data in datas" :key="data.name">
					<td>{{ data.name }}</td>
					<td>{{ data.price }}</td>
					<td>{{ data.stockQuantity }}</td>
					<td>{{ data.country }}</td>
				</tr>
			</tbody>
		</template>
	</v-simple-table>
</template>
<script>
import { fetchRegistedVaccine } from '@/api/index';

export default {
	data() {
		return {
			datas: [],
			desserts: [
				{
					name: '장성필1',
					category: '화이자1',
					price: 100000,
					count: 159,
				},
				{
					name: '장성필2',
					category: '화이자2',
					price: 100000,
					count: 159,
				},

				{
					name: '장성필3	',
					category: '화이자3',
					price: 100000,
					count: 159,
				},
			],
		};
	},

	async mounted() {
		const vaccineList = await fetchRegistedVaccine();
		console.log(vaccineList.data);
		this.datas = vaccineList.data;
	},
};
</script>
