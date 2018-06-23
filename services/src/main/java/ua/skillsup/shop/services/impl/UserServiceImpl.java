package ua.skillsup.shop.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.skillsup.shop.web.dao.models.User;
import ua.skillsup.shop.web.dao.module.repository.UserDao;
import ua.skillsup.shop.services.UserService;
import ua.skillsup.shop.services.converters.UserConverter;
import ua.skillsup.shop.services.dto.UserDto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aleksey on 14.04.2018.
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private final UserConverter userConverter;

    @Autowired
    public UserServiceImpl(UserDao userDao, UserConverter userConverter) {
        this.userDao = userDao;
        this.userConverter = userConverter;
    }

    @Transactional
    public void create(UserDto user){
        User userEntity = userConverter.toEntity(user);
        userDao.create(userEntity);
    }

    @Transactional
    public void delete(Long id){
        userDao.delete(id);
    }

    @Transactional
    public void update(Long id, UserDto user){
        User entity = userConverter.toEntity(user);
        userDao.update(id , entity);
    }

    public List<UserDto> findAll() {
        List<User> users = userDao.findAll();

        List<UserDto> userDto = new ArrayList<UserDto>();
        for(User user: users){
            UserDto dto = userConverter.toDto(user);
            userDto.add(dto);
    }

        return userDto;
    }


}
