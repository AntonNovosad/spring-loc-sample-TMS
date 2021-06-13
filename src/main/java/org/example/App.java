package org.example;

import org.example.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(RootConfiguration.class);
        UserService userService = applicationContext.getBean(UserService.class);
        userService.run();
    }
}
