package springsecurity.oauth2naver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@Controller
public class ApiController {

    // 로그인

    @CrossOrigin("*")
    @GetMapping("/login/naver")
    public   @ResponseBody String GoogleLogin() {

//        return "google";
        return "naver";
    }
}
