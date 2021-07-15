package okestrocovid.covid19.repository;

import lombok.RequiredArgsConstructor;
import okestrocovid.covid19.domain.Item;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ItemRepository {

    private final EntityManager em;

    // 저장 : 아이템이 있을 경우 병합
    public void save(Item item) {
        if (item.getId() == null) {
            em.persist(item);
        }else{
            em.merge(item);
        }
    }

    @Transactional
    public void update(Item itemParam) {
        Item findItem = em.find(Item.class, itemParam.getId());
        findItem.setStockQuantity(itemParam.getStockQuantity());

    }

    // 항목 찾기
    public Item findOne(Long id) {
        return  em.find(Item.class, id);
    }

//    // dlfmah찾기
//    public Item findOne(Long id) {
//        return  em.find(Item.class, id);
//    }

    // 전체 찾기
    public List<Item> findAll() {
        return em.createQuery("select i from Item i ",Item.class).getResultList();
    }

}
