package jpa.jpabackend.repository;

import jpa.jpabackend.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// 인터페이스가 인터페이스를 받을때는 상속관계 = extends
// 또한 인터페이스는 다중 상속이 가능함
public interface SpringDataJpaMemberRepository extends JpaRepository<Member,Integer>,MemberRepository{

    @Override
    Optional<Member> findByName(String name);
}
