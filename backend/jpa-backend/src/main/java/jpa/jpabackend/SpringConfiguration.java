package jpa.jpabackend;

import jpa.jpabackend.domain.Member;
import jpa.jpabackend.repository.JpaMemberRepository;
import jpa.jpabackend.repository.MemberRepository;
import jpa.jpabackend.repository.MemoryMemberRepository;
import jpa.jpabackend.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

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
