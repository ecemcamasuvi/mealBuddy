package com.moonu.mealbuddy.service;

import com.moonu.mealbuddy.dto.MealDTO;

import java.util.EmptyStackException;
import java.util.List;

public interface MatchingService {

    List<MealDTO> getMealList();
    MealDTO getRandomMeal();
    Long generateRandomId();

}
