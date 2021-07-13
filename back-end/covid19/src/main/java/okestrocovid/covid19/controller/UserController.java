package okestrocovid.covid19.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import okestrocovid.covid19.domain.User;
import okestrocovid.covid19.dto.LoginUserRequest;
import okestrocovid.covid19.dto.Result;
import okestrocovid.covid19.dto.SignupUserRequest;
import okestrocovid.covid19.dto.UserListDto;
import okestrocovid.covid19.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class UserController {

    private final UserService userService;

    @PostMapping("/user/login")
    public LoginUserResponse login(@RequestBody LoginUserRequest request) {

        List<User> login = userService.login(request);

        return new LoginUserResponse(login);
    }

    @PostMapping("/user/signup")
    public SignupUserResponse signup(@RequestBody SignupUserRequest request) {
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setName(request.getName());
        user.setAge(request.getAge());

        Long id = userService.join(user);

        return new SignupUserResponse(id, request.getName());

    }

    @GetMapping("/users")
    public Result memberV2() {
        // 컬렉션에 한번 감싸서 향후 필요한 필드를 추가할 수 있음
        List<User> findMembers = userService.findUsers();
        List<UserListDto> collect = findMembers.stream()
                .map(m -> new UserListDto(m.getName(),m.getAge()))
                .collect(Collectors.toList());
        return new Result(collect);
    }

    @Data
    @AllArgsConstructor
    static class LoginUserResponse {

        private List<User> findUsers;

    }

    @Data
    @AllArgsConstructor
    static class SignupUserResponse {
        private Long id;
        private String name;
    }
}
