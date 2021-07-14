package okestrocovid.covid19.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemForm {

    private Long id;

    private String name; // 백신명
    private int price; // 가격
    private int stockQuantity; // 수량
    private String country; // 원산지


}
