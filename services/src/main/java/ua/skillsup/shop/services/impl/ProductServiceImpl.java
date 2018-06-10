package ua.skillsup.shop.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import ua.skillsup.shop.web.dao.Product;
import ua.skillsup.shop.web.dao.module.repository.ProductDao;
import ua.skillsup.shop.services.ProductService;
import ua.skillsup.shop.services.converters.ProductConverter;
import ua.skillsup.shop.services.dto.ProductDto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aleksey on 13.05.2018.
 */
public class ProductServiceImpl implements ProductService {

    private final ProductDao productDao;
    private final ProductConverter productConverter;

    @Autowired
    public ProductServiceImpl(ProductDao productDao, ProductConverter productConverter) {
        this.productDao = productDao;
        this.productConverter = productConverter;
    }

    public void  create(ProductDto product){
        Product productEntity = productConverter.toEntity(product);
        productDao.create(productEntity);
    }

    public List<ProductDto> findAll() {
        List<Product> products = productDao.findAll();

        List<ProductDto> productDto = new ArrayList<ProductDto>();

        for(Product product: products){
            ProductDto dto = productConverter.toDto(product);
            productDto.add(dto);
        }

        return productDto;
    }
}
