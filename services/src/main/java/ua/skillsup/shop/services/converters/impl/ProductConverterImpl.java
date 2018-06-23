package ua.skillsup.shop.services.converters.impl;

import org.springframework.stereotype.Component;
import ua.skillsup.shop.web.dao.models.Product;
import ua.skillsup.shop.services.converters.ProductConverter;
import ua.skillsup.shop.services.dto.ProductDto;

/**
 * Created by Aleksey on 13.05.2018.
 */
@Component
public class ProductConverterImpl implements ProductConverter{

    public Product toEntity(ProductDto dto){
        return new Product(
                null,
                dto.getProductName(),
                dto.getPrice(),
                dto.getCategory(),
                dto.getGender(),
                dto.getColor(),
                dto.getSize(),
                dto.getBalance()
        );
    }

    public ProductDto toDto(Product entity){
        return new ProductDto(
                entity.getProductName(),
                entity.getPrice(),
                entity.getCategory(),
                entity.getGender(),
                entity.getColor(),
                entity.getSize(),
                entity.getBalance()
        );
    }
}
