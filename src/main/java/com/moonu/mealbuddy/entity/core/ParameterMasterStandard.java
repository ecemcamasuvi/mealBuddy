package com.moonu.mealbuddy.entity.core;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@MappedSuperclass
@Getter
@Setter
public abstract class ParameterMasterStandard <ID extends Serializable> implements ParameterMaster<ID> {
    @Column(name = "description")
    protected String description;
}
