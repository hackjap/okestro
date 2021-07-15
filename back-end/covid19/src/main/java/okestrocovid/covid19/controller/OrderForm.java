package okestrocovid.covid19.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Setter
public class OrderForm {

    private Long userId;
    private Long itemId;
    private int count;



}
