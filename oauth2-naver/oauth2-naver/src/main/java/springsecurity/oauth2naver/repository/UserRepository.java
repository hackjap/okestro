package springsecurity.oauth2naver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springsecurity.oauth2naver.model.User;


// 자등오로 빈 등록
public interface UserRepository extends JpaRepository<User, Long> {

}
