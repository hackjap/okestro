package com.example.okestromybatis.repository;

import com.example.okestromybatis.domain.Member;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository {

    // jpa에는 em을 통해 동작
    private final EntityManager em;

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member); // 영구 저장
        return member;
    }

    @Override
    public Optional<Member> findById(int id) {
//        Member member = em.find(Member.class, id);
//        return Optional.ofNullable(member);

        List<Member> result = em.createQuery("select m from Member m where m.id = :id", Member.class)
                .setParameter("id", id)
                .getResultList();
        return  result.stream().findAny();
    }

    // pk 기반이 아닌 것들은 jpql를 사용 -> 추후 spring data japa
    @Override
    public Optional<Member> findByName(String name) {
        List<Member> result = em.createQuery("select  m from Member m where m.name = :name", Member.class)
                .setParameter("name",name)
                .getResultList();
        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        // 객체 자체를 select하여 가져옴
        return em.createQuery("select m from Member m",Member.class)
                .getResultList();

    }
}
