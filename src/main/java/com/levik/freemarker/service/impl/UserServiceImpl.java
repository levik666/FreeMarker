package com.levik.freemarker.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.levik.freemarker.annotation.Service;
import com.levik.freemarker.model.User;
import com.levik.freemarker.service.UserService;

@Service(name = "userService")
public class UserServiceImpl implements UserService{

    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User("Larry", "Ellison"));
        users.add(new User("Steve", "Jobs"));
        users.add(new User("Scot", "Gates"));
    }

    @Override
    public void addUser(final User user) {
        users.add(user);
    }

    @Override
    public List<User> getUsers() {
        return users;
    }
}
