package springCrud;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springCrud.config.HibernateConfig;
import springCrud.model.Sex;
import springCrud.model.User;
import springCrud.service.UserService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(HibernateConfig.class);
        UserService userService = applicationContext.getBean("userServiceImpl", UserService.class);
        List<User> userList = userService.getAllUsers();
        userList.forEach(System.out::println);
        System.out.println();

        User user = new User("Artur", "Ishmaev", (byte) 28, "Drink milk", Sex.Man);
        userService.updateUserById(4L, user);

        List<User> userList1 = userService.getAllUsers();
        userList1.forEach(System.out::println);
        System.out.println();
    }
}
