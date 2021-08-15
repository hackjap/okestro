package sso.login.naver;

import org.springframework.data.repository.CrudRepository;
import sso.login.naver.domain.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User,Long> {

    Optional<User> findByEmail(String email);
}
