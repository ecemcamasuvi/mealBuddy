package com.moonu.mealbuddy.service;

import com.moonu.mealbuddy.entity.security.Role;
import com.moonu.mealbuddy.entity.security.User;

import java.util.List;

public interface UserService {
    User save(User user);
    Role save(Role role);

    void addRoleTo(String username,String rolename);
    User get(String username);
    List<User> list();
}
