package com.moonu.mealbuddy.service.implementation;

import com.moonu.mealbuddy.dto.MealDTO;
import com.moonu.mealbuddy.entity.Meal;
import com.moonu.mealbuddy.repository.MealRepository;
import com.moonu.mealbuddy.service.MatchingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MatchingServiceImpl implements MatchingService {

    @Autowired
    private MealRepository mealRepository;

    @Override
    public List<MealDTO> getMealList() {
        List<Meal> mealList = mealRepository.findAll();
        List<MealDTO> mealDTOList = new ArrayList<>();
        for(Meal meal:mealList){
            mealDTOList.add(MealDTO.from(meal));
        }
        return mealDTOList;
    }
}
