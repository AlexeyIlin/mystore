package ua.skillsup.shop.services.converters.impl;

import org.springframework.stereotype.Component;
import ua.skillsup.shop.web.dao.models.User;
import ua.skillsup.shop.services.converters.UserConverter;
import ua.skillsup.shop.services.dto.UserDto;

/**
 * Created by Aleksey on 14.04.2018.
 */
@Component
public class UserConverterImpl implements UserConverter {

    public User toEntity(UserDto dto){
        return new User(
            null,
            dto.getFirstName(),
            dto.getLastName(),
            dto.getAge()
        );
    }

    public UserDto toDto(User entity){
        return new UserDto(
                entity.getFirstName(),
                entity.getLastName(),
                entity.getAge()
        );
    }


}
