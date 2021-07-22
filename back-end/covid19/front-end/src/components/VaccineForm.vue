<template>
	<v-content class="pa-3 ">
		<v-card class="grey lighten-4 pa-5">
			<p class="text-center indigo--text ">잔여 백신 현황</p>
			<VaccineRegistList class="pa-3"></VaccineRegistList>
		</v-card>
		<v-form ref="form" v-model="valid" lazy-validation class="mt-5">
			<v-select
				v-model="userId"
				:items="select.userList"
				item-text="name"
				item-value="id"
				label="회원조회"
				required
			></v-select>
			<!-- :rules="[v => !!v || 'Item is required']" -->
			<v-select
				v-model="vaccineId"
				:items="select.vaccineList"
				item-text="name"
				item-value="id"
				:rules="[v => !!v || 'Item is required']"
				label="백신조회"
				required
			></v-select>

			<v-text-field v-model="count" label="수량" required></v-text-field>

			<v-btn
				:disabled="!valid"
				color="success"
				class="mr-4"
				@click="submitForm"
			>
				신청하기
			</v-btn>
		</v-form>
	</v-content>
</template>

<script>
import { fetchRegistedVaccine, fetchUserList, orderVaccine } from '@/api/covid';
import VaccineRegistList from '@/components/VaccineRegistList.vue';
import bus from '@/utils/bus';
export default {
	async mounted() {
		this.fillData();
	},
	data: () => ({
		// select v-model
		userId: '', // 유저아이디
		vaccineId: '', // 백신아이디
		count: '', // 수량
		valid: true,

		nameRules: [
			v => !!v || 'Name is required',
			v => (v && v.length <= 10) || 'Name must be less than 10 characters',
		],
		email: '',
		emailRules: [
			v => !!v || 'E-mail is required',
			v => /.+@.+\..+/.test(v) || 'E-mail must be valid',
		],

		// 여기에 사용자 데이터 받아오면댐
		select: {
			userList: [],
			vaccineList: [],

			count: '',
			checkbox: false,
			password: '',
		},
	}),
	methods: {
		async submitForm() {
			const orderData = {
				userId: this.userId,
				itemId: this.vaccineId,
				count: this.count,
			};
			console.log(orderData);
			try {
				await orderVaccine(orderData);
				alert('등록완료');
				this.initForm();
				bus.$emit('refresh');
			} catch (error) {
				alert('올바른 수량 입력하세요');
			}
		},
		async fillData() {
			const response = await fetchRegistedVaccine();
			const { data } = await fetchUserList(); // 유저목록
			const fetchedVaccin = response.data; // 백신목록
			// console.log(data.data);

			data.data.forEach(element => {
				// 내 회원정보만 표시
				if (this.$store.state.name == element.email)
					this.select.userList.push(element);
			});

			// this.select.userList.push(this.$store.state.name);
			fetchedVaccin.forEach(element2 => {
				this.select.vaccineList.push(element2);
			});
		},

		validate() {
			this.$refs.form.validate();
		},
		reset() {
			this.$refs.form.reset();
			this.resetValidation();
		},
		initForm() {
			(this.userId = ''), (this.itemId = ''), (this.count = 1);
		},
	},
	components: { VaccineRegistList },
};
</script>

<style></style>
