package com.moonu.mealbuddy.entity;

import com.moonu.mealbuddy.entity.core.ParameterMasterStandard;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Getter
@Setter
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Table(name="meal_type")
public class MealType extends ParameterMasterStandard<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "generateMealType")
    @SequenceGenerator(name="generateMealType",sequenceName = "SEQ_MEAL_TYPE",allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

}
