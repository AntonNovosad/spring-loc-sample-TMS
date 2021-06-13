package org.example.entity.command;

import org.example.dao.UserDao;
import org.example.entity.User;
import org.example.util.ConsoleReader;
import org.example.util.ConsoleWriter;
import org.springframework.beans.factory.annotation.Autowired;

public class Registration implements Command {
    @Autowired
    UserDao userDao;


    @Override
    public void action() {
        String username = ConsoleWriter.write("Enter username");
        String password = ConsoleWriter.write("Enter password");
        String name = ConsoleWriter.write("Enter name");
        if (userDao.contains(username)) {
            ConsoleReader.read("This username is exist. Please enter another username");
        } else {
            userDao.save(new User(0, username, password, name));
            ConsoleReader.read("User created successful");
        }
    }
}
