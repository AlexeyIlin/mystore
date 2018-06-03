package ua.skillsup.shop.services;

import ua.skillsup.shop.services.dto.UserDto;

import java.util.List;

/**
 * Created by Aleksey on 14.04.2018.
 */
public interface UserServices {

    void create(UserDto user);
    void delete(Long id);
    void update(Long id, UserDto user);

    List<UserDto> findAll();

}
