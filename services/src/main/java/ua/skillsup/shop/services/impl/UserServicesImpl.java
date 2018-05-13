package ua.skillsup.shop.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.skillsup.shop.jp1.dao.User;
import ua.skillsup.shop.jp1.dao.module.repository.UserDao;
import ua.skillsup.shop.services.UserServices;
import ua.skillsup.shop.services.converters.UserConverter;
import ua.skillsup.shop.services.dto.UserDto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aleksey on 14.04.2018.
 */
@Service
public class UserServicesImpl implements UserServices{

    private final UserDao userDao;
    private final UserConverter userConverter;


    @Autowired
    public UserServicesImpl(UserDao userDao, UserConverter userConverter) {
        this.userDao = userDao;
        this.userConverter = userConverter;
    }

    public void  create(UserDto user){
        User userEntity = userConverter.toEntity(user);
        userDao.create(userEntity);
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
