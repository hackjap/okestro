package okestrocovid.covid19.dto;

import lombok.Data;

@Data
public class LoginUserRequest {
    private String email;
    private String password;
}
