package ua.skillsup.shop.services;

import ua.skillsup.shop.services.dto.ProductDto;

import java.util.List;

/**
 * Created by Aleksey on 13.05.2018.
 */
public interface ProductServices {
    void create(ProductDto product);

    List<ProductDto> findAll();
}
