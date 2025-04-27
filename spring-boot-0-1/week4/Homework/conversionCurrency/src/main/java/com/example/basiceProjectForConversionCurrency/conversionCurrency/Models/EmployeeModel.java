package com.example.basiceProjectForConversionCurrency.conversionCurrency.Models;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Employee")
public class EmployeeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private BigDecimal salary_INR;
    private BigDecimal salary_USD;
    private BigDecimal salary_EUR;
    private BigDecimal salary_GBP;
}
