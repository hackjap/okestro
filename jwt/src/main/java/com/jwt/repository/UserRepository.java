package com.jwt.repository;

import com.jwt.model.User;
import org.springframework.data.jpa.repository.JpaRepository;



// 자등오로 빈 등록
public interface UserRepository extends JpaRepository<User, Long> {

    // findBy 규칙 -> username 문법
    // select * from user where username = ?
    public User findByUsername(String username);


}
