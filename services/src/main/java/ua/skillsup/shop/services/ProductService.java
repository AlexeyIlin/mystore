package ua.skillsup.shop.services;

import ua.skillsup.shop.services.dto.ProductDto;

import java.util.List;

/**
 * Created by Aleksey on 13.05.2018.
 */
public interface ProductService {

    void create(ProductDto product);
    void delete(Long id);
    void update(Long id, ProductDto product);

    List<ProductDto> findAll();
}
