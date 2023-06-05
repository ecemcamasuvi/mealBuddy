package com.moonu.mealbuddy.exception;

import com.moonu.mealbuddy.enums.ExceptionType;

public class ExceptionMessage extends  RuntimeException {
    private String code;

    public String getCode(){
        return this.code;
    }

    public ExceptionMessage(ExceptionType exceptionType){
        super("Hata : " + exceptionType.code + " - " + exceptionType.message);
        this.code=exceptionType.code;
    }
}
