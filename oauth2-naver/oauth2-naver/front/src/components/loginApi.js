
export default{

    naverLogin(naver_id_login){
        // const naver_id_login = new naver_id_login("EoQSd796FEMLdqpCDjjh", "http://192.168.0.195:5500/naver_callback.html");
// 접근 토큰 값 출력
        alert(naver_id_login.oauthParams.access_token);
// 네이버 사용자 프로필 조회
        naver_id_login.get_naver_userprofile("naverSignInCallback()");
// 네이버 사용자 프로필 조회 이후 프로필 정보를 처리할 callback function
        function naverSignInCallback() {
            alert(naver_id_login.getProfileData('email'));
            alert(naver_id_login.getProfileData('name'));
        }

        console.log(naverSignInCallback());

    }



}