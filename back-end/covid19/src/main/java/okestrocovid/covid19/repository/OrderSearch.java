package okestrocovid.covid19.repository;

import lombok.Getter;
import lombok.Setter;
import okestrocovid.covid19.domain.OrderStatus;

@Getter
@Setter
public class OrderSearch {

    private String userName;  // 회원 이름
    private OrderStatus orderStatus; // 주문 상태  ORDER,CANCEL
}
