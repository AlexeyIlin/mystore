package ua.skillsup.shop.jp1.dao.module.repository.impl;

import org.springframework.stereotype.Repository;
import ua.skillsup.shop.jp1.dao.User;
import ua.skillsup.shop.jp1.dao.module.repository.UserDao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Aleksey on 14.04.2018.
 */
@Repository
public class UserDaoImpl implements UserDao {

    private final Map<Long, User> users = new HashMap <Long, User>();

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
    }
}
