package okestrocovid.covid19.service;


import lombok.RequiredArgsConstructor;
import okestrocovid.covid19.domain.Item;
import okestrocovid.covid19.repository.ItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    @Transactional
    public void saveItem(Item item) {
        itemRepository.save(item);
    }

    public List<Item> findItems() {
        return itemRepository.findAll();
    }

    @Transactional
    public void updateItem(Long itemId,String name,int quantity){
        Item findItem = itemRepository.findOne(itemId);
        findItem.setName(name);
        findItem.setStockQuantity(quantity);


//        return itemRepository.update(item);
    }



    public Item findOne(Long itemId) {
        return itemRepository.findOne(itemId);
    }



}
