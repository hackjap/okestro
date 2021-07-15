package okestrocovid.covid19.controller;


import lombok.RequiredArgsConstructor;
import okestrocovid.covid19.domain.Item;
import okestrocovid.covid19.domain.Member;
import okestrocovid.covid19.domain.Order;
import okestrocovid.covid19.domain.User;
import okestrocovid.covid19.dto.SimpleOrderDto;
import okestrocovid.covid19.repository.OrderRepository;
import okestrocovid.covid19.repository.OrderSearch;
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
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    private final UserService userService;
    private final ItemService itemService;
    private final OrderRepository orderRepository;
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

    // 주문
    @PostMapping(value = "/order")
    public String order(@RequestBody OrderForm form){

//        Order order = new Order();

        orderService.order(form.getUserId(),form.getItemId(),form.getCount());
        return "주문완료";

    }

    /**
     * 주문 목록 검색, 취소
     */


    @GetMapping("/orders")
    public  List<SimpleOrderDto> orders() {

        List<Order> orders = orderRepository.findAllWithUserDelivery();
        List<SimpleOrderDto>result = orders.stream()
                .map(o -> new SimpleOrderDto(o))
                .collect(Collectors.toList());

        return result;
    }

    /**
     * 주문 취소
     */

    @PostMapping("/orders/{orderId}/cancel")
    public String cancelOrder(@PathVariable("orderId")Long orderId){

        orderService.cancelOrder(orderId);

        return "redirect:/orders";
    }


}
