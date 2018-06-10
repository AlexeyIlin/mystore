package ua.skillsup.shop.web.dao.module.repository.impl;

import org.springframework.stereotype.Repository;
import ua.skillsup.shop.web.dao.models.User;
import ua.skillsup.shop.web.dao.module.repository.UserDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Aleksey on 14.04.2018.
 */
@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void create(User user){
        entityManager.persist(user);
    }

    @Override
    public List<User> findAll(){
         TypedQuery <User> findAllUsers =
                 entityManager.createQuery("SELECT u FROM User u", User.class);
            return findAllUsers.getResultList();
    }

    @Override
    public void delete(Long id){
        Query query = entityManager.createQuery("DELETE FROM User u where u.id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public void update(Long id, User user){
        user.setId(id);
        entityManager.merge(user);
    }

    @Override
    public User get(Long id){
        return entityManager.find(User.class, id);
    }

    /*private final Map<Long, User> users = new HashMap <Long, User>();

    private static volatile long idGenerator = 1L;

    public void create(User user) {
        user.setId(idGenerator++);
        users.put(user.getId(),user);
    }

    public List<User> findAll(){
        return new ArrayList<>(users.values());
    }

    public Map<Long, User> getUsers() {
        return users;
    }*/
}
