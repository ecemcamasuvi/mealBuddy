package com.moonu.mealbuddy.entity.core;

import java.io.Serializable;

public interface ParameterMaster <ID extends Serializable> {
    String getDescription();
    void setDescription(String description);
}
