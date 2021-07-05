package com.example.okestromybatis.controller;

import com.example.okestromybatis.domain.Member;
import com.example.okestromybatis.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RequestMapping("/signup")
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }


    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Member create(@RequestBody Member member){
//        Member member1 = new Member();
//        member1.setUsername(member.setUsername());
//        member1.setEmail(member.setEmail(););
//        member1.setPassword(member.setPassword(););

        System.out.println("Member :  " + member.toString());
        memberService.join(member);
//        return member;
        return member;
    }
}
