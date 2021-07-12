package okestrocovid.covid19.controller;


import lombok.RequiredArgsConstructor;
import okestrocovid.covid19.domain.Item;
import okestrocovid.covid19.domain.Member;
import okestrocovid.covid19.domain.Order;
import okestrocovid.covid19.repository.OrderSearch;
import okestrocovid.covid19.service.ItemService;
import okestrocovid.covid19.service.MemberService;
import okestrocovid.covid19.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    private final MemberService memberService;
    private final ItemService itemService;

    @GetMapping("/order")
    public String createForm(Model model) {

        List<Member> members = memberService.findMembers();
        List<Item> items = itemService.findItems();

        model.addAttribute("members", members);
        model.addAttribute("items", items);

        return "order/orderForm";
    }

    @PostMapping(value = "/order")
    public String order(@RequestParam("memberId") Long memberId,
                        @RequestParam("itemId") Long itemId,
                        @RequestParam("count") int count) {

        orderService.order(memberId, itemId, count);
        return "redirect:/orders";

    }

    /**
     * 주문 목록 검색, 취소
     */
    @GetMapping("/orders")
    public String orderList(@ModelAttribute("orderSearch") OrderSearch orderSearch, Model model) {

        List<Order> orders = orderService.findOrders(orderSearch);
        model.addAttribute("orders", orders);

        return "order/orderList";
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
