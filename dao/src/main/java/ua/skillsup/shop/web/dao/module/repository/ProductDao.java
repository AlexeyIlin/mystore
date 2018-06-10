package ua.skillsup.shop.web.dao.module.repository;

import ua.skillsup.shop.web.dao.models.Product;

import java.util.List;

/**
 * Created by Aleksey on 13.05.2018.
 */
public interface ProductDao {
    void create(Product product);
    Product get(Long id);
    List<Product> findAll();
    void delete(Long id);
    void update(Long id, Product product);
}
