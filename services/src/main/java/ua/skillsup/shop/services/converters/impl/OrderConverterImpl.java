package ua.skillsup.shop.services.converters.impl;

import org.springframework.stereotype.Component;
import ua.skillsup.shop.services.converters.OrderConverter;
import ua.skillsup.shop.services.dto.OrderDto;
import ua.skillsup.shop.web.dao.models.Order;
import ua.skillsup.shop.web.dao.models.Product;
import ua.skillsup.shop.web.dao.models.User;
import ua.skillsup.shop.web.dao.module.repository.ProductDao;
import ua.skillsup.shop.web.dao.module.repository.UserDao;

import java.util.List;

@Component
public class OrderConverterImpl implements OrderConverter{

    private final UserDao userDao;
    private final ProductDao productDao;
    private Long userid;
    private Long productid;

    public OrderConverterImpl(UserDao userDao, ProductDao productDao) {
        this.userDao = userDao;
        this.productDao = productDao;
    }


    public Order toEntity(OrderDto dto){



        List<User> users = userDao.findAll();
        for (int i = 0; i < users.size(); i++){
            if ( users.get(i).getFirstName().equals(dto.getFirstName()))
                userid = users.get(i).getId();
        }

        List<Product> products = productDao.findAll();
        for (int i = 0 ; i < products.size(); i++){
            if (products.get(i).getProductName().equals(dto.getProductName()))
                productid = products.get(i).getId();
        }

        return new Order(
                    null,
                userid,
                productid,
                dto.getPrice(),
                dto.getAmount()
        );
    }

    public OrderDto toDto(Order entity){

        String user = null, product = null;

        List<User> users = userDao.findAll();
        for (int i = 0; i < users.size(); i++){
            if ( users.get(i).getId().equals(entity.getUserid()))
                user = users.get(i).getFirstName();
        }

        List<Product> products = productDao.findAll();
        for (int i = 0 ; i < products.size(); i++){
            if (products.get(i).getId().equals(entity.getProductid()))
                product = products.get(i).getProductName();
        }

        return new OrderDto(
                user,
                product,
                entity.getPrice(),
                entity.getAmount()
        );
    }

}
