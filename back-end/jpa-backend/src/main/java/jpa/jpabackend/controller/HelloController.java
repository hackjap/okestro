package jpa.jpabackend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","JAPJPAJPA!!");
        return "hello";
        // return 의 hello를  resource: template/ 에서 찾아 템플릿 엔진처리를 해줌
        // 컨트롤러에서 리턴 값으로 문자를 반환하면 '뷰 리졸버'가 화면을 찾아서 처리
    }

    // MVC를 이용한 웹 개발
    // 웹 브라우저 -> 서버 -> 스프링 컨테이너(컨트롤러->뷰리졸브)->서버->웹 브라우저
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name",name); // key, value

        return "hello-template";
    }

    // API를 이용한 웹 개발
    @GetMapping("hello-string")
    @ResponseBody // 리턴 값을 body에 삽입
    public String helloString(@RequestParam("name")String name){
        return "hello" + name;
    }

    // JSON 객체로 넘겨주는 API 방식 ( 통상적인 방식 )
    // 객체가 리턴값으로 오면 JSON 방식으로 전달하도록 내장되어있음 (JsonConverter)
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name")String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;



    }



    static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
