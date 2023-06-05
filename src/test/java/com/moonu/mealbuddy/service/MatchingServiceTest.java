package com.moonu.mealbuddy.service;

import com.moonu.mealbuddy.enums.ExceptionType;
import com.moonu.mealbuddy.exception.ExceptionMessage;
import com.moonu.mealbuddy.service.implementation.MatchingServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class MatchingServiceTest {

    @Autowired
    private static MatchingService matchingService;

    @BeforeAll
    public  static void  set_up(){
        matchingService = new MatchingServiceImpl();
    }

    @Test
    public void test_generate_random_id_without_db_connection() throws EmptyStackException {
        Throwable exception = assertThrows(ExceptionMessage.class, () -> matchingService.generateRandomId());
        assertEquals(new ExceptionMessage(ExceptionType.DB_CONNECTION_ERROR).getMessage(), exception.getMessage());
    }
}