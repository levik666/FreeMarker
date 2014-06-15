package com.levik.freemarker.service;

import java.util.List;

import com.levik.freemarker.model.User;

public interface UserService {

    public void addUser(User user);

    public List<User> getUsers();
}
