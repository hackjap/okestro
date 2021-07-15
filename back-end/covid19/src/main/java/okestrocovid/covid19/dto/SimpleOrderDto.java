package okestrocovid.covid19.dto;

import lombok.Data;
import okestrocovid.covid19.domain.Order;
import okestrocovid.covid19.domain.OrderStatus;


import java.time.LocalDateTime;

@Data
public class SimpleOrderDto {
    private Long orderId;
    private String userName;
    private String orderName;
    private LocalDateTime orderDate;
    private OrderStatus orderStatus;


    public SimpleOrderDto(Order order){
        orderId = order.getId();
        userName = order.getUser().getName();
        orderName = order.getOrderItems().get(0).getItem().getName();
        orderDate = order.getOrderDate();
        orderStatus = order.getStatus();

    }
}
