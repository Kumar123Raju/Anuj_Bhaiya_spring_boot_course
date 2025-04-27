package com.example.basiceProjectForConversionCurrency.conversionCurrency.Services;

import com.example.basiceProjectForConversionCurrency.conversionCurrency.Models.EmployeeModel;
import com.example.basiceProjectForConversionCurrency.conversionCurrency.RestClient.model.ResponseCurrencyDto;

import java.util.List;
import java.util.Map;

public interface EmployeeService {

    List<EmployeeModel> getAllEmployee();
    EmployeeModel saveEmployee(EmployeeModel employeeModel);
    List<EmployeeModel> saveAllEmployee(List<EmployeeModel> employeeModelList);
    Map<String,Double> getCurrency();
}
