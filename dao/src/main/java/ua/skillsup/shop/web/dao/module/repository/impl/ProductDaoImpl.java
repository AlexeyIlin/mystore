package ua.skillsup.shop.web.dao.module.repository.impl;

import org.springframework.stereotype.Repository;
import ua.skillsup.shop.web.dao.models.Product;
import ua.skillsup.shop.web.dao.module.repository.ProductDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Aleksey on 13.05.2018.
 */
@Repository
public class ProductDaoImpl implements ProductDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void create(Product product){
        entityManager.persist(product);
    }

    @Override
    public void delete(Long id){
        Query query = entityManager.createQuery("DELETE FROM Product p where p.id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public void update(Long id, Product product){
        product.setId(id);
        entityManager.merge(product);
    }

    @Override
    public Product get(Long id){
        return entityManager.find(Product.class, id);
    }

    @Override
    public List<Product> findAll(){
        TypedQuery <Product> findAllProducts =
                entityManager.createQuery("SELECT p FROM Product p", Product.class);
                return findAllProducts.getResultList();
    }




    /*private final Map<Long, Product> products = new HashMap<Long, Product>();

    private static volatile long idGenerator = 1L;
    public void create(Product product) {
        product.setId(idGenerator++);
        products.put(product.getId(),product);
    }

    public List<Product> findAll(){
        return new ArrayList<>(products.values());
    }*/

}
