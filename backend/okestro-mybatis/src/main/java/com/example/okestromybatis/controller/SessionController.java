package com.example.okestromybatis.controller;

import com.example.okestromybatis.domain.Member;
import com.example.okestromybatis.domain.Session;
import com.example.okestromybatis.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RequestMapping("/login")
public class SessionController {

    private final MemberService memberService;

    @Autowired
    public SessionController(MemberService memberService) {
        this.memberService = memberService;
    }


    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public String create(@RequestBody Session session){
//        Member member1 = new Member();
//        member1.setUsername(member.setUsername());
//        member1.setEmail(member.setEmail(););
//        member1.setPassword(member.setPassword(););

        System.out.println("Session :  " + session.getEmail());
        memberService.login(session.getEmail());

        return "ajslkdfjl;kdsajf";
    }
}
