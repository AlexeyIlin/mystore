package ua.skillsup.shop.jp1.dao.module.repository;

import ua.skillsup.shop.jp1.dao.Product;

import java.util.List;

/**
 * Created by Aleksey on 13.05.2018.
 */
public interface ProductDao {
    void create (Product user);

    List<Product> findAll();
}
