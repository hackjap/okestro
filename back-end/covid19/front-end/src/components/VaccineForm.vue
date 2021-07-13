<template>
	<v-card class="pa-3">
		<v-form ref="form" v-model="valid" lazy-validation>
			<v-select
				v-model="users"
				:items="data.users"
				:rules="[v => !!v || 'Item is required']"
				label="회원조회"
				required
			></v-select>
			<v-select
				v-model="vaccines"
				:items="data.vaccines"
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
import { signupUser } from '@/utils/index';
export default {
	data: () => ({
		users: '',
		vaccines: '',
		count: '',
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
			vaccines: ['A', 'B', 'C'],
			users: ['UserA', 'UserB'],
			count: '',
			checkbox: false,
			password: '',
		},
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
