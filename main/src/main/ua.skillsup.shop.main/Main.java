import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import ua.skillsup.shop.services.ProductService;
import ua.skillsup.shop.services.UserService;
import ua.skillsup.shop.services.dto.ProductDto;
import ua.skillsup.shop.services.dto.UserDto;
import ua.skillsup.shop.services.impl.UserServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Aleksey on 14.04.2018.
 */
public class Main {

    public static void main(String[] args) throws IOException{


        ApplicationContext context = new GenericXmlApplicationContext("context-main.xml");
        UserService userService = context.getBean(UserService.class);
        ProductService productService = context.getBean(ProductService.class);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String input = reader.readLine();
            String [] arguments = input.split( " ");

            if ("UC".equals(arguments[0])) {
                UserDto dtoUser = new UserDto(arguments[1], arguments[2], Integer.parseInt(arguments[3]));
                userService.create(dtoUser);
                System.out.println("User has been created");
            }
            if ("UL".equals(arguments[0])){
                System.out.println("List of users");
                System.out.println(userService.findAll());
            }
            if ("PC".equals(arguments[0])) {
                ProductDto dtoProduct = new ProductDto(arguments[1], Double.parseDouble(arguments[2]), arguments[3], arguments[4], arguments[5], Double.parseDouble(arguments[6]), Integer.parseInt(arguments[7]));
                productService.create(dtoProduct);
                System.out.println("Product has been created");
            }

            if ("PL".equals(arguments[0])) {
                System.out.println("List of products");
                System.out.println(productService.findAll());

            }
        }


    }
}
