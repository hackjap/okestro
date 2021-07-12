package okestrocovid.covid19.service;

import lombok.RequiredArgsConstructor;
import okestrocovid.covid19.domain.*;
import okestrocovid.covid19.repository.ItemRepository;
import okestrocovid.covid19.repository.MemberRepository;
import okestrocovid.covid19.repository.OrderRepository;
import okestrocovid.covid19.repository.OrderSearch;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderService {

    private final MemberRepository memberRepository;
    private  final OrderRepository orderRepository;
    private final ItemRepository itemRepository;

    // ** 주문 /
    @Transactional
    public Long order(Long memberId, Long itemId, int count) {

        // 엔티티 조회
        Member member = memberRepository.findOne(memberId);
        Item item = itemRepository.findOne(itemId);

        // 치료정보 생성
        Cure cure = new Cure();
        cure.setStatus(CureStatus.READY);

        // 신청백신생성
        OrderItem orderItem = OrderItem.createOrderItem(item, count);

        // 신청 생성
        Order order = Order.createOrder(member, cure, orderItem);

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

    // 검색
    public List<Order> findOrders(OrderSearch orderSearch) {
        return orderRepository.findAllByCriteria(orderSearch);
    }

}
