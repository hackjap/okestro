package okestrocovid.covid19.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;  // 주문 회원

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;  // 주문 회원


    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "cure_id")
    private Cure cure;  // 접종 정보

    private LocalDateTime orderDate; // 신청 시간

    @Enumerated(EnumType.STRING)
    private OrderStatus status;  // 신청 상태 ( ORDER, CANCEL )

    // == 연관관계 메서드 == //
    public void setMember(Member member) {
        this.member = member;
        member.getOrders().add(this);
    }

    // == 연관관계 메서드 == //
    public void setUser(User user) {
        this.user = user;
        user.getOrders().add(this);
    }

    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }

    public void setCure(Cure cure) {
        this.cure =cure;
        cure.setOrder(this);
    }

    // == 생성 메서드 == /
    public static Order createOrder(User user, Cure cure, OrderItem... orderItems) {
        Order order = new Order();
        order.setUser(user);
        order.setCure(cure);
        for (OrderItem orderItem : orderItems) {
            order.addOrderItem(orderItem);
        }
        order.setStatus(OrderStatus.ORDER);
        order.setOrderDate(LocalDateTime.now());
        return order;
    }

    /**
     * 비즈니스 로직
     */

    // 주문 취소
    public void cancel() {
        if (cure.getStatus() == CureStatus.CURE) {
            throw new IllegalStateException("이미 에약된 백신은 취소가 불가능합니다");
        }
        this.setStatus(OrderStatus.CANCEL);
        for (OrderItem orderItem : orderItems) {
            orderItem.cancel();
        }
    }





}
