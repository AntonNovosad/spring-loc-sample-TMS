package org.example.dao;

import org.example.entity.User;

public interface UserDao {
    void save(User user);
    User get(String login, String password);
    boolean contains(String login);
    void setUserInSession(User user);
    User getUserInSession();
}
