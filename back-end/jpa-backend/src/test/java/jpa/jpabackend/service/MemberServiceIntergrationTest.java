//package jpa.jpabackend.service;
//
//import jpa.jpabackend.domain.Member;
//import jpa.jpabackend.repository.MemberRepository;
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//
//public class MemberServiceIntergrationTest {
//
//    @Autowired MemberService memberService;
//    @Autowired MemberRepository memberRepository;
//    @Test
//    public void 회원가입() throws Exception {
//        //Given
//        Member member = new Member();
//        member.setName("hello");
//        //When
//        int saveId = memberService.join(member);
//        //Then
//        Member findMember = memberRepository.findById(saveId).get();
//        org.junit.jupiter.api.Assertions.assertEquals(member.getName(), findMember.getName());
//    }
//    @Test
//    public void 중복_회원_예외() throws Exception {
//        //Given
//        Member member1 = new Member();
//        member1.setName("spring");
//        Member member2 = new Member();
//        member2.setName("spring");
//        //When
//        memberService.join(member1); IllegalStateException e = org.junit.jupiter.api.Assertions.assertThrows(IllegalStateException.class,
//                () -> memberService.join(member2));//예외가 발생해야 한다.
//        Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//    }
//
//}
