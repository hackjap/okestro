<template>
	<v-form ref="form" v-model="valid" lazy-validation>
		<v-text-field
			v-model="name"
			:counter="10"
			:rules="nameRules"
			label="Name"
			required
		></v-text-field>

		<v-text-field
			v-model="email"
			:rules="emailRules"
			label="E-mail"
			required
		></v-text-field>

		<v-text-field v-model="password" label="password" required></v-text-field>

		<v-select
			v-model="age"
			:items="items"
			:rules="[v => !!v || 'Item is required']"
			label="Item"
			required
		></v-select>

		<v-checkbox
			v-model="checkbox"
			:rules="[v => !!v || 'You must agree to continue!']"
			label="Do you agree?"
			required
		></v-checkbox>

		<v-btn :disabled="!valid" color="success" class="mr-4" @click="submitForm">
			회원가입
		</v-btn>

		<v-btn color="error" class="mr-4" @click="reset">
			초기화
		</v-btn>
	</v-form>
</template>

<script>
import { signupUser } from '@/api/auth';
export default {
	data: () => ({
		value: '',
		valid: true,
		name: '',

		nameRules: [
			v => !!v || 'Name is required',
			v => (v && v.length <= 10) || 'Name must be less than 10 characters',
		],
		email: '',
		emailRules: [
			v => !!v || 'E-mail is required',
			v => /.+@.+\..+/.test(v) || 'E-mail must be valid',
		],
		age: null,
		items: ['10대', '20대', '30대', '40대', '50대', '60대이상'],
		checkbox: false,
		password: '',
	}),

	methods: {
		async submitForm() {
			this.validate();
			const userData = {
				email: this.email,
				password: this.password,
				name: this.name,
				age: this.age,
			};
			try {
				const { data } = await signupUser(userData);
				console.log(userData);
				// this.value = data.findUsers; // user 배열
				console.log(data);
				this.value = data.name;
				if (this.value != '') alert(`${data.name}님 가입을 환영합니다.`);
				else throw '올바른 정보를 입력하세요';

				this.$router.push('/home');
			} catch (error) {
				alert(`올바른 정보를 입력하세요`);
				this.$router.push('/signup');
			}
		},

		validate() {
			this.$refs.form.validate();
		},
		reset() {
			this.$refs.form.reset();
			this.resetValidation();
		},
	},
};
</script>

<style></style>
