package org.example;

import org.example.dao.HistoryOperationDao;
import org.example.dao.UserDao;
import org.example.dao.inMemoryDao.InMemoryHistoryOperationDao;
import org.example.dao.inMemoryDao.InMemoryUserDao;
import org.example.entity.User;
import org.example.entity.calculator.*;
import org.example.entity.command.Authorization;
import org.example.entity.command.Command;
import org.example.entity.command.Registration;
import org.example.service.CalculatorService;
import org.example.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
@ComponentScan(basePackages = "org.example")
public class RootConfiguration {

    @Bean
    public Map<String, Operation> getOperation(Operation addition, Operation subtraction, Operation multiply, Operation divide) {
        Map<String, Operation> operationMap = new HashMap<>();
        operationMap.put("1", addition);
        operationMap.put("2", subtraction);
        operationMap.put("3", multiply);
        operationMap.put("4", divide);
        return operationMap;
    }

    @Bean
    public Map<String, Command> getCommand(Command registration, Command authorization) {
        Map<String, Command> commandMap = new HashMap<>();
        commandMap.put("1", registration);
        commandMap.put("2", authorization);
        return commandMap;
    }

    @Bean
    public CalculatorService calculatorService() {
        return new CalculatorService();
    }

    @Bean
    public UserService userService() {
        return new UserService();
    }

    @Bean
    public UserDao userDao() {
        return InMemoryUserDao.getInstance();
    }

    @Bean
    public HistoryOperationDao historyOperationDao() {
        return InMemoryHistoryOperationDao.getInstance();
    }

    @Bean
    public User user() {
        return new User();
    }

    @Bean
    public Operation addition() {
        return new Addition();
    }

    @Bean
    public Operation subtraction() {
        return new Subtraction();
    }

    @Bean
    public Operation divide() {
        return new Divide();
    }

    @Bean
    public Operation multiply() {
        return new Multiply();
    }

    @Bean
    public Command registration() {
        return new Registration();
    }

    @Bean
    public Command authorization() {
        return new Authorization();
    }
}

