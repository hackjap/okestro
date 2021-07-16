package okestrocovid.covid19.dto;

import lombok.Data;
import okestrocovid.covid19.domain.CureStatus;
import okestrocovid.covid19.domain.Order;



import java.time.LocalDateTime;

@Data
public class SimpleOrderDto {
    private Long orderId;
    private String userName;
    private String orderName;
    private LocalDateTime orderDate;
    private CureStatus orderStatus;


    public SimpleOrderDto(Order order){
        orderId = order.getId();
        userName = order.getUser().getName();
        orderName = order.getOrderItems().get(0).getItem().getName();
        orderDate = order.getOrderDate();
        orderStatus = order.getStatus();

    }
}
