package com.moonu.mealbuddy.repository;

import com.moonu.mealbuddy.entity.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealRepository extends JpaRepository<Meal,Long> {

}
