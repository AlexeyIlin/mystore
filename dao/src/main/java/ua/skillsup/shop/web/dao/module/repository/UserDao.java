package ua.skillsup.shop.web.dao.module.repository;

import ua.skillsup.shop.web.dao.User;

import java.util.List;

/**
 * Created by Aleksey on 14.04.2018.
 */
public interface UserDao {

    void create (User user);
    User get(Long id);
    List<User> findAll();
    void delete(Long id);
    void update(Long id, User user);


}
