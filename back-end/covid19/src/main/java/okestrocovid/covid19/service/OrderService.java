package okestrocovid.covid19.service;

import lombok.RequiredArgsConstructor;
import okestrocovid.covid19.domain.*;
import okestrocovid.covid19.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderService {

    private final UserRepository userRepository;
    private  final OrderRepository orderRepository;
    private final ItemRepository itemRepository;

    // ** 주문 /
    @Transactional
    public Long order(Long userId, Long itemId, int count) {

        // 엔티티 조회
        User user = userRepository.findOne(userId);
        Item item = itemRepository.findOne(itemId);

        // 치료정보 생성
        Cure cure = new Cure();
        cure.setStatus(CureStatus.READY);

        // 신청백신생성
        OrderItem orderItem = OrderItem.createOrderItem(item, count);

        // 신청 생성
        Order order = Order.createOrder(user, cure, orderItem);

        // 주문 저장
        orderRepository.save(order);

        return order.getId();

    }


    // ** 주문 취소 **
    @Transactional
    public void cancelOrder(Long orderId) {

        // 주문 엔티티 조회
        Order order = orderRepository.findOne(orderId);

        // 주문 취소
        order.cancel();
    }

    public List<Order>findOrders(){
        return orderRepository.findAll();
    }
    // 검색
    public List<Order> findSearch(OrderSearch orderSearch) {
        return orderRepository.findAllByCriteria(orderSearch);
    }

}
