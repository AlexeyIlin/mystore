package ua.skillsup.shop.services.converters;

import ua.skillsup.shop.jp1.dao.User;
import ua.skillsup.shop.services.dto.UserDto;

/**
 * Created by Aleksey on 14.04.2018.
 */
public interface UserConverter {

    User toEntity(UserDto dto);
    UserDto toDto(User entity);

}