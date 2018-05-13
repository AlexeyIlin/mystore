package ua.skillsup.shop.jp1.dao.module.repository;

import ua.skillsup.shop.jp1.dao.User;

import java.util.List;

/**
 * Created by Aleksey on 14.04.2018.
 */
public interface UserDao {
    void create (User user);

    List<User> findAll();

}
