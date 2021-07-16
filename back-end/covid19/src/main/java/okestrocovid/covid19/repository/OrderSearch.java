package okestrocovid.covid19.repository;

import lombok.Getter;
import lombok.Setter;
import okestrocovid.covid19.domain.CureStatus;


@Getter
@Setter
public class OrderSearch {

    private String userName;  // 회원 이름
    private CureStatus orderStatus; // 주문 상태  ORDER,CANCEL
}
