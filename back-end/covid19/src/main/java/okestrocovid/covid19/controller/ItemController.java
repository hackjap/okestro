package okestrocovid.covid19.controller;

import lombok.RequiredArgsConstructor;
import okestrocovid.covid19.domain.Item;
import okestrocovid.covid19.service.ItemService;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    //  상품등록
    @PostMapping("/items/new")
    public Item create(@RequestBody ItemForm form) {

        Item item = new Item();
        item.setName(form.getName());
        item.setPrice(form.getPrice());
        item.setStockQuantity(form.getStockQuantity());
        item.setCountry(form.getCountry());

        itemService.saveItem(item);
        return item;
    }

    /**
     * 상품 목록
     */
    @GetMapping("/items")
    public List<Item> list() {
        List<Item> items = itemService.findItems();

        return items;
    }

    /**
     * 상품  수정 폼
     */
//    @GetMapping("/items/{itemId}/edit")
//    public String updateItemForm(@PathVariable("itemId") Long itemId, Model model) {
//
//        Item item = itemService.findOne(itemId);
//
//        ItemForm form = new ItemForm();
//        form.setId(item.getId());
//        form.setName(item.getName());
//        form.setStockQuantity(item.getStockQuantity());
//
//        model.addAttribute("form", form);
//        return "items/updateItemForm";
//    }
//
//
//    /**
//     * 상품 수정, 권장 코드
//     */
//
//    @PostMapping("/items/{itemId}/edit")
//    public String updateItem(@ModelAttribute("form") ItemForm form) {
//
//        itemService.updateItem(form.getId(),form.getName(),form.getStockQuantity());
//        return "redirect:/items";
//
//    }

}
