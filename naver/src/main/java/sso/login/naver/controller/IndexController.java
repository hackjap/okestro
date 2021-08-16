package sso.login.naver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    // localhost:8080/
    // locathost:8080
    @GetMapping({"","/"})
    public String index(){
        // 머스테치 기본폴더 src/main/resource/
        // 뷰리졸버 설정 : template(prefix).mustache (suffix) 생략가능
        return "index";
    }
}
