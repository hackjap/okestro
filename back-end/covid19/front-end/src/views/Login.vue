<template>
	<v-form ref="form" v-model="valid" lazy-validation>
		<v-text-field
			v-model="email"
			:rules="emailRules"
			label="E-mail"
			required
		></v-text-field>

		<v-text-field
			v-model="password"
			:append-icon="show1 ? 'mdi-eye' : 'mdi-eye-off'"
			:type="show1 ? 'text' : 'password'"
			name="input-10-1"
			label="Normal with hint text"
			hint="At least 8 characters"
			counter
			@click:append="show1 = !show1"
		></v-text-field>
		<!-- :rules="[rules.required, rules.min]" -->
		<v-btn :disabled="!valid" color="success" class="mr-4" @click="submitForm">
			로그인
		</v-btn>

		<v-btn color="error" class="mr-4" @click="reset">
			초기화
		</v-btn>

		<v-btn color="warning" @click="gotoSignUp">
			회원가입
		</v-btn>
	</v-form>
</template>

<script>
import { loginUser } from '@/utils/index';
import { saveUserToCookie } from '@/utils/index';
export default {
	data: () => ({
		user: [],
		email: '',
		password: '',
		valid: '',
		emailRules: [
			v => !!v || 'E-mail is required',
			v => /.+@.+\..+/.test(v) || 'E-mail must be valid',
		],

		// 패스워드
		show1: false,
		show2: true,
		show3: false,
		show4: false,

		rules: {
			required: value => !!value || 'Required.',
			min: v => v.length >= 8 || 'Min 8 characters',
			emailMatch: () => `The email and password you entered don't match`,
		},

		select: null,
		items: ['Item 1', 'Item 2', 'Item 3', 'Item 4'],
		checkbox: false,
	}),

	methods: {
		async submitForm() {
			this.validate();
			const userData = {
				email: this.email,
				password: this.password,
			};
			try {
				const { data } = await loginUser(userData);
				this.user = data.data[0]; // user 배열
				console.log(this.user);

				const userEmail = this.user.email;

				saveUserToCookie(userEmail);
				this.$store.commit('setName', userEmail);

				const validation = this.user.email != '';
				if (validation) {
					alert(`${this.user.email}님 환영합니다!`);
					this.$router.push('/home');
				}
			} catch (error) {
				alert(`아이디 비밀번호를 확인하세요`);
			}
		},

		validate() {
			this.$refs.form.validate();
		},
		reset() {
			this.$refs.form.reset();
			this.resetValidation();
		},
		resetValidation() {
			this.$refs.form.resetValidation();
		},
		gotoSignUp() {
			this.$router.push('/signup');
		},
	},
};
</script>

<style></style>
