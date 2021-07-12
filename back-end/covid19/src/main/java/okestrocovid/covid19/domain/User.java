package okestrocovid.covid19.domain;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class User {

    private final  Long id;
    private final String email;
    private final String password;




}
