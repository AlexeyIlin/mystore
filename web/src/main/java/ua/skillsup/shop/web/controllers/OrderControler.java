package ua.skillsup.shop.web.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ua.skillsup.shop.services.OrderService;
import ua.skillsup.shop.services.converters.OrderConverter;
import ua.skillsup.shop.services.dto.OrderDto;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderControler {

    private final static Logger Log = LoggerFactory.getLogger(OrderConverter.class);
    private final OrderService orderService;

    @Autowired
    public OrderControler(OrderService orderService){
        this.orderService = orderService;
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    List<OrderDto> findAll() {
        return orderService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody OrderDto order){
        Log.info("Order created", order);
        orderService.create(order);
    }

    @RequestMapping(value = "{orderid}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("orderid") Long orderid){
        Log.info("Order Deleted" , orderid);
        orderService.delete(orderid);
    }


}
