<template>
 <div class="contents">
		<div class="form-wrapper form-wrapper-sm">
			<form @submit.prevent="submitForm" class="form">
				<div>
					<label for="name">회사명 </label>
					<input id="name" type="text" v-model="name" />
				</div>
				<div>
					<label for="address">주소 </label>
					<input id="address" type="text" v-model="address" />
				</div>
			
				<button type="submit" class="btn">등록하기</button>
			</form>
			<p class="log">{{ logMessage }}</p>
		</div>
	</div>
</template>

<script>
import {registerCompany} from '../api/index.js';
export default {
	data(){
		return{
			name:'',
			address : '',
		}
	},
	methods:{
		async submitForm(){
			const companyData = {
				name : this.name,
				address : this.address,
			}
			const {data} = await registerCompany(companyData);
			console.log(data);
			alert('등록성공'+ data);
		}
	}
}
</script>

<style>

</style>