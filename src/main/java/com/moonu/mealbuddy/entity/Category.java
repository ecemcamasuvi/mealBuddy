package com.moonu.mealbuddy.entity;

import com.moonu.mealbuddy.entity.core.ParameterMasterStandard;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cache;

@Entity
@Getter
@Setter
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Table(name="category")
public class Category extends ParameterMasterStandard<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "generateMealType")
    @SequenceGenerator(name="generateMealType",sequenceName = "SEQ_CATEGORY",allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

}
