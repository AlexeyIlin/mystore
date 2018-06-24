package ua.skillsup.shop.services;

import ua.skillsup.shop.services.dto.OrderDto;

import java.util.List;

public interface OrderService {

    void create(OrderDto order);
    //void delete(Long orderid);
    //void update(Long orderid, OrderDto order);

    List<OrderDto> findAll();

}
