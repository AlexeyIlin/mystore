package ua.skillsup.shop.web.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import ua.skillsup.shop.web.dao.models.User;
import ua.skillsup.shop.web.dao.module.repository.UserDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Aleksey on 19.05.2018.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/context-dao-test.xml")
@Transactional
public class UserDAOTest {

    @Autowired
    private UserDao userDao;

    @PersistenceContext
    private EntityManager entityManager;

    @Before
    public void cleanUp(){
        entityManager.createQuery("DELETE FROM User u").executeUpdate();
        entityManager.clear();
    }

    @Test
    public void testFindByID(){
        //given
        User user = new User(null , "Alex", "Al" , 33);
        entityManager.persist(user);

        //when
        User actualUser = userDao.get(user.getId());

        //then
        Assert.assertEquals(user, actualUser);
    }

    @Test
    public void testDelete(){
        //given
        User user = new User(null, "Alexxx", "Alx", 311);
        entityManager.persist(user);
        Long id = user.getId();

        //when
        userDao.delete(id);

        //then
        entityManager.clear();
        User deletedUser = entityManager.find(User.class, id);
        Assert.assertNull(deletedUser);

    }

    @Test
    public void testUpdate(){
        //given
        User user = new User(null, "Alexs", "Als", 77);
        entityManager.persist(user);

        String newFirstName = "Ivan";
        String newLastName = "O";
        Integer newAge = 44;
        User newUser = new User(null, newFirstName, newLastName , newAge);

        //when
        userDao.update(user.getId(), newUser);

        //then
        User actualUser = entityManager.find(User.class , user.getId());

        Assert.assertEquals(newFirstName, actualUser.getFirstName());
        Assert.assertEquals(newLastName, actualUser.getLastName());
        Assert.assertEquals(newAge, actualUser.getAge());
    }

    @Test
    public void testCreate(){
        //given
        User user = new User(null , "Alex" , "A", 66);

        //when
        userDao.create(user);

        //then
        User actualUser = entityManager.find(User.class, user.getId());
        Assert.assertEquals(user, actualUser);
    }

    @Test
    public void testFindAll(){
        //given
            User user1 = new User(null , "Alex" , "A", 66);
            User user2 = new User(null , "Alex1" , "Aa", 662);

        List<User> expectedUser = Arrays.asList(user1, user2);

        expectedUser.forEach(entityManager::persist);

        //when
        List<User> foundUsers = userDao.findAll();

        //then
        Assert.assertEquals(2 , foundUsers.size());
        Assert.assertTrue(foundUsers.containsAll(expectedUser));
    }

}
