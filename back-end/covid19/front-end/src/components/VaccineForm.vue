<template>
	<v-card class="pa-3">
		<v-form ref="form" v-model="valid" lazy-validation>
			<v-select
				v-model="userId"
				:items="select.userList"
				item-text="name"
				item-value="id"
				:rules="[v => !!v || 'Item is required']"
				label="회원조회"
				required
			></v-select>
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
	</v-card>
</template>

<script>
import { fetchRegistedVaccine } from '@/api/index';
import { fetchUserList, orderVaccine } from '@/utils/index';

export default {
	async mounted() {
		const response = await fetchRegistedVaccine();
		const { data } = await fetchUserList(); // 유저목록
		const fetchedVaccin = response.data; // 백신목록
		// console.log(data.data);
		// console.log(response.data);
		data.data.forEach(element => {
			this.select.userList.push(element);
		});

		fetchedVaccin.forEach(element2 => {
			this.select.vaccineList.push(element2);
		});
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
			} catch (error) {
				alert('올바른 정보를 입력하세요');
			}
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
};
</script>

<style></style>
