package ua.skillsup.shop.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.skillsup.shop.services.OrderService;
import ua.skillsup.shop.services.converters.OrderConverter;
import ua.skillsup.shop.services.dto.OrderDto;
import ua.skillsup.shop.web.dao.models.Order;
import ua.skillsup.shop.web.dao.module.repository.OrderDao;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderDao orderDao;
    private final OrderConverter orderConverter;

    @Autowired
    public OrderServiceImpl(OrderDao orderDao, OrderConverter orderConverter){
        this.orderConverter = orderConverter;
        this.orderDao = orderDao;
    }

    @Transactional
    public void create(OrderDto order){
        Order orderEntity = orderConverter.toEntity(order);
        orderDao.create(orderEntity);
    }

    public List<OrderDto> findAll(){
        List<Order> orders = orderDao.findAll();
        List<OrderDto> orderDto = new ArrayList<OrderDto>();

        for(Order order: orders){
            OrderDto dto = orderConverter.toDto(order);
            orderDto.add(dto);
        }
        return orderDto;
    }

    @Transactional
    public void delete(Long orderid){
        orderDao.delete(orderid);
    }

    @Transactional
    public void update(Long orderid, OrderDto order){
        Order orderEntity = orderConverter.toEntity(order);
        orderDao.update(orderid, orderEntity);
    }



}
