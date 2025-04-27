package com.example.basiceProjectForConversionCurrency.conversionCurrency.Repository;

import com.example.basiceProjectForConversionCurrency.conversionCurrency.Models.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<EmployeeModel,Long> {
}
