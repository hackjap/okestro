<template>
	<v-card class="pa-3">
		<v-form ref="form" v-model="valid" lazy-validation>
			<v-text-field
				v-model="formData.vaccine"
				label="백신명"
				required
			></v-text-field>
			<v-text-field
				v-model="formData.price"
				label="가격"
				required
			></v-text-field>
			<v-text-field
				v-model="formData.quantity"
				label="수량"
				required
			></v-text-field>
			<v-text-field
				v-model="formData.country"
				label="원산지"
				required
			></v-text-field>
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
import { registVaccine } from '@/utils/index';
export default {
	data: () => ({
		formData: {
			vaccine: '',
			price: ' ',
			quantity: '',
			count: '',
		},
		users: '',
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
		data: {
			vaccines: [],
			users: [],
			count: '',
			checkbox: false,
			password: '',
		},
	}),

	methods: {
		async submitForm() {
			this.validate();
			const userData = {
				name: this.formData.vaccine,
				price: this.formData.price,
				stockQuantity: this.formData.quantity,
				country: this.formData.country,
			};
			try {
				const { data } = await registVaccine(userData);
				console.log(userData);
				// this.value = data.findUsers; // user 배열
				console.log(data);
				this.value = data.name;

				alert('등록완료');
				this.initForm();
			} catch (error) {
				alert(`올바른 정보를 입력하세요`);
				this.$router.push('/adminregister');
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
			(this.formData.vaccine = ' '),
				(this.formData.price = ''),
				(this.formData.quantity = ' '),
				(this.formData.country = '');
		},
	},
};
</script>

<style></style>
