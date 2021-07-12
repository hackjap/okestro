package okestrocovid.covid19.service;

import okestrocovid.covid19.domain.Member;
import okestrocovid.covid19.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(value = false)
class MemberServiceTest {

    @Autowired MemberService memberService;
    @Autowired  MemberRepository memberRepository;

    @Test
    public void join() throws Exception {

        //given
        Member member = new Member();
        member.setName("장성필");

        //when
        Long saveId = memberService.join(member);

        //then
        assertEquals(member, memberRepository.findOne(saveId));
    }

}