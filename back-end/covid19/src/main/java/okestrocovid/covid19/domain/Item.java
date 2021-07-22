package okestrocovid.covid19.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public  class Item {

    @Id @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;
    private String country;

    /**
     * 비즈니스 로직
     */
    public void addStock(int quantity) {
        this.stockQuantity += quantity;
    }

    public void removeStock(int quantity) {
        int restStock = this.stockQuantity - quantity;
        if (restStock < 0) {
            throw new NotEnoughStockException("need more stock");
        }
        this.stockQuantity = restStock;
    }
    public void restoreStock(int quantity) {
        int restStock = this.stockQuantity + quantity;
//        if (restStock < 0) {
//            throw new NotEnoughStockException("need more stock");
//        }
        this.stockQuantity = restStock;
    }
}
