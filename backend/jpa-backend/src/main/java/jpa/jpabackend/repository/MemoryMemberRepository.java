package jpa.jpabackend.repository;

import jpa.jpabackend.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;



public class MemoryMemberRepository implements MemberRepository{

    // 임시로 데이터를 담을 변수
    private static Map<Integer, Member> store = new HashMap<>();
    private static int sequence = 0; // Id 값

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(),member);
        return member;
    }

    @Override
    public Optional<Member> findById(int id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        // 파라미터의 name과 store의 name이 같은 경우 반환
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        // 모든 멤버 값을 arraylist로 반환
        return new ArrayList<>(store.values());
    }


    public void clearStore(){
        store.clear();
    }
}
