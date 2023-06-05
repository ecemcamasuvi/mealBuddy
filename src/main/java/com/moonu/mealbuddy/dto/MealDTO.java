package com.moonu.mealbuddy.dto;

import com.moonu.mealbuddy.entity.Meal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MealDTO {
    private String title;
    private boolean isActive;

    public static MealDTO from(Meal meal){
        MealDTO mealDTO = new MealDTO();
        mealDTO.setActive(meal.isActive());
        mealDTO.setTitle(meal.getTitle());
        return mealDTO;
    }
}
