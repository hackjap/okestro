package okestrocovid.covid19.service;


import lombok.RequiredArgsConstructor;
import okestrocovid.covid19.domain.User;
import okestrocovid.covid19.dto.LoginUserRequest;
import okestrocovid.covid19.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;


    /**
     * 회원 가입
     */
    @Transactional
    public Long join(User user) {
        validateDuplicateUser(user);
        userRepository.save(user);
        return user.getId();
    }

    private void validateDuplicateUser(User user) {
        List<User> findUsers = userRepository.findByEmail(user.getEmail());
        if (!findUsers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    /**
     * 로그인
     */
    public List<User> login(LoginUserRequest loginUserRequest) {
        List<User> findUsers = userRepository.findByEmail(loginUserRequest.getEmail());
      /*  for(int i=0; i<findUsers.size();i++) {
            boolean val = findUsers.get(i).getEmail().equals(loginUserRequest.getEmail())
                    && findUsers.get(i).getPassword().equals(loginUserRequest.getPassword());
            if(val){
                return "성공";
            }
            else{
                throw new IllegalStateException("아이디 또는 비밀번호가 일치하지 않습니다.!");
            }
        }*/
//        loginUserRequest.get



        return findUsers;
    }


    /**
     * 전체 회원 조회
     */

    public List<User> findUsers(){
        return userRepository.findAll();
    }

    public User findOne(Long userId) {
        return userRepository.findOne(userId);
    }


}
