import javafx.application.Application;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import ua.skillsup.shop.jp1.dao.module.repository.impl.UserDaoImpl;
import ua.skillsup.shop.services.ProductServices;
import ua.skillsup.shop.services.UserServices;
import ua.skillsup.shop.services.dto.UserDto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Aleksey on 14.04.2018.
 */
public class Main {

    public static void main(String[] args) throws IOException{


        ApplicationContext context = new GenericXmlApplicationContext("context-main.xml");
        UserServices userService = context.getBean(UserServices.class);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String input = reader.readLine();
            String [] arguments = input.split( " ");

            if ("C".equals(arguments[0])) {
                UserDto dto = new UserDto(arguments[1], arguments[2], Integer.parseInt(arguments[3]));
                userService.create(dto);
                System.out.println("User has been created");
            }else if ("L".equals(arguments[0])){
                System.out.println("List of users");
                System.out.println(userService.findAll());
            }
        }


        //UserServices productService = context.getBean(ProductServices.class);


    }
}