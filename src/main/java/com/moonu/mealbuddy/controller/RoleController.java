package com.moonu.mealbuddy.controller;

import com.moonu.mealbuddy.entity.security.Role;
import com.moonu.mealbuddy.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/roles")
@RequiredArgsConstructor
public class RoleController {
    private final UserService userService;
    @PostMapping
    public Role save(@RequestBody Role role){
        return userService.save(role);
    }

}
