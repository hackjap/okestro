package com.example.okestromybatis.repository;

import com.example.okestromybatis.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(int id); // Optional : null 값을 감싸서 반환
    Optional<Member> findByName(String name);
    List<Member> findAll();


}
