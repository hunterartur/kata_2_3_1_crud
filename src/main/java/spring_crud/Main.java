package spring_crud;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring_crud.config.HibernateConfig;
import spring_crud.model.Sex;
import spring_crud.model.User;
import spring_crud.service.UserService;

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
