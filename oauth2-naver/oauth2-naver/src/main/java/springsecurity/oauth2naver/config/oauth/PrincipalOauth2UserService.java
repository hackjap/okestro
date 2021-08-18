package springsecurity.oauth2naver.config.oauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import springsecurity.oauth2naver.config.auth.PrincipalDetails;
import springsecurity.oauth2naver.config.oauth.provider.FacebookUserInfo;
import springsecurity.oauth2naver.config.oauth.provider.GoogleUserInfo;
import springsecurity.oauth2naver.config.oauth.provider.NaverUserInfo;
import springsecurity.oauth2naver.config.oauth.provider.OAuth2UserInfo;
import springsecurity.oauth2naver.model.User;
import springsecurity.oauth2naver.repository.UserRepository;

import java.util.Map;

@Service
public class PrincipalOauth2UserService extends DefaultOAuth2UserService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private  UserRepository userRepository;


    // 구글로 부터 받은 userRequest 데이터에 대한 후처리되는 함수
    // 함수 종료시 @AuthenticationPrincipal 어노테이션이 만들어진다.
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        System.out.println("getClientRegistration = " + userRequest.getClientRegistration()); // registrationId로 어떤 OAuth로 로그인 했는지 확인 가능.
        System.out.println("getAccessToken = " + userRequest.getAccessToken().getTokenValue());

        OAuth2User oAuth2User =  super.loadUser(userRequest);
        // 구글로그인 버튼 클릭 -> 구글로그인창 -> 로그인 완료 -> code를 리턴 (OAuth -Client 라이브러리) -> AccessToken 요청
        // userRquest 정보 -> loadUser함수 호출 -> 구글로부터 회원프로필 받아준다.
        System.out.println("getAttributes = " + oAuth2User.getAttributes());

        // 회원가입을 강제로 진행해볼 예정
        OAuth2UserInfo oAuth2UserInfo = null;
        if(userRequest.getClientRegistration().getRegistrationId().equals("google")){
            System.out.println("구글 로그인 요청");
            oAuth2UserInfo = new GoogleUserInfo(oAuth2User.getAttributes());
        } else if (userRequest.getClientRegistration().getRegistrationId().equals("facebook")) {
            System.out.println("페이스북 로그인 요청");
            oAuth2UserInfo = new FacebookUserInfo(oAuth2User.getAttributes());
        }
        else if (userRequest.getClientRegistration().getRegistrationId().equals("naver")) {
            System.out.println("네이버 로그인 요청");
            oAuth2UserInfo = new NaverUserInfo((Map)oAuth2User.getAttributes().get("response"));

        }
        else{
            System.out.println("구글과 페이스북과 네이버 로그인만 지원합니다.");
        }


        String provider = oAuth2UserInfo.getProvider(); // google
        String providerId =oAuth2UserInfo.getProviderId();
        String username = provider + "_"+providerId; // google_117907683636938846420
        String password = bCryptPasswordEncoder.encode("겟인데어");
        String email = oAuth2UserInfo.getEmail();
        String role = "ROLE_USER";

        User userEntity = userRepository.findByUsername(username);

        if (userEntity == null) { // 회원이 존재하지 않을 경우
            System.out.println("OAuth 로그인이 최초입니다.");
            userEntity = User.builder()
                    .username(username)
                    .password(password)
                    .email(email)
                    .role(role)
                    .provider(provider)
                    .providerId(providerId)
                    .build();
            userRepository.save(userEntity);
        } else {
            System.out.println("로그인을 이미 한적이 있습니다. 당신은 자동 회원가입이 되어 있습니다.");
        }

        return new PrincipalDetails(userEntity,oAuth2User.getAttributes());

    }

}
