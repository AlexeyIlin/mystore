package ua.skillsup.shop.web.dao.module.repository.impl;

import org.springframework.stereotype.Repository;
import ua.skillsup.shop.web.dao.models.Order;
import ua.skillsup.shop.web.dao.module.repository.OrderDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class OrderDaoImpl implements OrderDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void create(Order order){
        entityManager.persist(order);
    }

    @Override
    public void delete(Long orderid){
        Query query = entityManager.createQuery("DELETE FROM Order o WHERE o.orderid = :orderid");
        query.setParameter("orderid", orderid);
        query.executeUpdate();
    }

    @Override
    public void update(Long orderid, Order order){
        order.setOrderid(orderid);
        entityManager.merge(order);
    }

    @Override
    public Order get(Long orderid){
        return entityManager.find(Order.class,orderid);
    }

    @Override
    public List<Order> findAll(){
        TypedQuery <Order> findAllOrders =
                entityManager.createQuery("SELECT o FROM Order o", Order.class);
            return findAllOrders.getResultList();
    }

}
