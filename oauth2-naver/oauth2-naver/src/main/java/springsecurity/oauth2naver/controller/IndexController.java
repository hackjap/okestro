package springsecurity.oauth2naver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import springsecurity.oauth2naver.config.auth.PrincipalDetails;
import springsecurity.oauth2naver.model.User;
import springsecurity.oauth2naver.repository.UserRepository;

@Controller
public class IndexController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    // 스프링 시큐리티
    // 세션( 시큐리티 세션( Authentication객체( UserDeails,OAuth2User ) ) )

    @GetMapping("/test/login")
    public @ResponseBody
    String loginTest(Authentication authentication,
                     @AuthenticationPrincipal PrincipalDetails userDetails) { // DI(의존성주입)
        System.out.println(" /test/login -----------------------------");
        PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();
        System.out.println("authentication = " + principalDetails.getUser());

        System.out.println("userDetails = " + userDetails.getUsername());
        return "세션 정보 확인하기";
    }

    @GetMapping("/test/oauth/login")
    public @ResponseBody
    String testAuthLogin(Authentication authentication,
                            @AuthenticationPrincipal OAuth2User oauth)  { // DI(의존성주입)
        System.out.println(" /test/oauth/login -----------------------------");
        OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();
        System.out.println("authentication = " + oAuth2User.getAttributes());
        System.out.println("oauth2User= " + oauth.getAttributes());

        return "OAuth 세션 정보 확인하기";
    }

    // localhost:8080/
    // locathost:8080
    @GetMapping({"", "/"})
    public String index() {
        // 머스테치 기본폴더 src/main/resource/
        // 뷰리졸버 설정 : template(prefix).mustache (suffix) 생략가능
        return "index";
    }

    @GetMapping("/user")
    public @ResponseBody
    String user() {
        return "user";
    }

    @GetMapping("/admin")
    public @ResponseBody
    String admin() {
        return "admin";
    }

    @GetMapping("/manager")
    public @ResponseBody
    String manager() {
        return "manager";
    }

    @GetMapping("/loginForm")
    public String loginForm() {
        return "loginForm";
    }

    @GetMapping("/joinForm")
    public String joinForm() {
        return "joinForm";
    }

    @PostMapping("/join")
    public String join(User user) {
        user.setRole("ROLE_USER");
        String rawPassword = user.getPassword();
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);
        user.setPassword(encPassword);
        userRepository.save(user); // => 패스워드 암호화가 되지 않아 로그인이 x
        return "redirect:/loginForm";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/info")
    public @ResponseBody
    String info() {
        return "개인정보";
    }

    // 하나를 걸고 싶을때 Secured 사용, 여러개일 경우 PreAuthorize 사용
    @PreAuthorize("hasRole('ROLE_MANAGER') or hasRole('ROLE_ADMIN')")
    @GetMapping("/data")
    public @ResponseBody
    String data() {
        return "데이터 정보";
    }

}
