package org.example.entity.command;

import org.example.dao.UserDao;
import org.example.entity.User;
import org.example.service.CalculatorService;
import org.example.util.ConsoleReader;
import org.example.util.ConsoleWriter;
import org.springframework.beans.factory.annotation.Autowired;

public class Authorization implements Command {

    @Autowired
    private UserDao userDao;

    @Autowired
    private CalculatorService calculatorService;

    @Override
    public void action() {
        String username = ConsoleWriter.write("Enter username");
        String password = ConsoleWriter.write("Enter password");
        User user = userDao.get(username, password);
        if (user == null) {
            ConsoleReader.read("Username or password is wrong");
        } else {
            userDao.setUserInSession(user);
            calculatorService.run();
        }
    }
}
