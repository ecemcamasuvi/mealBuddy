package com.moonu.mealbuddy.repository;

import com.moonu.mealbuddy.entity.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MealRepository extends JpaRepository<Meal,Long> {

    @Query("select count(t) " +
            " from Meal t ")
    int getMealCount();

}
