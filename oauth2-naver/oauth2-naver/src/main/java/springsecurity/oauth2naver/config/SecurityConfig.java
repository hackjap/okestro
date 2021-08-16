package springsecurity.oauth2naver.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import springsecurity.oauth2naver.config.oauth.PrincipalOauth2UserService;


//1. 코드 받기(인증) 2.액세스 토큰(권한) 3.사용자 프로필 정보를 가져옴 4-1.그 정보를 토대로 회원가입을 자동으로 진행시킴
// 4-2 (이메일, 전화번호, 이름, 아이디 ) 쇼핑몰 -> (집주소), 백화점몰 -> (vip 등급, 일반등급 ) 추가정보 기입
@Configuration
@EnableWebSecurity // 스프링 시큐리티 필터(SecurityConfig)가 스프링 필터체인에 등록됨.
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true) // secured 어노테이션 활성화, preAuthorize, postAuthroize  어노테이션 활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PrincipalOauth2UserService principalOauth2UserService;

    // 해당 메서드의 리턴되는 오브젝트를 Ioc로 등록해줌.
    @Bean
    public BCryptPasswordEncoder encodePwd() {
        return new BCryptPasswordEncoder();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/user/**").authenticated() // 인증만되면 들어갈 수 있는 주소!
                .antMatchers("/manager/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_MANAGER')")
                .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
                .anyRequest().permitAll()  // 위 3개 조건을 제외한 모든 주소는 허용
                .and()
                .formLogin()
                .loginPage("/loginForm")  // 해당 조건시 , 로그인 페이지로 리다이렉션
                .loginProcessingUrl("/login") // /login 주소가 호출이 되면 시큐리티가 낚아채서 로그인을 진행해줌. ( controller의 로그인을 생략해줌 )
                .defaultSuccessUrl("/") // 로그인 시 / + "특정 페이지 " 를 지원해줌
                .and()
                .oauth2Login()
                .loginPage("/loginForm") // 구글 로그인이 완료된 뒤의 후처리가 필요함. Tip.코드 x ( 엑세스 토큰 + 사용자 프로필정보 O )
                .userInfoEndpoint()
                .userService(principalOauth2UserService);


    }

}
