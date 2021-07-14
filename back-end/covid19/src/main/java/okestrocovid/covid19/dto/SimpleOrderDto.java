package okestrocovid.covid19.dto;

import lombok.Data;
import okestrocovid.covid19.domain.Order;
import okestrocovid.covid19.domain.OrderStatus;


import java.time.LocalDateTime;

@Data
public class SimpleOrderDto {
    private Long orderId;
    private String name;
    private LocalDateTime orderDate;
    private OrderStatus orderStatus;


    public SimpleOrderDto(Order order){
        orderId = order.getId();
        name = order.getUser().getName();
        orderDate = order.getOrderDate();
        orderStatus = order.getStatus();

    }
}
