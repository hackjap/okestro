<template>
 <div class="contents">
		<div class="form-wrapper form-wrapper-sm">
			<form @submit.prevent="submitForm" class="form">
				<div>
					<label for="email">아이디 </label>
					<input id="email" type="text" v-model="email" />
				</div>
				<div>
					<label for="password">비밀번호 </label>
					<input id="password" type="text" v-model="password" />
				</div>
			
				<button type="submit" class="btn">로그인</button>
			</form>
			<p class="log">{{ logMessage }}</p>
		</div>
	</div>
</template>

<script>
// import {registerCompany} from '../api/index.js';
import {loginUser} from '../api/index';
import store from '../store/index';
export default {
	data(){
		return{
			email:'',
			password : '',
		}
	},
	
	methods:{
		async submitForm(){
			const userData = {
				name : this.name,
				password : this.password,

			}
			const {data} = await loginUser(userData);
			console.log(data);
		
			const accessToken = data;
			store.state.token  = accessToken;

			if(accessToken != ''){
				alert('환영합니다.'+ data);
				this.$router.push('/');
			}else{
				alert('아이디 비밀번호를 확인하세요'+ data);
			}
			
			this.initForm();

			console.log( `STATE :${this.$store.state.token}`);

		},

		initForm(){
			this.email = '',
			this.password = '';
		},

	}
}
</script>

<style>

</style>