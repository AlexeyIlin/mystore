package ua.skillsup.shop.web.dao.module.repository;

import ua.skillsup.shop.web.dao.Product;

import java.util.List;

/**
 * Created by Aleksey on 13.05.2018.
 */
public interface ProductDao {
    void create (Product user);

    List<Product> findAll();
}
