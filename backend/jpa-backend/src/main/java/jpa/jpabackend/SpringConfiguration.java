package jpa.jpabackend;

import jpa.jpabackend.repository.MemberRepository;
import jpa.jpabackend.repository.MemoryMemberRepository;
import jpa.jpabackend.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfiguration {

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

}
