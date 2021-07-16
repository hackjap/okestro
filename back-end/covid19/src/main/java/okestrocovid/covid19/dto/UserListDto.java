package okestrocovid.covid19.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserListDto {
    private Long id;
    private String name;
    private String email;

//    private String token;

}
