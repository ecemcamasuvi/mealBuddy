package com.moonu.mealbuddy.service.implementation;

import com.moonu.mealbuddy.dto.MealDTO;
import com.moonu.mealbuddy.entity.Meal;
import com.moonu.mealbuddy.enums.ExceptionType;
import com.moonu.mealbuddy.exception.ExceptionMessage;
import com.moonu.mealbuddy.log.Logger;
import com.moonu.mealbuddy.repository.MealRepository;
import com.moonu.mealbuddy.service.MatchingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Random;

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

    @Override
    @Logger("random meal generator fired")
    public MealDTO getRandomMeal() {
        try{
            Long randomId = generateRandomId();
            return MealDTO.from(mealRepository.getById(randomId));
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    private int getMealCount() {
        try {
            return mealRepository.getMealCount();
        }
        catch(Exception e){
            throw new ExceptionMessage(ExceptionType.DB_CONNECTION_ERROR);
        }
    }

    @Override
    public Long generateRandomId(){
        Long lowerLimit = 0L;
        Long upperLimit = Long.valueOf(getMealCount());
        Random r = new Random();
        Long randomId = lowerLimit + ((long) (r.nextDouble() * (upperLimit - lowerLimit)));
        return randomId;
    }

}
