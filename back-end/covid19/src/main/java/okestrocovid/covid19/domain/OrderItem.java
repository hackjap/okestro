package okestrocovid.covid19.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name ="order_item")
@Getter @Setter
public class OrderItem {

    @Id
    @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;  // 신청 백신

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order; // 신청

    private int count; // 신청 수량

    // == 생성 메서드 == //
    public static OrderItem createOrderItem(Item item, int count) {
        OrderItem orderItem = new OrderItem();
        orderItem.setItem(item);
        orderItem.setCount(count);

        item.removeStock(count);
        return orderItem;
    }

    // ==  비즈니스 로직 == //

    /**
     * 주문 취소
     */

    public void cancel() {
        getItem().addStock(count);
    }


}
