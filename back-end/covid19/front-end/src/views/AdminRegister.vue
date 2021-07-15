<template>
	<v-card>
		<v-tabs fixed-tabs border-color="indigo" dark>
			<v-tab class=" display-1 primary" @click="firstTab">
				백신등록
			</v-tab>
			<v-tab class="display-1 primary" @click="secondTab">
				백신목록
			</v-tab>
		</v-tabs>
		<template v-if="this.flag">
			<VaccineRegistForm></VaccineRegistForm>
		</template>
		<template v-else>
			<VaccineRegistList></VaccineRegistList>
		</template>
	</v-card>
</template>

<script>
import VaccineRegistList from '../components/VaccineRegistList.vue';
import VaccineRegistForm from '../components/VaccineRegistForm.vue';
export default {
	data() {
		return {
			flag: true,
		};
	},
	components: {
		VaccineRegistForm,
		VaccineRegistList,
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
