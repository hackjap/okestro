package okestrocovid.covid19.repository;

import lombok.RequiredArgsConstructor;
import okestrocovid.covid19.domain.Member;
import okestrocovid.covid19.domain.Order;
import okestrocovid.covid19.domain.User;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderRepository {

    private final EntityManager em;

    public void save(okestrocovid.covid19.domain.Order order) {
        em.persist(order);
    }

    public okestrocovid.covid19.domain.Order findOne(Long id) {
        return em.find(Order.class, id);
    }

    public List<Order> findAll() {
        return em.createQuery("select o from Order o ",Order.class).getResultList();
    }
    public List<Order> findAllByCriteria(OrderSearch orderSearch) {
        // 검색 로직
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Order> cq = cb.createQuery(Order.class);
        Root<Order> o = cq.from(Order.class);
        Join<Order, User> m = o.join("user", JoinType.INNER); //회원과 조인
        List<Predicate> criteria = new ArrayList<>();
        //주문 상태 검색
        if (orderSearch.getOrderStatus() != null) {
            Predicate status = cb.equal(o.get("status"),
                    orderSearch.getOrderStatus());
            criteria.add(status);
        }
        //회원 이름 검색
        if (StringUtils.hasText(orderSearch.getUserName())) {
            Predicate name =
                    cb.like(m.<String>get("name"), "%" +
                            orderSearch.getUserName() + "%");
            criteria.add(name);
        }
        cq.where(cb.and(criteria.toArray(new Predicate[criteria.size()])));
        TypedQuery<Order> query = em.createQuery(cq).setMaxResults(1000); //최대    1000건

        return query.getResultList();

    }

    public List<Order>  findAllWithUserDelivery(){
        return em. createQuery(
                "select o from Order o" +
                        " join fetch o.user u" +
                        " join  fetch  o.orderItems d",Order.class
        ).getResultList();
    }

    public List<OrderSimpleQueryDto> findOrderDto() {
        return  em.createQuery("select new okestrocovid.covid19.repository.OrderSimpleQueryDto(o.id,m.name,o.orderDate,o.status)  " +
                " from Order o" +
                " join o.member m " +
                " join o.cure c ", OrderSimpleQueryDto.class)
        .getResultList();
    }



}