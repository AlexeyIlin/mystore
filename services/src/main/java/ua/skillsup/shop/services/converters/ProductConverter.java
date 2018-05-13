package ua.skillsup.shop.services.converters;

import ua.skillsup.shop.jp1.dao.Product;
import ua.skillsup.shop.services.dto.ProductDto;

/**
 * Created by Aleksey on 13.05.2018.
 */
public interface ProductConverter {

    Product toEntity(ProductDto dto);
    ProductDto toDto(Product entity);
}
