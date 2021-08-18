<template>
  <div>
  <h1> 로그인 페이지 </h1>
    <hr/>
    <form action="/login" method="post">
      <input type="text" name="username" placeholder="Username"/> <br/>
      <input type="password" name="password" placeholder="Password"/> <br/>
      <button>로그인</button>
    </form>
<!--    <a href="/oauth2/authorization/google">구글 로그인 </a>-->
<!--    http://localhost:8080/oauth2/authorization/google-->

      <a :href=naverLoginURL>네이버 </a>
      <button @click="naverLogin"> back</button>
       <a href="http://localhost:8080/oauth2/authorization/naver"> naver </a>





    <a href="/joinForm">회원가입을 아직 하지 않으셨나요?</a>
  </div>
</template>


<script>
import axios from 'axios';
export default {
  data () {
    return {
      CLIENT_ID: 'EoQSd796FEMLdqpCDjjh',
      // redirectURI: 'http%3a%2f%2flocalhost%3a8080%2ftest%2flogin',
      // redirectURI: 'http://localhost:8080/',

      //  FIXME state 값 random string 으로 변경
      state: 123,
      // naverLoginURL: 'https://nid.naver.com/oauth2.0/authorize?response_type=code'
         naverLoginURL: 'http://localhost:8080/oauth2/authorization/naver'
    }

  },
  created()
  {
    // this.naverLoginURL += '&client_id=' + this.CLIENT_ID
    // this.naverLoginURL += '&redirect_uri=' + this.redirectURI
    // this.naverLoginURL += '&state=' + this.state
  },
 methods:{
   async naverLogin() {
     // this.$router.push(this.naverLoginURL);
     const response = await axios.get("http://localhost:8080/test/login")
     console.log(response);

   }
 }
}

</script>

<style scoped>

</style>