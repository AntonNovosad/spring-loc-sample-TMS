package org.example.dao.inMemoryDao;

import org.example.dao.UserDao;
import org.example.entity.User;

import java.util.ArrayList;
import java.util.List;


public class InMemoryUserDao implements UserDao {
    private static List<User> userList = new ArrayList<>();
    private static User userInSession;
    private static UserDao instance;
    private static int id = 1;

    public static UserDao getInstance() {
        if (instance == null) {
            instance = new InMemoryUserDao();
        }
        return instance;
    }

    @Override
    public void save(User user) {
        user.setId(id++);
        userList.add(user);
    }

    @Override
    public User get(String login, String password) {
        for (User user : userList) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public boolean contains(String login) {
        for (User user : userList) {
            if (user.getLogin().contains(login)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void setUserInSession(User user) {
        InMemoryUserDao.userInSession = user;
    }

    @Override
    public User getUserInSession() {
        return userInSession;
    }
}
