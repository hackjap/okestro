<template>
  <div>
    <h1> 네이버 로그인</h1>
    <div id="naver_id_login"></div>
<!--    <div id="naverIdLogin"></div>-->
  </div>
</template>


<script>



export default {

  async mounted() {
    const naver_id_login = await new window.naver_id_login("EoQSd796FEMLdqpCDjjh", "http://localhost:8888/navercallback");
    const state = naver_id_login.getUniqState();
    naver_id_login.setButton("white", 3,60);
    naver_id_login.setDomain("http://localhost:8888/");
    naver_id_login.setState(state)
    naver_id_login.setPopup();

    naver_id_login.init_naver_id_login();
  }


}
</script>

<style scoped>

</style>