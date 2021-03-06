package okestrocovid.covid19.controller;


import lombok.RequiredArgsConstructor;
import okestrocovid.covid19.domain.Item;
import okestrocovid.covid19.domain.Member;
import okestrocovid.covid19.domain.Order;
import okestrocovid.covid19.domain.User;
import okestrocovid.covid19.dto.SimpleOrderDto;
import okestrocovid.covid19.repository.OrderRepository;
import okestrocovid.covid19.repository.OrderSearch;
import okestrocovid.covid19.repository.OrdersRepository;
import okestrocovid.covid19.service.ItemService;
import okestrocovid.covid19.service.MemberService;
import okestrocovid.covid19.service.OrderService;
import okestrocovid.covid19.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin("*")
@RestController
@RequestMapping("orders")

@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    private final UserService userService;
    private final ItemService itemService;
    private final OrderRepository orderRepository;
    private final OrdersRepository ordersRepository;
//    @GetMapping("/order")
//    public String createForm(@RequestBody Order model) {
//
//        List<User> users = userService.findUsers();
//        List<Item> items = itemService.findItems();
//
//        model.addAttribute("members", members);
//        model.addAttribute("items", items);
//
//        return "order/orderForm";
//    }

    // 예약
    @PostMapping(value = "")
    public String order(@RequestBody OrderForm form){

//        Order order = new Order();

        orderService.order(form.getUserId(),form.getItemId(),form.getCount());
        return "예약성공";

    }

    /**
     * 예약 목록 검색, 취소
     */

    @GetMapping("list")
    public  List<SimpleOrderDto> orders() {

        List<Order> orders = orderRepository.findAllWithUserDelivery();
        List<SimpleOrderDto>result = orders.stream()
                .map(o -> new SimpleOrderDto(o))
                .collect(Collectors.toList());

        return result;
    }

    /**
     * 예약 취소
     */

    @PostMapping("{orderId}/cancel")
    public String cancelOrder(@PathVariable("orderId")Long orderId){

        orderService.cancelOrder(orderId);

        return "예약취소 완료";
    }

    /**
     * 예약 삭제
     */

    @DeleteMapping("{orderId}/delete")
    public String deleteOrder(@PathVariable("orderId")Long orderId){

        orderService.deleteOrder(orderId);

        return "예약삭제 완료";
    }

    /**
     * 접종 완료
     */

    @PutMapping("{orderId}/complete")
    public String CompleteOrder(@PathVariable("orderId")Long orderId){

        orderService.completeOrder(orderId);

        return "예방접종완료";
    }





}
