package okestrocovid.covid19.dto;

import lombok.Data;
import okestrocovid.covid19.domain.User;

@Data
public class LoginUserRequest {
    private String email;
    private String password;

    public LoginUserRequest(User user) {
        email = user.getEmail();
        password = user.getPassword();
    }

    public LoginUserRequest() {

    }
}
