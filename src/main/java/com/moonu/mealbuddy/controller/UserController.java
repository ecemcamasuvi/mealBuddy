package com.moonu.mealbuddy.controller;

import com.moonu.mealbuddy.entity.security.User;
import com.moonu.mealbuddy.service.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping
    public List<User> list(){
        return userService.list();
    }

    @PostMapping
    public User save(@RequestBody User user){
        return userService.save(user);
    }

    @PatchMapping
    public void addRoles(@RequestBody AddRoleRequest request){
        userService.addRoleTo(request.getUsername(),request.getRole());
    }

    @Data
    class AddRoleRequest{
        private String username;
        private String role;
    }

}
