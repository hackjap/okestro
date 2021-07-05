package com.example.okestromybatis.repository;


import com.example.okestromybatis.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// 인터페이스가 인터페이스를 받을때는 상속관계 = extends
// 또한 인터페이스는 다중 상속이 가능함
public interface SpringDataJpaMemberRepository extends JpaRepository<Member,Integer>,MemberRepository{

    // JPQL : select m from Member m where m.name = ?
    @Override
    Optional<Member> findByName(String name);
}
