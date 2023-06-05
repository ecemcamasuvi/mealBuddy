package com.moonu.mealbuddy.enums;

public enum ExceptionType {
    DB_CONNECTION_ERROR("001","Db bağlantısı sağlanamadı");

    public final String code;
    public final String message;


    private ExceptionType(String code, String message){
        this.code=code;
        this.message=message;
    }
}
