package okestrocovid.covid19.dto;

import lombok.Data;

@Data
public class SignupUserRequest {
    private String email;
    private String password;
    private String name;
    private String age;

}
