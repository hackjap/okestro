package com.example.okestromybatis;

import com.example.okestromybatis.repository.MemberRepository;
import com.example.okestromybatis.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfiguration {


    /**
     * Spring Data Jpa SetUp
     */
    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfiguration(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * Jpa Setup
     */
//    EntityManager em;
//
//    @Autowired
//    public SpringConfiguration(EntityManager em) {
//        this.em = em;
//    }

    @Bean
    public MemberService memberService() {

        return new MemberService(memberRepository);
    }

//    @Bean
//    public MemberRepository memberRepository() {
//        // return new MemoryMemberRepository();
//        //  return new JpaMemberRepository(em);  jpa
//
//    }

}
