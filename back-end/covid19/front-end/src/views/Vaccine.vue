<template>
	<v-container class="mt-5" style="width:100%">
		<v-card>
			<template>
				<v-tabs>
					<v-tab @click="firstTab" style="font-size:20px;">잔여백신예약</v-tab>
					<v-tab @click="secondTab" style="font-size:20px;">백신예약조회</v-tab>
				</v-tabs>
			</template>
			<template v-if="this.flag">
				<VaccineForm class="ma-5" flat></VaccineForm>
			</template>
			<template v-else>
				<VaccineList class="ma-5" flat></VaccineList>
			</template>
		</v-card>
	</v-container>
</template>

<script>
import VaccineList from '../components/VaccineList.vue';
import VaccineForm from '@/components/VaccineForm.vue';
export default {
	data() {
		return {
			flag: true,
		};
	},
	components: {
		VaccineForm,
		VaccineList,
	},
	methods: {
		firstTab() {
			this.flag = true;
		},
		secondTab() {
			this.flag = false;
		},
	},
};
</script>

<style></style>
