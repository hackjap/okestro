package okestrocovid.covid19.repository;

import okestrocovid.covid19.domain.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserRepository {

    @PersistenceContext
    EntityManager em;

    // 회원정보 저장
    public Long save(User user) {
        em.persist(user);
        return user.getId();
    }

    // 회원 한명 찾기
    public User findOne(Long id) {
        return em.find(User.class, id);
    }

    // 모든 회원 정보 불러오기
    public List<User> findAll() {
        return em.createQuery("select u from User u",User.class)
                .getResultList();
    }

    // 이메일 회원 찾기
    public List<User> findByEmail(String email) {
        return em.createQuery("select u from User u where u.email = :email", User.class)
                .setParameter("email", email)
                .getResultList();
    }
}
