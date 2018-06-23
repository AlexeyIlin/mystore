package ua.skillsup.shop.web.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ua.skillsup.shop.services.ProductService;
import ua.skillsup.shop.services.dto.ProductDto;
import ua.skillsup.shop.web.dao.module.repository.ProductDao;

import java.util.List;


@Controller
@RequestMapping("/products")
public class ProductControler {

    private final static Logger Log = LoggerFactory.getLogger(ProductControler.class);
    private final ProductService productService;

    @Autowired
    public ProductControler(ProductService productService){
        this.productService = productService;
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    List<ProductDto> findAll(){
        return productService.findAll();
    }


    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody ProductDto product){
        Log.info("Create product" , product);
        productService.create(product);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id){
        Log.info("Product deleted", id);
        productService.delete(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void update(@PathVariable("id") Long id, @RequestBody ProductDto product){
        Log.info("Product updated" , id, product);
        productService.update(id, product);
    }

}
