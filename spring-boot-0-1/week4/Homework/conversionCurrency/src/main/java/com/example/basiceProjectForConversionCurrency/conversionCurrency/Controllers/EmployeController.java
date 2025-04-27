package com.example.basiceProjectForConversionCurrency.conversionCurrency.Controllers;

import com.example.basiceProjectForConversionCurrency.conversionCurrency.Models.EmployeeModel;
import com.example.basiceProjectForConversionCurrency.conversionCurrency.Services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping(path = "/base/employee")
@RestController
public class EmployeController {

    private final EmployeeService employeeService;

    @GetMapping("/getAllEmployee")
   public List<EmployeeModel> getAllEmployee(){
      List<EmployeeModel> employeeModel=employeeService.getAllEmployee();
      return employeeModel;
  }

  @PostMapping("/saveEmployee")
  public EmployeeModel saveEmployee(@RequestBody EmployeeModel employeeModel){
        EmployeeModel employeeModel1=employeeService.saveEmployee(employeeModel);
        return employeeModel;
  }

  @PostMapping("/saveAllEmployee")
  public List<EmployeeModel> saveAllEmploye(@RequestBody List<EmployeeModel> employeeModelList){
      List<EmployeeModel> employeeModelList1=employeeService.saveAllEmployee(employeeModelList);
      return employeeModelList1;

  }



}
