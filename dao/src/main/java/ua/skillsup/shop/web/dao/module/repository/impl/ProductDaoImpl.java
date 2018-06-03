package ua.skillsup.shop.web.dao.module.repository.impl;

import ua.skillsup.shop.web.dao.Product;
import ua.skillsup.shop.web.dao.module.repository.ProductDao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Aleksey on 13.05.2018.
 */
public class ProductDaoImpl implements ProductDao {

    private final Map<Long, Product> products = new HashMap<Long, Product>();

    private static volatile long idGenerator = 1L;

    public void create(Product product) {
        product.setId(idGenerator++);
        products.put(product.getId(),product);
    }

    public List<Product> findAll(){
        return new ArrayList<>(products.values());
    }

    public Map<Long, Product> getProducts() {
        return products;
    }
}
