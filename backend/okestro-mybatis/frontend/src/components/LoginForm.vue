<template>
 <div class="contents">
		<div class="form-wrapper form-wrapper-sm">
			<form @submit.prevent="submitForm" class="form">
				<div>
					<label for="email">아이디 </label>
					<input id="email" type="text" v-model="email" />
				</div>
				<div>
					<label for="address">비밀번호 </label>
					<input id="address" type="text" v-model="address" />
				</div>
			
				<button type="submit" class="btn">로그인</button>
			</form>
			<p class="log">{{ logMessage }}</p>
		</div>
	</div>
</template>

<script>
// import {registerCompany} from '../api/index.js';
export default {
	data(){
		return{
			email:'',
			password : '',
		}
	},
	methods:{
		// async submitForm(){
		// 	const companyData = {
		// 		name : this.name,
		// 		address : this.address,
		// 	}
		// 	const {data} = await registerCompany(companyData);
		// 	console.log(data);
		// 	alert('등록성공'+ data);
		// }
	}
}
</script>

<style>

</style>