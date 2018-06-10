package ua.skillsup.shop.web.dao.module.repository;

import ua.skillsup.shop.web.dao.models.Order;

import java.util.List;

public interface OrderDao {

    void create(Order order);
    Order get(Long orderid);
    List<Order>findAll();
    void delete(Long id);
    void update(Long orderid, Order order);

}
