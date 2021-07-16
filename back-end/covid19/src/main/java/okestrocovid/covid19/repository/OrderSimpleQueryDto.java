package okestrocovid.covid19.repository;

import okestrocovid.covid19.domain.CureStatus;
import okestrocovid.covid19.domain.OrderStatus;

import java.time.LocalDateTime;

public class OrderSimpleQueryDto {

    private Long orderId;
    private String name;
    private LocalDateTime orderDate;
    private CureStatus orderStatus;


    public OrderSimpleQueryDto(Long orderId, String name, LocalDateTime orderDate, CureStatus orderStatus) {
        this.orderId = orderId;
        this.name = name;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
    }
}
