<template>
	<v-container>
		<p
			class="text-center white--text grey darken-1 mt-8"
			v-if="this.$store.getters.isAdmin"
		>
			백신 등록 리스트
		</p>
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
						<th class="text-left ">수량</th>
						<th class="text-left">국가</th>
					</tr>
				</thead>
				<tbody>
					<tr v-for="data in datas" :key="data.name">
						<td>{{ data.name }}</td>
						<td class="indigo--text">
							{{ data.price.toLocaleString() + '원' }}
						</td>
						<td class="red--text">{{ data.quantity + '개' }}</td>
						<td>{{ data.country }}</td>
					</tr>
				</tbody>
			</template>
		</v-simple-table>

		<template v-if="this.$store.getters.isAdmin">
			<p class="text-center white--text grey darken-1 mt-8">
				백신 예방 접종 리스트
			</p>
			<v-card>
				<v-card class=""></v-card>

				<VaccineList class="pa-1"></VaccineList>
			</v-card>
		</template>
	</v-container>
</template>

<script>
import { fetchRegistedVaccine } from '@/api/covid';
import VaccineList from '@/components/VaccineList.vue';
import bus from '@/utils/bus';
export default {
	data() {
		return {
			datas: [],
		};
	},

	mounted() {
		this.getData();
		bus.$on('set:quantity', this.getData);
		bus.$on('refresh', this.getData);
	},
	beforeDestroy() {
		bus.$off('refresh', this.getData);
		bus.$off('set:quantity', this.getData);
	},
	watch: {},
	methods: {
		async getData() {
			const vaccineList = await fetchRegistedVaccine();
			this.datas = vaccineList.data;

			this.$store.commit('setOrderitem', this.datas);
		},
	},

	// watch: {
	// 	day: async function() {
	// 		await this.fetchData(this.day, 0);
	// 	},
	// 	listnum: async function() {
	// 		await this.fetchData(this.day, this.listnum);
	// 	},
	// },
	components: {
		VaccineList,
	},
};
</script>
