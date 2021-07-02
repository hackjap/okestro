<template>
 <div class="contents">
		<div class="form-wrapper form-wrapper-sm">
			<form @submit.prevent="submitForm" class="form">
				<div>
					<label for="name">닉네임 </label>
					<input id="name" type="text" v-model="name" />
				</div>
					<div>
					<label for="email">이메일 </label>
					<input id="email" type="text" v-model="email" />
				</div>
				<div>
					<label for="password">비밀번호 </label>
					<input id="password" type="text" v-model="password" />
				</div>
			
				<button type="submit" class="btn">회원가입 </button>
			</form>
		
		</div>
	</div>
</template>

<script>
import {signupUser} from '../api/index.js';
export default {
	data(){
		return{
			name: '',
			email:'',
			password : '',
		}
	},
	methods:{
		async submitForm(){
			const userData = {
				name : this.name,
				email : this.email,
				password : this.password,
			}
			const {data} = await signupUser(userData);
			console.log(data);
			alert('등록성공'+ data);
		}
	}
}
</script>

<style>

</style>