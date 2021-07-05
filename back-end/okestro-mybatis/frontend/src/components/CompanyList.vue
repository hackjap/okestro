<template>
     <div class="contents">
		<div class="form-wrapper form-wrapper-sm">
            <ul class="news-list" >
            <button class="btn" @click="getData">회사 조회</button>
            <li class="post " v-for="company in companys" :key="company.id">{{company.name}} {{company.address}}</li>
            </ul>
        </div>
    </div>
</template>

<script >
import {fetchCompany} from '../api/index.js';


export default {

   
    data() {
        return{
            companys : [],
            
        }
    },
    methods : {
        async getData(){
            const {data} = await fetchCompany();
            console.log(data);
            this.companys = data;
        }
    }
}
</script>

<style scoped>
.news-list {
  margin: 0;
  padding: 0;
}
.post {
  list-style: none;
  display: flex;
  align-items: center;
  border-bottom: 1px solid #eee;
  color: #04a139;
 
}

