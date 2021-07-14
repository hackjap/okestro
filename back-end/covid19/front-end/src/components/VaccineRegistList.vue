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
			desserts: [],
		};
	},

	async mounted() {
		const vaccineList = await fetchRegistedVaccine();
		console.log(vaccineList.data);
		this.datas = vaccineList.data;
	},
};
</script>
