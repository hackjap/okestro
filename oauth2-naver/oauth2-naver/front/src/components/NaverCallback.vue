<template>
  <div>
    <p>naver login access pages</p>
    <p>{{this.accessToken}}</p>
                                                                                                                                                                                                                                  </div>
</template>

<script>
import axios from "axios";

export default {

  data(){
    return{
      naver_id_login : '',
      accessToken : String,
      userInfo :{}
    }
  },
   methods:{
    // async naverSignInCallback() {
    //   this.email = await this.naver_id_login.getProfileData('email');
    //   this.username = await this.naver_id_login.getProfileData('name');
    //   }

     async getNaverData(accessToken) {
       console.log(accessToken)
       const response = await axios.post("http://localhost:9999/naver/profile", accessToken);
       console.log(response);
       this.userInfo = response.data.response;
       console.log(this.userInfo);
     }
  },
  async mounted() {

    this.naver_id_login =  await new window.naver_id_login("EoQSd796FEMLdqpCDjjh", "http://localhost:8888/navercallback");

    this.accessToken = this.naver_id_login.getAccessToken();
    // alert(this.accessToken);

    // this.naver_id_login.get_naver_userprofile(this.naverSignInCallback());
    // console.log(this.naver_id_login);
    // console.log(this.naverSignInCallback());

    await this.getNaverData(this.accessToken);
  }

}
</script>

<style scoped>

</style>