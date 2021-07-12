package okestrocovid.covid19.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
public class Cure {

    @Id @GeneratedValue
    @Column(name = "cure_id")
    private Long id;

    @OneToOne(mappedBy = "cure",fetch = FetchType.LAZY)
    private Order order;

    @Enumerated(EnumType.STRING)
    private CureStatus status; // 준비 치료

}
