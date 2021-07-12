package okestrocovid.covid19.controller;

import lombok.RequiredArgsConstructor;
import okestrocovid.covid19.domain.Item;
import okestrocovid.covid19.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @GetMapping("items/new")
    public String createForm(Model model) {
        model.addAttribute("form", new ItemForm());
        return "items/createItemForm";
    }

    @PostMapping(value = "/items/new")
    public String create(ItemForm form) {

        Item item = new Item();
        item.setName(form.getName());
        item.setStockQuantity(form.getStockQuantity());

        itemService.saveItem(item);
        return "redirect:/items";
    }

    /**
     * 상품 목록
     */
    @GetMapping("/items")
    public String list(Model model) {
        List<Item> items = itemService.findItems();
        model.addAttribute("items", items);
        return "items/itemList";
    }

    /**
     * 상품  수정 폼
     */
    @GetMapping("/items/{itemId}/edit")
    public String updateItemForm(@PathVariable("itemId") Long itemId, Model model) {

        Item item = itemService.findOne(itemId);

        ItemForm form = new ItemForm();
        form.setId(item.getId());
        form.setName(item.getName());
        form.setStockQuantity(item.getStockQuantity());

        model.addAttribute("form", form);
        return "items/updateItemForm";
    }


    /**
     * 상품 수정, 권장 코드
     */

    @PostMapping("/items/{itemId}/edit")
    public String updateItem(@ModelAttribute("form") ItemForm form) {

        itemService.updateItem(form.getId(),form.getName(),form.getStockQuantity());
        return "redirect:/items";

    }

}
