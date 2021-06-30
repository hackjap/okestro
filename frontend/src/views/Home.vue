<template>
  <div>
    <div id="main">
       <h3>[ 메인 페이지 ]</h3>
        <router-link to="/company" class ="link">회사 조회  </router-link>
       | <router-link to="/register" class ="link" >회사 등록</router-link> 
      

    </div>

  </div>
</template>

<script>

export default {
  components:{
   
  }
}
</script>

<style>
.link {
  color : blue ;
}

</style>