<template>
	<v-container>
		<v-card>
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
							<td>{{ data.quantity }}</td>
							<td>{{ data.country }}</td>
						</tr>
					</tbody>
				</template>
			</v-simple-table>
		</v-card>
		<v-card>
			<v-card class="mt-10"></v-card>
			<VaccineList></VaccineList>
		</v-card>
	</v-container>
</template>

<script>
import { fetchRegistedVaccine } from '@/api/index';
import VaccineList from '@/components/VaccineList.vue';
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

	components: {
		VaccineList,
	},
};
</script>
