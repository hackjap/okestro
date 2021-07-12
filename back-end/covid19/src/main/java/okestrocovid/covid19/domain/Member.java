package okestrocovid.covid19.domain;

// 회원 엔티티

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member
{
    @Id @GeneratedValue
    @Column(name="member_id")
    private Long id;
    private String name;
    private int age;
    private String address;


    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();
}
