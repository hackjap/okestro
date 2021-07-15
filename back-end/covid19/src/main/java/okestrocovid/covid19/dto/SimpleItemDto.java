package okestrocovid.covid19.dto;


import lombok.Data;

@Data
public class SimpleItemDto {
    private Long id;
    private String name;
    private int price;
    private int quantity;
    private String country;


    public SimpleItemDto(Long id, String name, int price, int quantity,String country) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.country = country;
    }


}
