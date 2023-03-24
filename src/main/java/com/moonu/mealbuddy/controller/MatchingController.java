package com.moonu.mealbuddy.controller;


import com.moonu.mealbuddy.dto.MealDTO;
import com.moonu.mealbuddy.service.MatchingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/matching")
public class MatchingController {

    @Autowired
    private MatchingService matchingService;

    @GetMapping("/meal-list")
    public List<MealDTO> getMealList(){
        return matchingService.getMealList();
    }
}
