package ua.skillsup.shop.web.controllers;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ua.skillsup.shop.services.UserServices;
import ua.skillsup.shop.services.dto.UserDto;

import java.awt.*;
import java.util.List;
import org.slf4j.Logger;

@Controller
@RequestMapping("/users")

public class UserControler {

    private final static  Logger log = LoggerFactory.getLogger(UserControler.class);
    private final UserServices userServices;

    @Autowired
    public UserControler(UserServices userServices){
        this.userServices = userServices;
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List <UserDto> findAll(){
        return userServices.findAll();
    }

    @RequestMapping(method = RequestMethod.POST , consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody UserDto user){
        log.info("Create user ", user);
        userServices.create(user);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        log.info("Delete user" , id);
        userServices.delete(id);
    }

    @RequestMapping(value = "{id}" ,
            method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void update(@PathVariable("id") Long id, @RequestBody UserDto user){
        log.info("Update user" , id, user);
        userServices.update(id, user);
    }
}
