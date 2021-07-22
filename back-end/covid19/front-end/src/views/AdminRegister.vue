<template>
	<v-card>
		<!-- <template>
			<v-tabs>
				<v-tab @click="firstTab">잔여백신예약</v-tab>
				<v-tab @click="secondTab">백신예약조회</v-tab>
			</v-tabs>
		</template> -->
		<v-tabs fixed-tabs>
			<v-tab @click="firstTab">
				관리자 정보 등록
			</v-tab>
			<v-tab @click="secondTab">
				관리자 정보 수정
			</v-tab>
		</v-tabs>
		<div class="ma-5 pa-3" none>
			<template v-if="this.flag">
				<VaccineRegistForm></VaccineRegistForm>
			</template>
			<template v-else>
				<VaccineRegistList></VaccineRegistList>
			</template>
		</div>
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
