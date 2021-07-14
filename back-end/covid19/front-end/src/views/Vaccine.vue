<template>
	<v-card>
		<v-tabs fixed-tabs border-color="indigo" dark>
			<v-tab class="display-1 primary" @click="firstTab">
				신청하기
			</v-tab>
			<v-tab class="display-1 primary" @click="secondTab">
				신청확인
			</v-tab>
		</v-tabs>
		<template v-if="this.flag">
			<VaccineForm></VaccineForm>
		</template>
		<template v-else>
			<VaccineList></VaccineList>
		</template>
	</v-card>
</template>

<script>
import VaccineList from '../components/VaccineList.vue';
import VaccineForm from '../components/VaccineForm.vue';
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
